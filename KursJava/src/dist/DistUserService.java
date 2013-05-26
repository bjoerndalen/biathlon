package dist;

import javax.xml.rpc.ServiceException;

import org.apache.openjpa.persistence.PersistenceException;

import daoClasses.DaoFactory;
import daoClasses.IDaoUser;

import service.IUserService;
import model.User;
public class DistUserService extends DistGenericService<User> implements IUserService {
protected IDaoUser userDao;
	@Override
	public User getUserByMail(String mail) throws ServiceException {
		try{
			return this.userDao.getUserByMail(mail);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting user by mail",e);
		}
	}

	@Override
	public User getUserByLogin(String login) throws ServiceException {
		try{
			return this.userDao.getUserByLogin(login);
		}catch(PersistenceException e){
			throw new ServiceException("Fail while getting user by login",e);
		}
	}

	@Override
	protected void initDaoInterface() {
		this.userDao = DaoFactory.OPENJPA.getUserDao();
		dao = this.userDao;
		return;
		
	}

	@Override
	protected User createNewEntityFromTheOneToAdd(User newEntity) {
		User user = new User();
		user.setE_mail(newEntity.getE_mail());
		user.setLogin(newEntity.getLogin());
		user.setPassword(newEntity.getPassword());
		return user;
	}

	@Override
	protected void updateEntityWithOneNewValues(User savedEntity, User newEntity) {
		if(newEntity.getLogin()!=null){
			savedEntity.setLogin(newEntity.getLogin());
			}
			if(newEntity.getE_mail()!=null){
			savedEntity.setE_mail(newEntity.getE_mail());
			}
			if(newEntity.getPassword()!=null){
			savedEntity.setPassword(newEntity.getPassword());
			}
			return;
		
	}

	@Override
	public User getUserByLoginPass(String login, String pass)
			throws SecurityException {
		return DaoFactory.OPENJPA.getUserDao().findUserByLoginPass(login, pass);
	}

}
