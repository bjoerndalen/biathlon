package dist;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import daoClasses.IGenericDao;
import service.IGenericService;
import model.SystemEntity;

public abstract class DistGenericService<T extends SystemEntity> implements IGenericService<T> {

	/** Dao интерфейс для работы */
	protected IGenericDao<T> dao;

	
	/**
	 * Пустой конструктор, который получает dao
	 */
	public DistGenericService() {
		super();
		initDaoInterface();
	}

	/** Этот метод устанавливает {@link #dao} интерфейс для работы */
	protected abstract void initDaoInterface();

	/**
	 * Метод, который вызывается перед тем, как сущность добавляют или
	 * обновляют. Данный метод можно переопределить в подклассе для выполнения
	 * каких-либо проверок.
	 * 
	 * @param entity
	 *            Сущность, которая будет обновлена или добавлена
	 * @throws ServiceException
	 *             Если будет ошибка
	 */
	protected void beforeEntityAddUpdate(T entity) throws ServiceException {
	}

	/**
	 * Добавление новой сущности. Вызываем
	 * {@link #beforeEntityAddUpdate(DomainSuperClass)} перед выполнением
	 * каких-либо действий. После этого вызываем
	 * {@link #createNewEntityFromTheOneToAdd(DomainSuperClass)} для получения
	 * новой сущности из переданной в метод информации. Вызываем метод
	 * {@link IGenericDao#save(DomainSuperClass)} для сохранения сущности.
	 * 
	 * @param entity
	 *            Сущность типа T для добавления
	 * 
	 * @see IGenericService#addEntity(DomainSuperClass)
	 */
	public Integer addEntity(T entity) throws ServiceException {

		beforeEntityAddUpdate(entity);

		try {

			// Создаем новую сущность, которая будет сохранена в бд
			T newEntity = createNewEntityFromTheOneToAdd(entity);

			// Сохраняем сущность
			//log.info("Adding " + newEntity + "...");

			newEntity = dao.save(newEntity);

			if (newEntity != null)
				return newEntity.getId();
			else
				throw new ServiceException("Failed to add "
						+ entity.getClass().getSimpleName() + "");
		} catch (Exception e) {
			// Отлавливаем все runtime exceptions, которые могут произойти
			// при операциях. Возвращаем наш service exception в таком случае
			throw new ServiceException("Failed to add "
					+ entity.getClass().getSimpleName() + "", e);
		}
	}

	/**
	 * Создаем новую сущность на базе той информации, которая передана в
	 * newEntity
	 * 
	 * @param newEntity
	 *            Сущность, с информацией, которую надо сохранить
	 * @return Новая созданная сущность
	 */
	protected abstract T createNewEntityFromTheOneToAdd(T newEntity);

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.cn.stu.yet.gradingSys.services.IGenericService#delEntity(java.lang.Long)
	 */
	public void delEntity(Integer id) throws ServiceException, SecurityException {

		// Получаем сущность по id
		T savedEntity = getEntityById(id);

		try {
			// Удаляем сущность из БД
			//log.info("Deleting " + savedEntity + "...");

			dao.delete(savedEntity);
		} catch (Exception e) {
			// Отлавливаем все runtime exceptions, которые могут произойти
			// при операциях. Возвращаем наш service exception в таком случае
			throw new ServiceException(
					"Failed to delete "
							+ savedEntity.getClass().getSimpleName()
							+ " with id " + id, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.cn.stu.yet.gradingSys.services.IGenericService#getAllEntites()
	 */
	public Collection<T> getAllEntites() throws ServiceException,
			SecurityException {
		try {

			// Получаем все сущности
			//log.info("Getting all entities...");

			return dao.findAll();

		} catch (Exception e) {
			// Отлавливаем все runtime exceptions, которые могут произойти
			// при операциях. Возвращаем наш service exception в таком случае
			throw new ServiceException("Failed to get all entities", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.cn.stu.yet.gradingSys.services.IGenericService#getEntityById(java.lang.Long)
	 */
	public T getEntityById(Integer id) throws ServiceException {

		try {

			// Получаем сущность по id
			//log.info("Getting entity with id " + id + "...");

			T savedEntity = dao.findById(id);

			// Проверяем, получили ли мы сущность, которая не NULL и у которой
			// есть id
			if ((savedEntity == null) || (savedEntity.getId() == null))
				throw new Exception("Incorrect id " + id);

			return savedEntity;
		} catch (Exception e) {
			// Отлавливаем все runtime exceptions, которые могут произойти
			// при операциях. Возвращаем наш service exception в таком случае
			throw new ServiceException("Failed to get entity with id " + id, e);
		}
	}

	/**
	 * Обновление сущности. Вызываем
	 * {@link #beforeEntityAddUpdate(DomainSuperClass)} перед выполнением
	 * каких-либо действий. После этого вызываем
	 * {@link #updateEntityWithOneNewValues(DomainSuperClass, DomainSuperClass)}
	 * для обновления сущности информацией из переданной в метод сущности.
	 * Вызываем метод {@link IGenericDao#save(DomainSuperClass)} для сохранения
	 * сущности.
	 * 
	 * @see IGenericService#updateEntity(Long, DomainSuperClass)
	 */
	public void updateEntity(Integer id, T entity) throws ServiceException,
			SecurityException {

		beforeEntityAddUpdate(entity);

		try {

			// Getting saved entity by id
			T savedEntity = getEntityById(id);

			// Setting new values for saved entity
			updateEntityWithOneNewValues(savedEntity, entity);

			// Saving saved entity object
			//log.info("Updating " + savedEntity + "...");

			savedEntity = dao.save(savedEntity);

			if (savedEntity == null)
				throw new ServiceException("Failed to update "
						+ entity.getClass().getSimpleName() + " with id " + id);
		} catch (Exception e) {
			// Отлавливаем все runtime exceptions, которые могут произойти
			// при операциях. Возвращаем наш service exception в таком случае
			throw new ServiceException("Failed to update "
					+ entity.getClass().getSimpleName(), e);
		}
	}

	/**
	 * Обновляем инфомрацию для savedEntity из newEntity
	 * 
	 * @param savedEntity
	 *            Сохраненная сущность
	 * @param newEntity
	 *            Сущность с новой информацией
	 */
	protected abstract void updateEntityWithOneNewValues(T savedEntity,
			T newEntity);
	
	
}
