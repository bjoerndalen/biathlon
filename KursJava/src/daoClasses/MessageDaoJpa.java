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
		String query = "Select x From Message x where x.sportsman.id=?1";
		return executeQuery(query,false,false,sportsman.getId());
	}

	@Override
	public Collection<Message> getMessageByReferee(Referee ref)
			throws PersistenceException {
		String query = "Select x From Message x where x.referee.id=?1";
		return executeQuery(query,false,false,ref.getId());
	}

}
