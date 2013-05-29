package daoClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.openjpa.persistence.PersistenceException;

import DBAdmin.ForNewUser;

import model.Message;
import model.Race;
import model.Referee;
import model.Result;
import model.Sportsman;

public class SportsmanDaoJpa extends GenericDaoJpa<Sportsman> implements IDaoSportsman {

	public SportsmanDaoJpa(	EntityManagerFactory emf) {
		super(Sportsman.class, emf);
		}

	@Override
	public Sportsman findByName(String name) throws PersistenceException {
		String query = "Select x From Sportsman x where x.fio like ?1";
		return executeQuery(query, false, true, name);
	}

	@Override
	public Collection<Message> getAllMessages(Integer id) throws PersistenceException {
		String query = "Select x From message x where x.idsportsman="+id+";";
		return executeQuery(query,false,false,null);
	}

	@Override
	public Collection<Result> getAllResults(Integer id) throws PersistenceException {
		String query = "Select x From Result x where x.sportsman.id=?1";
		return executeQuery(query,false,false,id);
	}

	@Override
	public Result getResultByRace(Race race,Integer id) throws PersistenceException {
		String query = "Select x From result x race r where x.idsportsman="+id+"AND r.id="+race.getId();
		return executeQuery(query,false,true,null);
	}

	@Override
	public Collection<Message> getMessagesByReciever(Referee ref, Integer id)
			throws PersistenceException {
		String query = "Select x From message x referee r where x.idsportsman="+id+"AND x.idreferee="+ref.getId();
		return executeQuery(query,false,false,null);
	}

	@Override
	public Sportsman findSportsmanByLoginPass(String login, String pass)
			throws PersistenceException {
		String query = "SELECT x FROM Sportsman x WHERE (x.fio like ?1) and (x.password like ?2)";
		
		return executeQuery(query, false, true, login, pass);
	}

	@Override
	public Collection<ForNewUser> getSportsmansBySex(Boolean sex)
			throws PersistenceException {
		System.out.println("entered!!!");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();
		
		Collection<ForNewUser> input_mes= new ArrayList<ForNewUser>();
		try {

			Query q;
			q = entityManager.createNativeQuery("SELECT * FROM rating_sex(?1);");	
			// Creating either named or simple query
			if(sex.booleanValue()==true){
				System.out.println("true");
				q.setParameter(1, true);
			}else{
				System.out.println("false");
				q.setParameter(1, false);
			}
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
					 
					 item.setCntr(rowData[0].toString());
					 item.setPol(rowData[1].toString());
					 item.setRole(rowData[2].toString());
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
}
