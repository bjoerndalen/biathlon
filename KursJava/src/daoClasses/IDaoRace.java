package daoClasses;

import java.sql.Timestamp;
import java.util.Collection;

import org.apache.openjpa.persistence.PersistenceException;

import model.Cup;
import model.Race;

public interface IDaoRace extends IGenericDao<Race>{
	public Race getRaceByTime(Timestamp time) throws PersistenceException;
	public Collection<Race> getRacesByName(String name) throws PersistenceException;
	public Collection<Race> getRacesByScene(String scene) throws PersistenceException;
	public Collection<Race> getRacesByCup(Cup cup) throws PersistenceException;
	}
