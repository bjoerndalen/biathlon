package DBAdmin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import model.Country;
import model.Referee;
import model.Sportsman;

import org.apache.commons.collections.CollectionUtils;
import org.apache.openjpa.persistence.PersistenceProviderImpl;
import org.postgresql.*;

public class DBAdminWorking {
	private static DBAdminWorking _singletone;
	private EntityManagerFactory emf;
	
	private DBAdminWorking(){
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
	public static DBAdminWorking getInstance(){
		if(_singletone==null){
			_singletone = new DBAdminWorking();
		}
		return _singletone;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Country> getCountry(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<?> list=null;
		
		try{
			Query q = em.createQuery("SELECT x FROM Country x");
			list = q.getResultList();		
			em.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return (Collection<Country>) list;
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Country getCountrybyName(String name){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<?> list=null;
		
		try{
			Query q = em.createQuery("SELECT x FROM Country x WHERE x.name= ?1");
			q.setParameter(1, name);
			list = q.getResultList();		
			em.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return (Country) list.get(0);
		
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Sportsman> getSportsman(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<?> list=null;
		
		try{
			Query q = em.createQuery("SELECT x FROM Sportsman x");
			list = q.getResultList();		
			em.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return (Collection<Sportsman>) list;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Collection<Referee> getReferee(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<?> list=null;
		
		try{
			Query q = em.createQuery("SELECT x FROM Referee x");
			list = q.getResultList();		
			em.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return (Collection<Referee>) list;
	}
	
	
	public void addSportsman(String fio,Country cntr,String password,boolean sex){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		
		try{
		Sportsman sp = new Sportsman();
		//sp.setId(id);
		sp.setFio(fio);
		sp.setPassword(password);
		sp.setSex(sex);
		sp.setShooting((float) 0.0);
		sp.setPoints(0);
		sp.setCups(1);
		sp.setCountry(cntr);
		if(cntr.getSportsmans()==null){
			cntr.setSportsmans(new ArrayList<Sportsman>());
		}
		cntr.getSportsmans().add(sp);
		em.merge(cntr);
		em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			//em.getTransaction().rollback();
		}finally{
			em.close();
		}
	}
	
	public boolean  delSportsmanByName(String name){
		EntityManager em = emf.createEntityManager();
		boolean ok=false;
		em.getTransaction().begin();
		List<?> list=null;
		try{
			Query q = em.createQuery("SELECT x FROM Sportsman x WHERE x.fio= ?1");
			q.setParameter(1, name);
			list = q.getResultList();		
			Sportsman sp = (Sportsman) list.get(0);
			if(list!=null){
			em.remove(sp);
			ok=true;
			em.getTransaction().commit();
			}
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
	}
		return ok;
	}
	
	public void addReferee(String fio,String password, String country){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try{
			Referee rf = new Referee();
			rf.setContry(country);
			rf.setFio(fio);
			rf.setPassword(password);
			rf.setRaces(null);
			rf.setMessages(null);
			rf.setRang("");
			//rf.setId(333);
			em.persist(rf);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
			}
	}
	
	public boolean delRefereeByName(String name){
		EntityManager em = emf.createEntityManager();
		boolean ok=false;
		em.getTransaction().begin();
		List<?> list=null;
		try{
			Query q = em.createQuery("SELECT x FROM Referee x WHERE x.fio= ?1");
			q.setParameter(1, name);
			list = q.getResultList();		
			Referee ref = (Referee) list.get(0);
			if(list!=null){
			em.remove(ref);
			ok=true;
			em.getTransaction().commit();
			}
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
	}
		return ok;
	}
	

}
