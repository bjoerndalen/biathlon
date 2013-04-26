package daoClasses;

import java.util.Collection;

import javax.persistence.EntityManagerFactory;

import org.apache.openjpa.persistence.PersistenceException;

import model.Race;
import model.Referee;

public class RefereeDaoJpa extends GenericDaoJpa<Referee> implements IDaoReferee {

	public RefereeDaoJpa(EntityManagerFactory emf) {
		super(Referee.class, emf);
	}

	@Override
	public Referee getRefereeByName(String name) throws PersistenceException {
		String query = "Select x From referee x where x.fio="+name+";";
		return executeQuery(query,false,true,null);
	}

	@Override
	public Collection<Referee> getRefereesByCountry(String countryname)
			throws PersistenceException {
		String query = "Select x From referee x where x.contry="+countryname+";";
		return executeQuery(query,false,false,null);
	}

	@Override
	public Collection<Race> getAllRacesForReferee(Referee ref)
			throws PersistenceException {
		String query = "Select x From race x where x.idreferee="+ref.getId()+";";
		return executeQuery(query,false,false,null);
	}

}
