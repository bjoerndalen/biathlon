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
		String query = "Select x From cup x where x.cupname="+name+";";
		return executeQuery(query,false,true,null);
	}

	@Override
	public Collection<Race> getRecesFromCup(Cup cup)
			throws PersistenceException {
		String query = "Select x From race x where x.idcup="+cup.getId()+";";
		return executeQuery(query,false,false,null);
	}

	@Override
	public Collection<Cup> getCupByRating(Integer rating)
			throws PersistenceException {
		String query = "Select x From cup x where x.rating>="+rating+";";
		return executeQuery(query,false,false,null);
	}

}
