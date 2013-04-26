package dist;

import java.util.Collection;


import javax.xml.rpc.ServiceException;
import org.apache.openjpa.persistence.PersistenceException;
import daoClasses.DaoFactory;
import daoClasses.IDaoCountry;

import service.ICountryService;
import model.Country;
import model.Sportsman;

public class DistCountryService extends DistGenericService<Country> implements ICountryService {
protected IDaoCountry countryDao;
	@Override
	public Country findByName(String name) throws ServiceException {
		try{
			return countryDao.findByName(name);
		}catch(PersistenceException e){
			throw new ServiceException("Failed to get Country by name",e);
		}
	}

	@Override
	public void updateCountry(Country cntr) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Sportsman> getAllSportsman() throws ServiceException {
		try{
			return this.countryDao.getAllSportsman();
		}catch(PersistenceException e){
			throw new ServiceException("Fail wile getting all sportsman from country",e);
		}
	}

	@Override
	protected void initDaoInterface() {
		this.countryDao = DaoFactory.OPENJPA.getCountryDao();
		dao = this.countryDao;
		return;
	}

	@Override
	protected Country createNewEntityFromTheOneToAdd(Country newEntity) {
		Country cntr = new Country();
		cntr.setMaxsportsman(newEntity.getMaxsportsman());
		cntr.setName(newEntity.getName());
		cntr.setPoints(newEntity.getPoints());
		cntr.setSportsmans(newEntity.getSportsmans());
		return cntr;
	}

	@Override
	protected void updateEntityWithOneNewValues(Country savedEntity,
			Country newEntity) {
		if(newEntity.getMaxsportsman()!=null){
			savedEntity.setMaxsportsman(newEntity.getMaxsportsman());
		}
		if(newEntity.getName()!=null){
			savedEntity.setName(newEntity.getName());
		}
		if(newEntity.getPoints()!=null){
			savedEntity.setPoints(newEntity.getPoints());
		}
		if(newEntity.getSportsmans()!=null){
			savedEntity.setSportsmans(newEntity.getSportsmans());
		}
	}

}
