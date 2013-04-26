package dist;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import org.apache.openjpa.persistence.PersistenceException;

import daoClasses.DaoFactory;
import daoClasses.IDaoCup;

import service.ICupService;
import model.*;
public class DistCupService extends DistGenericService<Cup> implements ICupService {
protected IDaoCup cupDao;
	@Override
	public Cup getCupByName(String name) throws ServiceException {
		try{
			return cupDao.getCupByName(name);
		}catch(PersistenceException e){
			throw new ServiceException("Failed to get cup by name",e);
		}
	}

	@Override
	public Collection<Race> getRecesFromCup(Cup cup) throws ServiceException {
		try{
			return cupDao.getRecesFromCup(cup);
		}catch(PersistenceException e){
			throw new ServiceException("Failed to get races by cup",e);
		}
	}

	@Override
	public Collection<Cup> getCupByRating(Integer rating)
			throws ServiceException {
		try{
			return cupDao.getCupByRating(rating);
		}catch(PersistenceException e){
			throw new ServiceException("Failed to get cup by rating",e);
		}
	}

	@Override
	protected void initDaoInterface() {
		this.cupDao = DaoFactory.OPENJPA.getCupDao();
		dao = this.cupDao;
		return;
		
	}

	@Override
	protected Cup createNewEntityFromTheOneToAdd(Cup newEntity) {
		Cup cp = new Cup();
		cp.setContrycount(newEntity.getContrycount());
		cp.setCupname(newEntity.getCupname());
		cp.setRacecount(newEntity.getRacecount());
		cp.setRaces(newEntity.getRaces());
		cp.setRating(newEntity.getRating());
		return cp;
	}

	@Override
	protected void updateEntityWithOneNewValues(Cup savedEntity, Cup newEntity) {
		if(newEntity.getContrycount()!=null){
			savedEntity.setContrycount(newEntity.getContrycount());
			}
			if(newEntity.getCupname()!=null){
			savedEntity.setCupname(newEntity.getCupname());
			}
			if(newEntity.getRacecount()!=null){
			savedEntity.setRacecount(newEntity.getRacecount());
			}
			if(newEntity.getRaces()!=null){
			savedEntity.setRaces(newEntity.getRaces());
			}
			if(newEntity.getRating()!=null){
			savedEntity.setRating(newEntity.getRating());
			}
			return;
		
	}

}
