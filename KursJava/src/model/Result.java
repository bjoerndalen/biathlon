package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Time;


/**
 * The persistent class for the result database table.
 * 
 */
@Entity
public class Result extends SystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	@Temporal(TemporalType.TIME)
	private Time alltime;

	private Integer newpoints;

	private Integer place;

	private Integer shfalt;
	@Temporal(TemporalType.TIME)
	private Time timewoshotting;

	//bi-directional many-to-one association to Race
	@ManyToOne
	@JoinColumn(name="idrace")
	private Race race;

	//bi-directional many-to-one association to Sportsman
	@ManyToOne
	@JoinColumn(name="idsportsman")
	private Sportsman sportsman;

	public Result() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Time getAlltime() {
		return this.alltime;
	}

	public void setAlltime(Time alltime) {
		this.alltime = alltime;
	}

	public Integer getNewpoints() {
		return this.newpoints;
	}

	public void setNewpoints(Integer newpoints) {
		this.newpoints = newpoints;
	}

	public Integer getPlace() {
		return this.place;
	}

	public void setPlace(Integer place) {
		this.place = place;
	}

	public Integer getShfalt() {
		return this.shfalt;
	}

	public void setShfalt(Integer shfalt) {
		this.shfalt = shfalt;
	}

	public Time getTimewoshotting() {
		return this.timewoshotting;
	}

	public void setTimewoshotting(Time timewoshotting) {
		this.timewoshotting = timewoshotting;
	}

	public Race getRace() {
		return this.race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Sportsman getSportsman() {
		return this.sportsman;
	}

	public void setSportsman(Sportsman sportsman) {
		this.sportsman = sportsman;
	}

}