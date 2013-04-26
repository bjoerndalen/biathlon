package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.openjpa.persistence.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.derby.tools.sysinfo;

public class Laba4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Properties props = new Properties();
		//"org.postgresql.Driver", "jdbc:postgresql:./db", "postgres", "199355"
		props.put("openjpa.ConnectionURL","jdbc:postgresql://localhost:5432/Biathlon");
				props.put("openjpa.ConnectionDriverName","org.postgresql.Driver");
				props.put("openjpa.ConnectionUserName", "postgres");
				props.put("openjpa.ConnectionPassword", "199355");
				//props.put("openjpa.jdbc.SynchronizeMappings", "buildSchema");
				PersistenceProviderImpl pp = new PersistenceProviderImpl();
				EntityManagerFactory emf = pp.createEntityManagerFactory("Laba5Java", props);
				//String s = args[0];
				//saveEntities(emf);
				readEntities(emf);


	}

	private static void readEntities(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		try{
			Query q = em.createQuery("SELECT x FROM Country x");
			List<?> list = q.getResultList();
			
			
			if(CollectionUtils.isNotEmpty(list)){
			for (Object object : list) {
				Country ct = (Country)object;
				System.out.println("Country name:"+ct.getName());
				for (Sportsman s : ct.getSportsmans()) {
					System.out.println("Sportsman name: "+s.getFio());
			}
			}
			}
			
			em.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		
	}
		

	private static void saveEntities(EntityManagerFactory emf) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		
		try{
			Country cntr = new Country();
			cntr.setName("Gonduras");
			cntr.setMaxsportsman(10);
			cntr.setPoints(10);
			cntr.setId(12345);
			Sportsman sp = new Sportsman();
			sp.setFio("Shipulin");
			sp.setCountry(cntr);
			sp.setCups(1);
			sp.setId(121212);
			sp.setSex(false);
			sp.setPassword("1");
			sp.setShooting((float) 0.12);
			sp.setPoints(10);
			cntr.setSportsmans(new ArrayList<Sportsman>());
			cntr.getSportsmans().add(sp);
			em.persist(cntr);
			//em.flush();
			em.getTransaction().commit();
			
			
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		
	}

}
