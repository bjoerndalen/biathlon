package daoClasses;
/**
 * Класс абстрактной фабрики для DAO объектов.
 * Данный класс только содержит объявления для методов, возвращающих реализации
 * DAO интерфейсов. Сами же методы определены в конкретной реализации фабрики.
 * Данный класс содержит статические методы получения используемой фабрики.
 * 
 * 
 */
public abstract class DaoFactory {
	
	/** Фабрика, для интерфейсов dao, работающих с OpenJPA */
	public static final DaoFactory OPENJPA = new DaoFactoryJpa();
	
	/**Dao realization */
	
	public abstract IDaoCountry getCountryDao();
	
/**Dao realization */
	
	public abstract IDaoSportsman getSportsmanDao();
	
/**Dao realization */
	
	public abstract IDaoResult getResultDao();
	
/**Dao realization */
	
	public abstract IDaoRace getRaceDao();
	
/**Dao realization */
	
	public abstract IDaoReferee getRefereeDao();
	
/**Dao realization */
	
	public abstract IDaoCup getCupDao();
	
/**Dao realization */
	
	public abstract IDaoMessage getMessageDao();
	
/**Dao realization */
	
	public abstract IDaoUser getUserDao();

}
