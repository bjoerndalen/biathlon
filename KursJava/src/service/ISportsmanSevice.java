package service;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import org.apache.openjpa.persistence.PersistenceException;

import DBAdmin.ForNewUser;

import model.Message;
import model.Race;
import model.Referee;
import model.Result;
import model.Sportsman;

public interface ISportsmanSevice extends IGenericService<Sportsman>{
	public Sportsman findByName(String name) throws ServiceException;
	public Collection<Message> getAllMessages(Integer id) throws ServiceException;
	public Collection<Result> getAllResults(Integer id) throws ServiceException;
	public Result getResultByRace(Race race,Integer id) throws ServiceException;
	public Collection<Message> getMessagesByReciever(Referee ref,Integer id) throws ServiceException;
	public Sportsman getStortsmanByFIOPass(String fio, String pass) throws ServiceException;
	public Collection<ForNewUser> getSportsmansBySex(Boolean sex) throws ServiceException;
}
