package daoClasses;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;



import model.SystemEntity;

public abstract class GenericDaoJpa<T extends SystemEntity> {

	
	private static final String QUERY_SELECT_ALL = "SELECT x FROM %s x";

	private static final String QUERY_COUNT_ALL = "SELECT COUNT(x) FROM %s x";

	/** Entity manager factory that will be used for creating entity managers */
	protected EntityManagerFactory entityManagerFactory;

	/** Persistent class that this dao works with */
	protected Class<T> persistentClass;
	
	
	/**Construvtor with fields*/
	public GenericDaoJpa(Class<T> persistentClass, EntityManagerFactory emf) {
		super();
		this.persistentClass = persistentClass;
		this.entityManagerFactory = emf;
	}
	
	
	
	public void delete(T entity) throws PersistenceException {
		// Checking for null parameters
		if (entity == null) {
			throw new PersistenceException(
					"Entity for deleting cannot be null!");
		}

		// Creating entity manager to work with entity
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();

		try {

			// Finding entity by its id. If it is already loaded, it will not
			// travel to the db
			T savedEntity = entityManager.find(persistentClass, entity.getId());

			// Removing entity
			entityManager.remove(savedEntity);

			// Commit the transaction, which will cause the entity to
			// be stored in the database
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			// Catching exceptions and rollback of transaction
			entityManager.getTransaction().rollback();

			// throwing exception further
			throw new PersistenceException(e);

		} finally {

			// It is always good practice to close the EntityManager so that
			// resources are conserved.
			entityManager.close();

		}
	}
	
	
	public void delete(Integer entityId) throws PersistenceException {
		delete(findById(entityId));
	}
	
	
	public Collection<T> findAll() throws PersistenceException {
		return executeQuery(String.format(QUERY_SELECT_ALL, persistentClass.getSimpleName()), false, false);
	}
	
	
	public Long getAllCount() throws PersistenceException {
		return executeQuery(String.format(QUERY_COUNT_ALL, persistentClass.getSimpleName()), false, true);
	}
	
	
	
	public T findById(Integer id) throws PersistenceException {
		// Checking for null parameters
		if (id == null) {
			throw new PersistenceException(
					"Entity id for getting cannot be null!");
		}

		// Creating entity manager to work with entity
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();

		T savedEntity = null;

		try {

			// Finding entity by its id
			savedEntity = entityManager.find(persistentClass, id);

			// Commit the transaction, which will cause the entity to
			// be stored in the database
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			// Catching exceptions and rollback of transaction
			entityManager.getTransaction().rollback();

			// throwing exception further
			throw new PersistenceException(e);

		} finally {

			// It is always good practice to close the EntityManager so that
			// resources are conserved.
			entityManager.close();

		}

		return savedEntity;
	}
	
	
	public T save(T entity) throws PersistenceException {
		// Checking for null parameters
		if (entity == null) {
			throw new PersistenceException("Entity for saving cannot be null!");
		}

		// Creating entity manager to work with entity
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();

		T savedEntity = null;

		try {

			// Creating new entity, if id is null or merging the detached object
			// with the current state
			if (entity.getId() == null) {
				entityManager.persist(entity);
				savedEntity = entity;
			} else {
				savedEntity = entityManager.merge(entity);
			}

			// Commit the transaction, which will cause the entity to
			// be stored in the database
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			// Catching exceptions and rollback of transaction
			entityManager.getTransaction().rollback();

			// throwing exception further
			throw new PersistenceException(e);

		} finally {

			// It is always good practice to close the EntityManager so that
			// resources are conserved.
			entityManager.close();

		}

		return savedEntity;
	}
	
	
	@SuppressWarnings("unchecked")
	protected <REZ> REZ executeQuery(String queryOrQueryName,
			boolean namedQuery, boolean singleResult, Object... parameters)
			throws PersistenceException {

		// Creating entity manager to work with entity
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();

		REZ result;

		try {

			Query q;
			
			// Creating either named or simple query
			if (namedQuery) {
				q = entityManager.createNamedQuery(queryOrQueryName);
			} else {
				q = entityManager.createQuery(queryOrQueryName);
			}
			
			// Setting query parameters
			for (int i = 0; i < parameters.length; i++) {
				q.setParameter(i + 1, parameters[i]);
			}

			// Executing query
			if (singleResult) {
				
				List<?> list = q.getResultList();
				if (CollectionUtils.isNotEmpty(list)) {
					result = (REZ) list.get(0);
				} else {
					result = null;
				}

			} else {

				result = (REZ) q.getResultList();

			}

			// Commit the transaction, which will cause the entity to
			// be stored in the database
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			// Catching exceptions and rollback of transaction
			//entityManager.getTransaction().rollback();

			// throwing exception further
			throw new PersistenceException(e);

		} finally {

			// It is always good practice to close the EntityManager so that
			// resources are conserved.
			entityManager.close();

		}

		return result;
	}



	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}



	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	
}
