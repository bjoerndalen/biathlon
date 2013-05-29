package daoClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.openjpa.persistence.PersistenceException;

import DBAdmin.ForLastRace;
import DBAdmin.ForNewUser;

import model.User;

public class UserDaoJpa extends GenericDaoJpa<User> implements IDaoUser {

	public UserDaoJpa(EntityManagerFactory emf) {
		super(User.class, emf);
	}

	@Override
	public User getUserByMail(String mail) throws PersistenceException {
		String query = "Select x From users x where x.\"e-mail\"="+mail+";";
		return executeQuery(query,false,true,null);
	}

	@Override
	public User getUserByLogin(String login) throws PersistenceException {
		String query = "Select x From users x where x.\"login\"="+login+";";
		return executeQuery(query,false,true,null);
	}

	@Override
	public User findUserByLoginPass(String login, String pass)
			throws PersistenceException {
		String query ="SELECT x FROM User x WHERE(x.login like ?1)and(x.password like ?2)";
		
		return executeQuery(query, false, true, login,pass);
	}

	@Override
	public Collection<ForNewUser> getCountryRating()
			throws PersistenceException {
		System.out.println("entered!!!");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();
		
		Collection<ForNewUser> input_mes= new ArrayList<ForNewUser>();
		try {

			Query q;
			q = entityManager.createNativeQuery("SELECT * FROM \"Country_Rating\";");	
			// Creating either named or simple query
			// Executing query
			List<Object[]> result = null;
				 result= q.getResultList();
				 if(result.size()==0){
					 System.out.println("null messgaes!!");
					 return null;
				 }
				 Object[] rowData;
				 for(int i=0;i<result.size();i++){
					 System.out.println(i);
					 rowData = result.get(i);
					 ForNewUser item = new ForNewUser();
					 
					 item.setCntr(String.valueOf(i+1));
					 item.setPol(rowData[0].toString());
					 item.setRole(rowData[1].toString());
						input_mes.add(item);
				 }
				
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			// Catching exceptions and rollback of transaction
			entityManager.getTransaction().rollback();

			// throwing exception further
		} finally {

			// It is always good practice to close the EntityManager so that
			// resources are conserved.
			entityManager.close();

		}
		return input_mes;
	}

	@Override
	public Collection<ForLastRace> getLastRaceResults()
			throws PersistenceException {
		System.out.println("entered!!!");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();
		
		Collection<ForLastRace> input_mes= new ArrayList<ForLastRace>();
		try {

			Query q;
			q = entityManager.createNativeQuery("SELECT * FROM \"Last_Race\";");	
			// Creating either named or simple query
			// Executing query
			List<Object[]> result = null;
				 result= q.getResultList();
				 if(result.size()==0){
					 System.out.println("null messgaes!!");
					 return null;
				 }
				 Object[] rowData;
				 for(int i=0;i<result.size();i++){
					 System.out.println(i);
					 rowData = result.get(i);
					 ForLastRace item = new ForLastRace();
					 item.setPosition(rowData[0].toString());
					 item.setCntr(rowData[1].toString());
					 item.setName(rowData[2].toString());
					 item.setFault(rowData[3].toString());
					 item.setAlltime(rowData[4].toString());
						input_mes.add(item);
				 }
				
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			// Catching exceptions and rollback of transaction
			entityManager.getTransaction().rollback();

			// throwing exception further
		} finally {

			// It is always good practice to close the EntityManager so that
			// resources are conserved.
			entityManager.close();

		}
		return input_mes;
	}

	@Override
	public Collection<ForLastRace> getPointsRatingMen()
			throws PersistenceException {
		System.out.println("entered!!!");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();
		
		Collection<ForLastRace> input_mes= new ArrayList<ForLastRace>();
		try {

			Query q;
			q = entityManager.createNativeQuery("SELECT * FROM \"Rating wemen\";");	
			// Creating either named or simple query
			// Executing query
			List<Object[]> result = null;
				 result= q.getResultList();
				 if(result.size()==0){
					 System.out.println("null messgaes!!");
					 return null;
				 }
				 Object[] rowData;
				 for(int i=0;i<result.size();i++){
					 System.out.println(i);
					 rowData = result.get(i);
					 ForLastRace item = new ForLastRace();
					 
					 item.setPosition(String.valueOf(i+1));
					 item.setName(rowData[0].toString());
					 item.setCntr(rowData[2].toString());
					 item.setAlltime(rowData[1].toString());
						input_mes.add(item);
				 }
				
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			// Catching exceptions and rollback of transaction
			entityManager.getTransaction().rollback();

			// throwing exception further
		} finally {

			// It is always good practice to close the EntityManager so that
			// resources are conserved.
			entityManager.close();

		}
		return input_mes;
	}

	@Override
	public Collection<ForLastRace> getPointsRatingWomen()
			throws PersistenceException {
		System.out.println("entered!!!");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();
		
		Collection<ForLastRace> input_mes= new ArrayList<ForLastRace>();
		try {

			Query q;
			q = entityManager.createNativeQuery("SELECT * FROM \"Rating man\";");	
			// Creating either named or simple query
			// Executing query
			List<Object[]> result = null;
				 result= q.getResultList();
				 if(result.size()==0){
					 System.out.println("null messgaes!!");
					 return null;
				 }
				 Object[] rowData;
				 for(int i=0;i<result.size();i++){
					 System.out.println(i);
					 rowData = result.get(i);
					 ForLastRace item = new ForLastRace();
					 
					 item.setPosition(String.valueOf(i+1));
					 item.setName(rowData[0].toString());
					 item.setCntr(rowData[2].toString());
					 item.setAlltime(rowData[1].toString());
						input_mes.add(item);
				 }
				
			// Commit the transaction, which will cause the entity to
			// be stored in the database
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			// Catching exceptions and rollback of transaction
			entityManager.getTransaction().rollback();

			// throwing exception further
		} finally {

			// It is always good practice to close the EntityManager so that
			// resources are conserved.
			//entityManager.close();

		}
		return input_mes;
	}

}
