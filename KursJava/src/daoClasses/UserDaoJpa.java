package daoClasses;

import javax.persistence.EntityManagerFactory;

import org.apache.openjpa.persistence.PersistenceException;

import model.User;

public class UserDaoJpa extends GenericDaoJpa<User> implements IDaoUser {

	public UserDaoJpa(EntityManagerFactory emf) {
		super(User.class, emf);
	}

	@Override
	public User getUserByMail(String mail) throws PersistenceException {
		String query = "Select x From users x where x.\"e-mail\"="+mail+";";
		return executeQuery(query,false,true,null);
	}

	@Override
	public User getUserByLogin(String login) throws PersistenceException {
		String query = "Select x From users x where x.\"login\"="+login+";";
		return executeQuery(query,false,true,null);
	}

	@Override
	public User findUserByLoginPass(String login, String pass)
			throws PersistenceException {
		String query ="SELECT x FROM User x WHERE(x.login like ?1)and(x.password like ?2)";
		
		return executeQuery(query, false, true, login,pass);
	}

}
