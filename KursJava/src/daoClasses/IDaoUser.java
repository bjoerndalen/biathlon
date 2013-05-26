package daoClasses;

import model.User;

import org.apache.axis.constants.Use;
import org.apache.openjpa.persistence.PersistenceException;

public interface IDaoUser extends IGenericDao<User> {
public User getUserByMail(String mail) throws PersistenceException;
public User getUserByLogin(String login) throws PersistenceException;

public User findUserByLoginPass(String login, String pass) throws PersistenceException;
}
