package daoClasses;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;

import org.apache.openjpa.persistence.PersistenceProviderImpl;

public class DaoFactoryJpa extends DaoFactory {

	
	
	//private static final String LOGGIN_ID = "commons";
		//private static final String PERSISTENT_UNIT_DOIT = "doit-fast";
		
		//private static final String JPA_LOG = "jpa.Log";

		//private static final String DATABASE_PROPERTIES = "database.properties";

		/** Entity manager factory that will create EntityManager objects for dao */
		private EntityManagerFactory emf;
		
		/** Log to use */
		//private Log log = LogFactory.getLog(getClass());

		/**
		 * Constructor that will initialize EntityManagerFactory
		 * 
		 * @throws RuntimeException
		 */
		public DaoFactoryJpa(){
			super();
			try {
				initEntityManagerFactory();
			} catch (PersistenceException e) {
				throw new RuntimeException(e);
			}
		}

		/**
		 * Initializing entity manager factory, with specifying properties from
		 * external property file
		 * 
		 * @throws PersistenceException
		 *             If error occurs
		 */
		private void initEntityManagerFactory() throws PersistenceException {
			try {
				//log.debug("Loading db connection properties from " + DATABASE_PROPERTIES);
				
				Properties props = new Properties();
				//"org.postgresql.Driver", "jdbc:postgresql:./db", "postgres", "199355"
				props.put("openjpa.ConnectionURL","jdbc:postgresql://localhost:5432/Biathlon");
						props.put("openjpa.ConnectionDriverName","org.postgresql.Driver");
						props.put("openjpa.ConnectionUserName", "postgres");
						props.put("openjpa.ConnectionPassword", "199355");
						//props.put("openjpa.jdbc.SynchronizeMappings", "buildSchema");
						PersistenceProviderImpl pp = new PersistenceProviderImpl();
						emf = pp.createEntityManagerFactory("Laba5Java", props);
				
			} catch (Exception e) {
				throw new PersistenceException(
						"Failed to create EntityManagerFactory", e);
			}
			
			if (emf == null) {
				throw new PersistenceException(
						"EntityManagerFactory was not created. See log for details.");
			}
		}
	
	
	
	
	@Override
	public IDaoCountry getCountryDao() {
		return new CountryDaoJpa(emf);
	}

	@Override
	public IDaoSportsman getSportsmanDao() {
		return new SportsmanDaoJpa(emf);
	}

	@Override
	public IDaoResult getResultDao() {
		return new ResultDaoJpa(emf);
	}

	@Override
	public IDaoRace getRaceDao() {
		return new RaceDaoJpa(emf);
	}

	@Override
	public IDaoReferee getRefereeDao() {
		return new RefereeDaoJpa(emf);
	}

	@Override
	public IDaoCup getCupDao() {
		return new CupDaoJpa(emf);
	}

	@Override
	public IDaoMessage getMessageDao() {
		return new MessageDaoJpa(emf);
	}

	@Override
	public IDaoUser getUserDao() {
		return new UserDaoJpa(emf);
	}

}
