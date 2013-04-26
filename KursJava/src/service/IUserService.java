package service;

import javax.xml.rpc.ServiceException;

import model.User;


public interface IUserService extends IGenericService<User> {
	public User getUserByMail(String mail) throws ServiceException;
	public User getUserByLogin(String login) throws ServiceException;

}
