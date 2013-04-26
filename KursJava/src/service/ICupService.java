package service;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import model.Cup;
import model.Race;


public interface ICupService extends IGenericService<Cup> {

	public Cup getCupByName(String name) throws ServiceException;
	public Collection<Race> getRecesFromCup(Cup cup) throws ServiceException;
	public Collection<Cup> getCupByRating(Integer rating) throws ServiceException;

	
}
