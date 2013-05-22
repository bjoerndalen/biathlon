package daoClasses;

import java.util.Collection;

import javax.persistence.EntityManagerFactory;

import org.apache.openjpa.persistence.PersistenceException;

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
		String query = "Select x From result x where x.idsportsman="+id+";";
		return executeQuery(query,false,false,null);
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

}
