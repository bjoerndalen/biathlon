package daoClasses;

import java.util.Collection;

import org.apache.openjpa.persistence.PersistenceException;

import model.Country;
import model.Sportsman;

public interface IDaoCountry extends IGenericDao<Country> {
public Country findByName(String name) throws PersistenceException;
public void updateCountry(Country cntr) throws PersistenceException;
public Collection<Sportsman> getAllSportsman() throws PersistenceException;
}
