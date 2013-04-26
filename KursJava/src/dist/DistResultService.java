package dist;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import org.apache.openjpa.persistence.PersistenceException;

import daoClasses.DaoFactory;
import daoClasses.IDaoResult;

import model.Race;
import model.Result;
import model.Sportsman;
import service.IResultService;

public class DistResultService extends DistGenericService<Result> implements IResultService {
protected IDaoResult resultDAO;
	@Override
	public Result getResultByRace(Race race, Sportsman sp)
			throws ServiceException {
		try{
			return this.resultDAO.getResultByRace(race, sp);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting result by race",e);
		}
	}

	@Override
	public Collection<Result> getAllResultsBySportsman(Sportsman sportsman)
			throws ServiceException {
		try{
			return this.resultDAO.getAllResultsBySportsman(sportsman);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting result by sportsman",e);
		}
	}

	@Override
	public Collection<Result> getAllResultsByRace(Race race)
			throws ServiceException {
		try{
			return this.resultDAO.getAllResultsByRace(race);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting result by race",e);
		}
	}

	@Override
	protected void initDaoInterface() {
		this.resultDAO = DaoFactory.OPENJPA.getResultDao();
		dao = this.resultDAO;
		return;
		
	}

	@Override
	protected Result createNewEntityFromTheOneToAdd(Result newEntity) {
		Result rslt = new Result();
		rslt.setAlltime(newEntity.getAlltime());
		rslt.setNewpoints(newEntity.getNewpoints());
		rslt.setPlace(newEntity.getPlace());
		rslt.setRace(newEntity.getRace());
		rslt.setShfalt(newEntity.getShfalt());
		rslt.setSportsman(newEntity.getSportsman());
		rslt.setTimewoshotting(newEntity.getTimewoshotting());
		return rslt;
	}

	@Override
	protected void updateEntityWithOneNewValues(Result savedEntity,
			Result newEntity) {
		if(newEntity.getAlltime()!=null){
			savedEntity.setAlltime(newEntity.getAlltime());
			}
			if(newEntity.getNewpoints()!=null){
			savedEntity.setNewpoints(newEntity.getNewpoints());
			}
			if(newEntity.getPlace()!=null){
			savedEntity.setPlace(newEntity.getPlace());
			}
			if(newEntity.getRace()!=null){
			savedEntity.setRace(newEntity.getRace());
			}
			if(newEntity.getShfalt()!=null){
			savedEntity.setShfalt(newEntity.getShfalt());
			}
			if(newEntity.getSportsman()!=null){
			savedEntity.setSportsman(newEntity.getSportsman());
			}
			if(newEntity.getTimewoshotting()!=null){
			savedEntity.setTimewoshotting(newEntity.getTimewoshotting());
			}
			return;
		
	}

	

}
