package daoClasses;

import java.util.Collection;

import javax.persistence.EntityManagerFactory;

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
		String query = "Select x From message x where x.idsportsman="+sportsman.getId()+";";
		return executeQuery(query,false,false,null);
	}

	@Override
	public Collection<Message> getMessageByReferee(Referee ref)
			throws PersistenceException {
		String query = "Select x From message x where x.idreferee="+ref.getId()+";";
		return executeQuery(query,false,false,null);
	}

}
