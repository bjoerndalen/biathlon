package daoClasses;

import java.util.Collection;

import model.SystemEntity;

import org.apache.openjpa.persistence.PersistenceException;

public interface IGenericDao<T extends SystemEntity> {
	/**
	 * Находим объект по его уникальному идентификатору
	 * 
	 * @param id
	 *            Уникальный идентификатор объекта
	 * @return Найденный объект или <code>null</code>
	 * @throws PersistenceException 
	 */
	T findById(Integer id) throws PersistenceException;

	/**
	 * Получаем коллекцию всех объектов
	 * 
	 * @return Коллекция всех объектов
	 * @throws PersistenceException 
	 */
	Collection<T> findAll() throws PersistenceException;

	/**
	 * Сохраняем новый объект в базу данных.
	 * 
	 * @param entity
	 *            Объект для сохранения
	 * @return Обработанный объект
	 * @throws PersistenceException 
	 */
	T save(T entity) throws PersistenceException;

	/**
	 * Удаление объекта из базы данных
	 * 
	 * @param entity
	 *            Объект для удаления
	 * @throws PersistenceException 
	 */
	void delete(T entity) throws PersistenceException;

	/**
	 * Получаем количество всех объектов
	 * @return Количество всех объектов
	 * @throws PersistenceException
	 */
	public Long getAllCount() throws PersistenceException;

	/**
	 * Удаление объекта из базы данных
	 * 
	 * @param entityId
	 *            Уникальный идентификатор объекта
	 * @throws PersistenceException 
	 */
	void delete(Integer entityId) throws PersistenceException;

}
