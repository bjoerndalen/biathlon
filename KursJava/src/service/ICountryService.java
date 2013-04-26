package service;

import java.util.Collection;
import javax.xml.rpc.ServiceException;
import model.Country;
import model.Sportsman;

public interface ICountryService extends IGenericService<Country> {
	
	public Country findByName(String name) throws ServiceException;
	public void updateCountry(Country cntr) throws ServiceException;
	public Collection<Sportsman> getAllSportsman() throws ServiceException;


}
