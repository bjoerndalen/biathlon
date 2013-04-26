package dist;

import java.sql.Timestamp;
import java.util.Collection;

import javax.xml.rpc.ServiceException;

import org.apache.openjpa.persistence.PersistenceException;

import daoClasses.DaoFactory;
import daoClasses.IDaoRace;

import model.Cup;
import model.Race;
import service.IRaceService;

public class DistRaceService extends DistGenericService<Race> implements IRaceService {
protected IDaoRace raceDao;

	@Override
	public Race getRaceByTime(Timestamp time) throws ServiceException {
		try{
			return this.raceDao.getRaceByTime(time);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting race by time",e);
		}
	}

	@Override
	public Collection<Race> getRacesByName(String name) throws ServiceException {
		try{
			return this.raceDao.getRacesByName(name);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting race by name",e);
		}
	}

	@Override
	public Collection<Race> getRacesByScene(String scene)
			throws ServiceException {
		try{
			return this.raceDao.getRacesByScene(scene);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting race by scene",e);
		}
	}

	@Override
	public Collection<Race> getRacesByCup(Cup cup) throws ServiceException {
		try{
			return this.raceDao.getRacesByCup(cup);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting race by cup",e);
		}
	}

	@Override
	protected void initDaoInterface() {
		this.raceDao = DaoFactory.OPENJPA.getRaceDao();
		dao = this.raceDao;
		return;
		
	}

	@Override
	protected Race createNewEntityFromTheOneToAdd(Race newEntity) {
		Race rc = new Race();
		rc.setCup(newEntity.getCup());
		rc.setFinishcount(newEntity.getFinishcount());
		rc.setRacename(newEntity.getRacename());
		rc.setRacetime(newEntity.getRacetime());
		rc.setReferee(newEntity.getReferee());
		rc.setResults(newEntity.getResults());
		rc.setScene(newEntity.getScene());
		rc.setStartcount(newEntity.getStartcount());
		return rc;
	}

	@Override
	protected void updateEntityWithOneNewValues(Race savedEntity, Race newEntity) {
		if(newEntity.getCup()!=null){
			savedEntity.setCup(newEntity.getCup());
			}
			if(newEntity.getFinishcount()!=null){
			savedEntity.setFinishcount(newEntity.getFinishcount());
			}
			if(newEntity.getRacename()!=null){
			savedEntity.setRacename(newEntity.getRacename());
			}
			if(newEntity.getRacetime()!=null){
			savedEntity.setRacetime(newEntity.getRacetime());
			}
			if(newEntity.getReferee()!=null){
			savedEntity.setReferee(newEntity.getReferee());
			}
			if(newEntity.getResults()!=null){
			savedEntity.setResults(newEntity.getResults());
			}
			if(newEntity.getScene()!=null){
			savedEntity.setScene(newEntity.getScene());
			}
			if(newEntity.getStartcount()!=null){
				savedEntity.setStartcount(newEntity.getStartcount());
				}
			return;
	}

	

}
