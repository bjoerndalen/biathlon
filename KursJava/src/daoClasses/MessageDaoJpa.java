package daoClasses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.collections.CollectionUtils;
import org.apache.openjpa.persistence.PersistenceException;

import model.Message;
import model.Referee;
import model.Sportsman;

public class MessageDaoJpa extends GenericDaoJpa<Message> implements IDaoMessage {

	public MessageDaoJpa(EntityManagerFactory emf) {
		super(Message.class, emf);
	}

	@Override
	public Collection<Message> getMessageBySportsman(Sportsman sportsman)
			throws PersistenceException {
		String query = "Select x From Message x where x.sportsman.id=?1";
		return executeQuery(query,false,false,sportsman.getId());
	}
@Override
	public Collection<Message> getInputMessageByReferee(Referee ref) {
	System.out.println("entered!!!");
	EntityManager entityManager = entityManagerFactory
			.createEntityManager();

	// Begin a new local transaction so that we can persist a new entity
	entityManager.getTransaction().begin();
	
	Collection<Message> input_mes= new ArrayList<Message>();
	try {

		Query q;
		
		// Creating either named or simple query
		q = entityManager.createNativeQuery("SELECT * FROM message_ref('"+ref.getId()+"','"+ref.getFio()+"');");
		
		// Executing query
		List<Object[]> result = null;
			 result= q.getResultList();
			 if(result.size()==0){
				 System.out.println("null messgaes!!");
				 return null;
			 }
			 Object[] rowData;
			 for(int i=0;i<result.size();i++){
				 rowData = result.get(i);
				 Message msg = new Message();
					msg.setReferee(ref);
					msg.setWhomname(ref.getFio());
					msg.setWhoname(rowData[0].toString());
					msg.setTextmsg(rowData[1].toString());
					input_mes.add(msg);
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
	public Collection<Message> getMessageByReferee(Referee ref)
			throws PersistenceException {
		String query = "Select x From Message x where x.referee.id=?1";
		return executeQuery(query,false,false,ref.getId());
	}

	@Override
	public Collection<Message> getInputMessageBySportsman(Sportsman sp)
			throws PersistenceException {
		System.out.println("entered!!!");
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();
		
		Collection<Message> input_mes= new ArrayList<Message>();
		try {

			Query q;
			
			// Creating either named or simple query
			q = entityManager.createNativeQuery("SELECT * FROM rating_men('"+sp.getId()+"','"+sp.getFio()+"');");
			
			// Executing query
			List<Object[]> result = null;
				 result= q.getResultList();
				 if(result.size()==0){
					 System.out.println("null messgaes!!");
					 return null;
				 }
				 Object[] rowData;
				 for(int i=0;i<result.size();i++){
					 rowData = result.get(i);
					 Message msg = new Message();
						msg.setSportsman(sp);
						msg.setWhomname(sp.getFio());
						msg.setWhoname(rowData[0].toString());
						msg.setTextmsg(rowData[1].toString());
						input_mes.add(msg);
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
