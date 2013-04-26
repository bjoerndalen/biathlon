package service;

import java.util.Collection;

import javax.xml.rpc.ServiceException;


import model.Message;
import model.Referee;
import model.Sportsman;

public interface IMessageService extends IGenericService<Message> {
	public Collection<Message> getMessageBySportsman(Sportsman sportsman) throws ServiceException;
	public Collection<Message> getMessageByReferee(Referee ref) throws ServiceException;

}
