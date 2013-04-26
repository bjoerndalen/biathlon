package service;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import model.SystemEntity;

public interface IGenericService<T extends SystemEntity>{
	
	/**
	 * Добавление сущности в базу
	 * 
	 * @param entity
	 *            Сущность типа T для добавления
	 * @return Уникальный идентификатор добавленной сущности
	 * @throws ServiceException
	 *             Если будет ошибка при выполнении метода
	 */
	public Integer addEntity(T entity) throws ServiceException;

	/**
	 * Удаление сущности из базы
	 * 
	 * @param id
	 *            Идентификатор сущности для удаления
	 * @throws ServiceException
	 *             ServiceException Если будет ошибка при выполнении метода
	 */
	public void delEntity(Integer id) throws ServiceException;

	/**
	 * Получение сущности по ее уникальному идентификатору
	 * 
	 * @param id
	 *            Идентификатор сущности для поиска
	 * @return Сущность типа T или null
	 * @throws ServiceException
	 *             Если будет ошибка при выполнении метода
	 */
	public T getEntityById(Integer id) throws ServiceException;

	/**
	 * Получаем все сущности
	 * 
	 * @return Коллекция всех сущностей типа T
	 * @throws ServiceException
	 *             Если будет ошибка при выполнении метода
	 */
	public Collection<T> getAllEntites() throws ServiceException;

	/**
	 * Обновляем сохраненную сущность с id новыми данными из entity
	 * 
	 * @param id
	 *            Идентификатор сущности для обновления
	 * @param entity
	 *            Сущность типа T с новой информацией
	 * @throws ServiceException
	 *             ServiceException Если будет ошибка при выполнении метода
	 */
	public void updateEntity(Integer id, T entity) throws ServiceException;
}
