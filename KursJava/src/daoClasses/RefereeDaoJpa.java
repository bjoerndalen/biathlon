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
		String query = "Select x From Referee x where x.fio like ?1";
		return executeQuery(query,false,true,name);
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

	@Override
	public Referee findRefByLoginPass(String login, String pass)
			throws PersistenceException {
		String query ="SELECT x FROM Referee x WHERE (x.fio like ?1) and (x.password like ?2)";
		
		return executeQuery(query, false, true, login,pass);
	}

}
