package daoClasses;

import java.util.Collection;

import org.apache.openjpa.persistence.PersistenceException;

import model.Race;
import model.Referee;

public interface IDaoReferee extends IGenericDao<Referee> {
	public Referee getRefereeByName(String name) throws PersistenceException;
	public Collection<Referee> getRefereesByCountry(String countryname) throws PersistenceException;
	public Collection<Race> getAllRacesForReferee(Referee ref) throws PersistenceException;

}
