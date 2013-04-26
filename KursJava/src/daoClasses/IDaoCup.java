package daoClasses;

import java.util.Collection;

import model.Cup;
import model.Race;

import org.apache.openjpa.persistence.PersistenceException;

public interface IDaoCup extends IGenericDao<Cup> {
public Cup getCupByName(String name) throws PersistenceException;
public Collection<Race> getRecesFromCup(Cup cup) throws PersistenceException;
public Collection<Cup> getCupByRating(Integer rating) throws PersistenceException;
}
