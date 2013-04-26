package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;


/**
 * The persistent class for the race database table.
 * 
 */
@Entity
public class Race extends SystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private Integer finishcount;

	private String racename;

	private Timestamp racetime;

	private String scene;

	private Integer startcount;

	//bi-directional many-to-one association to Cup
	@ManyToOne
	@JoinColumn(name="idcup")
	private Cup cup;

	//bi-directional many-to-one association to Referee
	@ManyToOne
	@JoinColumn(name="idreferee")
	private Referee referee;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="race", cascade = ALL, fetch = EAGER)
	private List<Result> results;

	public Race() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFinishcount() {
		return this.finishcount;
	}

	public void setFinishcount(Integer finishcount) {
		this.finishcount = finishcount;
	}

	public String getRacename() {
		return this.racename;
	}

	public void setRacename(String racename) {
		this.racename = racename;
	}

	public Timestamp getRacetime() {
		return this.racetime;
	}

	public void setRacetime(Timestamp racetime) {
		this.racetime = racetime;
	}

	public String getScene() {
		return this.scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public Integer getStartcount() {
		return this.startcount;
	}

	public void setStartcount(Integer startcount) {
		this.startcount = startcount;
	}

	public Cup getCup() {
		return this.cup;
	}

	public void setCup(Cup cup) {
		this.cup = cup;
	}

	public Referee getReferee() {
		return this.referee;
	}

	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}