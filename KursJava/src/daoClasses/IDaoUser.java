package daoClasses;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import model.User;

import org.apache.axis.constants.Use;
import org.apache.openjpa.persistence.PersistenceException;

import DBAdmin.ForLastRace;
import DBAdmin.ForNewUser;

public interface IDaoUser extends IGenericDao<User> {
public User getUserByMail(String mail) throws PersistenceException;
public User getUserByLogin(String login) throws PersistenceException;
public Collection<ForNewUser> getCountryRating() throws PersistenceException;
public User findUserByLoginPass(String login, String pass) throws PersistenceException;
public Collection<ForLastRace> getLastRaceResults() throws PersistenceException;
public Collection<ForLastRace> getPointsRatingMen() throws PersistenceException;
public Collection<ForLastRace> getPointsRatingWomen() throws PersistenceException;
}
