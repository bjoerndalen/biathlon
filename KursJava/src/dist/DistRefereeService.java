package dist;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import org.apache.openjpa.persistence.PersistenceException;

import daoClasses.DaoFactory;
import daoClasses.IDaoReferee;

import service.IRefereeService;
import model.Race;
import model.Referee;
public class DistRefereeService extends DistGenericService<Referee> implements IRefereeService{
protected IDaoReferee refereeDao;
	@Override
	public Referee getRefereeByName(String name) throws ServiceException {
		try{
			return this.refereeDao.getRefereeByName(name);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting referee by name",e);
		}
	}

	@Override
	public Collection<Referee> getRefereesByCountry(String countryname)
			throws ServiceException {
		try{
			return this.refereeDao.getRefereesByCountry(countryname);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting referee by contry",e);
		}
	}

	@Override
	public Collection<Race> getAllRacesForReferee(Referee ref)
			throws ServiceException {
		try{
			return this.refereeDao.getAllRacesForReferee(ref);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting races for referee",e);
		}
	}

	@Override
	protected void initDaoInterface() {
		this.refereeDao = DaoFactory.OPENJPA.getRefereeDao();
		dao = this.refereeDao;
		return;
		
	}
	@Override
	protected Referee createNewEntityFromTheOneToAdd(Referee newEntity) {
		Referee ref = new Referee();
		ref.setContry(newEntity.getContry());
		ref.setFio(newEntity.getFio());
		ref.setMessages(newEntity.getMessages());
		ref.setPassword(newEntity.getPassword());
		ref.setRaces(newEntity.getRaces());
		ref.setRang(newEntity.getRang());
		return ref;
	}

	@Override
	protected void updateEntityWithOneNewValues(Referee savedEntity,
			Referee newEntity) {
		if(newEntity.getContry()!=null){
			savedEntity.setContry(newEntity.getContry());
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
			if(newEntity.getRaces()!=null){
			savedEntity.setRaces(newEntity.getRaces());
			}
			if(newEntity.getRang()!=null){
			savedEntity.setRang(newEntity.getRang());
			}
			return;
		
	}

	@Override
	public Referee getRefByFIOPass(String fio, String pass)
			throws ServiceException {
		return DaoFactory.OPENJPA.getRefereeDao().findRefByLoginPass(fio, pass);
	}

}
