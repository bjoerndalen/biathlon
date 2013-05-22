package daoClasses;

import java.util.Collection;

import javax.persistence.EntityManagerFactory;

import org.apache.openjpa.persistence.PersistenceException;

import model.Cup;
import model.Race;

public class CupDaoJpa extends GenericDaoJpa<Cup> implements IDaoCup {

	public CupDaoJpa(EntityManagerFactory emf) {
		super(Cup.class, emf);
	}

	@Override
	public Cup getCupByName(String name) throws PersistenceException {
		String query = "Select x From Cup x where x.cupname like ?1";
		return executeQuery(query,false,true,name);
	}

	@Override
	public Collection<Race> getRecesFromCup(Cup cup)
			throws PersistenceException {
		String query = "Select x From Race x where x.cup.id=?1";
		return executeQuery(query,false,false,cup.getId());
	}

	@Override
	public Collection<Cup> getCupByRating(Integer rating)
			throws PersistenceException {
		String query = "Select x From cup x where x.rating>="+rating+";";
		return executeQuery(query,false,false,null);
	}

}
