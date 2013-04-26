package daoClasses;

import java.util.Collection;

import javax.persistence.EntityManagerFactory;

import org.apache.openjpa.persistence.PersistenceException;

import model.Country;
import model.Sportsman;

public class CountryDaoJpa extends GenericDaoJpa<Country> implements IDaoCountry {

	public CountryDaoJpa(EntityManagerFactory emf) {
		super(Country.class, emf);
	}

	@Override
	public Country findByName(String name) throws PersistenceException {
		String query = "Select x From country x where x.name="+name+";";
		return executeQuery(query, false, true, null);
	}

	@Override
	public void updateCountry(Country cntr) throws PersistenceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Sportsman> getAllSportsman() throws PersistenceException {
		String query = "Select x From country x, sportsman s where x.id=s.idcontry;";
		return executeQuery(query,false,false,null);
	}

}
