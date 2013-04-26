package DBReferee;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Country;
import model.Cup;
import model.Race;

import org.apache.openjpa.persistence.PersistenceProviderImpl;



public class DBRefereeWorking {
	private static DBRefereeWorking _singletone;
	private EntityManagerFactory emf;
	
	private DBRefereeWorking(){
		Properties props = new Properties();
		//"org.postgresql.Driver", "jdbc:postgresql:./db", "postgres", "199355"
		props.put("openjpa.ConnectionURL","jdbc:postgresql://localhost:5432/Biathlon");
				props.put("openjpa.ConnectionDriverName","org.postgresql.Driver");
				props.put("openjpa.ConnectionUserName", "postgres");
				props.put("openjpa.ConnectionPassword", "199355");
				//props.put("openjpa.jdbc.SynchronizeMappings", "buildSchema");
				PersistenceProviderImpl pp = new PersistenceProviderImpl();
				emf = pp.createEntityManagerFactory("Laba5Java", props);
	}
	
	public static DBRefereeWorking getInstance(){
		if(_singletone==null){
			_singletone = new DBRefereeWorking();
			}
		return _singletone;
	}
	
	
	@SuppressWarnings("unchecked")
	public Collection<Cup> getAllCups(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<?> list=null;
		
		try{
			Query q = em.createQuery("SELECT x FROM Cup x");
			list = q.getResultList();		
			em.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return (Collection<Cup>) list;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Collection<Race> getAllRaces(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<?> list=null;
		
		try{
			Query q = em.createQuery("SELECT x FROM Race x");
			list = q.getResultList();		
			em.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return (Collection<Race>) list;
	}
	
	
	@SuppressWarnings("unchecked")
	public Collection<Race> getAllRacesInCup(String cupname){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<?> list=null;
		
		try{
			Query q = em.createQuery("SELECT x FROM Race x, Cup c WHERE x.idcup=c.id AND c.cupname=?1");
			q.setParameter(1, cupname);
			list = q.getResultList();		
			em.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return (Collection<Race>) list;
	}
	
	
	
}
