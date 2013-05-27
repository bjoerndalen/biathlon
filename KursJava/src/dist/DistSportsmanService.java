package dist;

import java.util.Collection;


import javax.xml.rpc.ServiceException;

import model.Message;
import model.Race;
import model.Referee;
import model.Result;
import model.Sportsman;

import org.apache.openjpa.persistence.PersistenceException;

import DBAdmin.ForNewUser;

import service.ISportsmanSevice;

import daoClasses.DaoFactory;
import daoClasses.IDaoSportsman;

public class DistSportsmanService extends DistGenericService<Sportsman> implements ISportsmanSevice{
protected IDaoSportsman sportsmanDao;

	@Override
	protected void initDaoInterface() {
		this.sportsmanDao = DaoFactory.OPENJPA.getSportsmanDao();
		dao = this.sportsmanDao;
		return;
		
	}

	@Override
	protected Sportsman createNewEntityFromTheOneToAdd(Sportsman newEntity) {
		Sportsman sp = new Sportsman();
		sp.setCountry(newEntity.getCountry());
		sp.setCups(newEntity.getCups());
		sp.setFio(newEntity.getFio());
		sp.setMessages(newEntity.getMessages());
		sp.setPassword(newEntity.getPassword());
		sp.setPoints(newEntity.getPoints());
		sp.setResults(newEntity.getResults());
		sp.setSex(newEntity.getSex());
		sp.setShooting(newEntity.getShooting());
		return sp;
	}

	@Override
	protected void updateEntityWithOneNewValues(Sportsman savedEntity,
			Sportsman newEntity) {
		if(newEntity.getCountry()!=null){
		savedEntity.setCountry(newEntity.getCountry());
		}
		if(newEntity.getCups()!=null){
		savedEntity.setCups(newEntity.getCups());
		}
		if(newEntity.getFio()!=null){
		savedEntity.setFio(newEntity.getFio());
		}
		if(newEntity.getMessages()!=null){
		savedEntity.setMessages(newEntity.getMessages());
		}
		if(newEntity.getPassword()!=null){
		savedEntity.setPassword(newEntity.getPassword());
		}
		if(newEntity.getPoints()!=null){
		savedEntity.setPoints(newEntity.getPoints());
		}
		if(newEntity.getResults()!=null){
		savedEntity.setResults(newEntity.getResults());
		}
		if(newEntity.getSex()!=null){
		savedEntity.setSex(newEntity.getSex());
		}
		if(newEntity.getShooting()!=0.00){
		savedEntity.setShooting(newEntity.getShooting());
		}
		return;
	}

	@Override
	public Sportsman findByName(String name) throws ServiceException {
		try{
			return this.sportsmanDao.findByName(name);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while finding sportsman by name",e);
		}
	}

	@Override
	public Collection<Message> getAllMessages(Integer id)
			throws ServiceException {
		try{
			return this.sportsmanDao.getAllMessages(id);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting messages",e);
		}
	}

	@Override
	public Collection<Result> getAllResults(Integer id) throws ServiceException {
		try{
			return this.sportsmanDao.getAllResults(id);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting results",e);
		}
	}

	@Override
	public Result getResultByRace(Race race, Integer id)
			throws ServiceException {
		try{
			return this.sportsmanDao.getResultByRace(race, id);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting result by race",e);
		}
	}

	@Override
	public Collection<Message> getMessagesByReciever(Referee ref, Integer id)
			throws ServiceException {
		try{
			return this.sportsmanDao.getMessagesByReciever(ref, id);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting messages by reciver",e);
		}
	}

	@Override
	public Sportsman getStortsmanByFIOPass(String fio, String pass)
			throws ServiceException {
		return DaoFactory.OPENJPA.getSportsmanDao().findSportsmanByLoginPass(fio, pass);
	}

	@Override
	public Collection<ForNewUser> getSportsmansBySex(Boolean sex)
			throws ServiceException {
		try{
			return this.sportsmanDao.getSportsmansBySex(sex);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting sportsmans by sex",e);
		}
	}

	

}
