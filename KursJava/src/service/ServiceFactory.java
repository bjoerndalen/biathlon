package service;

import dist.DistServiceFactory;
import model.Country;
import model.Cup;
import model.Message;
import model.Race;
import model.Referee;
import model.Result;
import model.Sportsman;
import model.User;

public abstract class ServiceFactory {
	/** Фабрика, используемая по умолчанию */
	public static final ServiceFactory DEFAULT = new DistServiceFactory();
	public abstract ICountryService getCountryService();
	public abstract ISportsmanSevice getSportsmanService();
	public abstract IResultService getResultService();
	public abstract IRaceService getRaceService();
	public abstract ICupService getCupService();
	public abstract IRefereeService getRefereeService();
	public abstract IMessageService getMessageService();
	public abstract IUserService getUserService();
}
