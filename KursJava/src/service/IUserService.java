package service;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import org.apache.openjpa.persistence.PersistenceException;

import DBAdmin.ForLastRace;
import DBAdmin.ForNewUser;

import model.User;


public interface IUserService extends IGenericService<User> {
	public User getUserByMail(String mail) throws ServiceException;
	public User getUserByLogin(String login) throws ServiceException;
	public User getUserByLoginPass(String login,String pass) throws SecurityException;
	public Collection<ForNewUser> getCountryRating() throws ServiceException;
	public Collection<ForLastRace> getLastRaceResults() throws ServiceException;
	public Collection<ForLastRace> getPointsRatingMen() throws ServiceException;
	public Collection<ForLastRace> getPointsRatingWomen() throws ServiceException;

}