package service;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import model.Race;
import model.Referee;


public interface IRefereeService extends IGenericService<Referee> {
	public Referee getRefereeByName(String name) throws ServiceException;
	public Collection<Referee> getRefereesByCountry(String countryname) throws ServiceException;
	public Collection<Race> getAllRacesForReferee(Referee ref) throws ServiceException;
	
	public Referee getRefByFIOPass(String fio, String pass)throws ServiceException;


}
