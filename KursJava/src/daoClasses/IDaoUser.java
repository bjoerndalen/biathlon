package daoClasses;

import model.User;

import org.apache.openjpa.persistence.PersistenceException;

public interface IDaoUser extends IGenericDao<User> {
public User getUserByMail(String mail) throws PersistenceException;
public User getUserByLogin(String login) throws PersistenceException;
}
