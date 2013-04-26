package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.ALL;


/**
 * The persistent class for the cup database table.
 * 
 */
@Entity
@Table(schema = "public")
public class Cup extends SystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private Integer contrycount;

	private String cupname;

	private Integer racecount;

	private Integer rating;

	//bi-directional many-to-one association to Race
	@OneToMany(mappedBy="cup", fetch = EAGER, cascade = ALL)
	private List<Race> races;

	public Cup() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getContrycount() {
		return this.contrycount;
	}

	public void setContrycount(Integer contrycount) {
		this.contrycount = contrycount;
	}

	public String getCupname() {
		return this.cupname;
	}

	public void setCupname(String cupname) {
		this.cupname = cupname;
	}

	public Integer getRacecount() {
		return this.racecount;
	}

	public void setRacecount(Integer racecount) {
		this.racecount = racecount;
	}

	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public List<Race> getRaces() {
		return this.races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
	}

}