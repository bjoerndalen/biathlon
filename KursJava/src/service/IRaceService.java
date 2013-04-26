package service;

import java.sql.Timestamp;
import java.util.Collection;

import javax.xml.rpc.ServiceException;

import model.Cup;
import model.Race;


public interface IRaceService extends IGenericService<Race> {
	public Race getRaceByTime(Timestamp time) throws ServiceException;
	public Collection<Race> getRacesByName(String name) throws ServiceException;
	public Collection<Race> getRacesByScene(String scene) throws ServiceException;
	public Collection<Race> getRacesByCup(Cup cup) throws ServiceException;
	
}
