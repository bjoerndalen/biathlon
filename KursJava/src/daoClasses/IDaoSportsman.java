package daoClasses;

import java.util.Collection;

import org.apache.openjpa.persistence.PersistenceException;

import model.Message;
import model.Race;
import model.Referee;
import model.Result;
import model.Sportsman;

public interface IDaoSportsman extends IGenericDao<Sportsman> {
public Sportsman findByName(String name) throws PersistenceException;
public Collection<Message> getAllMessages(Integer id) throws PersistenceException;
public Collection<Result> getAllResults(Integer id) throws PersistenceException;
public Result getResultByRace(Race race,Integer id) throws PersistenceException;
public Collection<Message> getMessagesByReciever(Referee ref,Integer id) throws PersistenceException;
}
