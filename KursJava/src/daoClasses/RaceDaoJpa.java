package daoClasses;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.EntityManagerFactory;

import model.Cup;
import model.Race;

import org.apache.openjpa.persistence.PersistenceException;

public class RaceDaoJpa extends GenericDaoJpa<Race> implements IDaoRace {

	public RaceDaoJpa(EntityManagerFactory emf) {
		super(Race.class, emf);
	}

	@Override
	public Race getRaceByTime(Timestamp time) throws PersistenceException {
		String query = "Select x From race x where x.racetime="+time+";";
		return executeQuery(query,false,true,null);
	}

	@Override
	public Collection<Race> getRacesByName(String name)
			throws PersistenceException {
		String query = "Select x From race x where x.racename="+name+";";
		return executeQuery(query,false,false,null);
	}

	@Override
	public Collection<Race> getRacesByScene(String scene)
			throws PersistenceException {
		String query = "Select x From race x where x.scene="+scene+";";
		return executeQuery(query,false,false,null);
	}

	@Override
	public Collection<Race> getRacesByCup(Cup cup) throws PersistenceException {
		String query = "Select x From race x where x.idcup="+cup.getId()+";";
		return executeQuery(query,false,false,null);
	}

}
