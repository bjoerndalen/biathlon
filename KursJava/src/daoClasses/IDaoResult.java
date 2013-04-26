package daoClasses;

import java.util.Collection;

import org.apache.openjpa.persistence.PersistenceException;

import model.Race;
import model.Result;
import model.Sportsman;

public interface IDaoResult extends IGenericDao<Result> {
public Result getResultByRace(Race race,Sportsman sp) throws PersistenceException;
public Collection<Result> getAllResultsBySportsman(Sportsman sportsman) throws PersistenceException;
public Collection<Result> getAllResultsByRace(Race race) throws PersistenceException;
}
