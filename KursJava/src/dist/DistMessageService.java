package dist;

import java.util.Collection;

import javax.xml.rpc.ServiceException;

import org.apache.openjpa.persistence.PersistenceException;

import daoClasses.DaoFactory;
import daoClasses.IDaoMessage;

import service.IMessageService;
import model.Message;
import model.Referee;
import model.Sportsman;

public class DistMessageService extends DistGenericService<Message> implements IMessageService {
protected IDaoMessage messageDao;
	@Override
	public Collection<Message> getMessageBySportsman(Sportsman sportsman)
			throws ServiceException {
		try{
			return messageDao.getMessageBySportsman(sportsman);
		}catch(PersistenceException e){
			throw new ServiceException("Failed to get message by sportsman",e);
		}
	}

	@Override
	public Collection<Message> getMessageByReferee(Referee ref)
			throws ServiceException {
		try{
			return messageDao.getMessageByReferee(ref);
		}catch(PersistenceException e){
			throw new ServiceException("Failed to get message by referee",e);
		}
	}

	@Override
	protected void initDaoInterface() {
		this.messageDao = DaoFactory.OPENJPA.getMessageDao();
		dao = this.messageDao;
		return;
		
	}

	@Override
	protected Message createNewEntityFromTheOneToAdd(Message newEntity) {
		Message msg = new Message();
		msg.setReferee(newEntity.getReferee());
		msg.setSportsman(newEntity.getSportsman());
		msg.setTextmsg(newEntity.getTextmsg());
		msg.setWhomname(newEntity.getWhomname());
		msg.setWhoname(newEntity.getWhoname());
		return msg;
	}

	@Override
	protected void updateEntityWithOneNewValues(Message savedEntity,
			Message newEntity) {
		if(newEntity.getReferee()!=null){
			savedEntity.setReferee(newEntity.getReferee());
			}
			if(newEntity.getSportsman()!=null){
			savedEntity.setSportsman(newEntity.getSportsman());
			}
			if(newEntity.getTextmsg()!=null){
			savedEntity.setTextmsg(newEntity.getTextmsg());
			}
			if(newEntity.getWhomname()!=null){
			savedEntity.setWhomname(newEntity.getWhomname());
			}
			if(newEntity.getWhoname()!=null){
			savedEntity.setWhoname(newEntity.getWhoname());
			}
			return;
		
	}

	@Override
	public Collection<Message> getInputMessageByReferee(Referee ref)
			throws ServiceException {
		try{
			return messageDao.getInputMessageByReferee(ref);
		}catch(PersistenceException e){
			throw new ServiceException("Failed to get message by referee",e);
		}
	}

}
