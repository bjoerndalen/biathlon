package service;

import java.util.Collection;

import javax.xml.rpc.ServiceException;


import model.Race;
import model.Result;
import model.Sportsman;

public interface IResultService extends IGenericService<Result> {
	public Result getResultByRace(Race race,Sportsman sp) throws ServiceException;
	public Collection<Result> getAllResultsBySportsman(Sportsman sportsman) throws ServiceException;
	public Collection<Result> getAllResultsByRace(Race race) throws ServiceException;

}
