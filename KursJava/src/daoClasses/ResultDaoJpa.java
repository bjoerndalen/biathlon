package daoClasses;

import java.util.Collection;

import javax.persistence.EntityManagerFactory;

import model.Race;
import model.Result;
import model.Sportsman;

import org.apache.openjpa.persistence.PersistenceException;

public class ResultDaoJpa extends GenericDaoJpa<Result> implements IDaoResult {

	public ResultDaoJpa(EntityManagerFactory emf) {
		super(Result.class, emf);
	}

	@Override
	public Result getResultByRace(Race race, Sportsman sp) throws PersistenceException {
		String query = "Select x From result x where x.idrace="+race.getId()+"AND x.idsportsman="+sp.getId()+";";
		return executeQuery(query,false,true,null);
	}

	@Override
	public Collection<Result> getAllResultsBySportsman(Sportsman sportsman)
			throws PersistenceException {
		String query = "Select x From result x where x.idsportsman="+sportsman.getId()+";";
		return executeQuery(query,false,false,null);
	}

	@Override
	public Collection<Result> getAllResultsByRace(Race race)
			throws PersistenceException {
		String query = "Select x From Result x where x.race.id=?1 ORDER BY x.place";
		return executeQuery(query,false,false,race.getId());
	}

}
