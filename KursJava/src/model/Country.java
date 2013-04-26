package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.JOINED;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@Table(schema = "public")
public class Country extends SystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private Integer maxsportsman;

	private String name;

	private Integer points;

	//bi-directional many-to-one association to Sportsman
	@OneToMany(mappedBy="country", cascade = ALL, fetch = EAGER)
	private List<Sportsman> sportsmans;

	public Country() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMaxsportsman() {
		return this.maxsportsman;
	}

	public void setMaxsportsman(Integer maxsportsman) {
		this.maxsportsman = maxsportsman;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public List<Sportsman> getSportsmans() {
		return this.sportsmans;
	}

	public void setSportsmans(List<Sportsman> sportsmans) {
		this.sportsmans = sportsmans;
	}

}