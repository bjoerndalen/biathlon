package daoClasses;

import java.util.Collection;

import org.apache.openjpa.persistence.PersistenceException;

import model.Message;
import model.Referee;
import model.Sportsman;

public interface IDaoMessage extends IGenericDao<Message> {
public Collection<Message> getMessageBySportsman(Sportsman sportsman) throws PersistenceException;
public Collection<Message> getMessageByReferee(Referee ref) throws PersistenceException;
public Collection<Message> getInputMessageByReferee(Referee ref) throws PersistenceException;
public Collection<Message> getInputMessageBySportsman(Sportsman sp) throws PersistenceException;
}
