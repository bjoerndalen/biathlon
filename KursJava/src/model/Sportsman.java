package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.ALL;


/**
 * The persistent class for the sportsman database table.
 * 
 */
@Entity
public class Sportsman extends SystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private Integer cups;

	private String fio;

	private String password;

	private Integer points;

	private Boolean sex;

	private float shooting;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="sportsman", fetch = EAGER, cascade = ALL)
	private List<Message> messages;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="sportsman", fetch = EAGER, cascade = ALL)
	private List<Result> results;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="idcontry")
	private Country country;

	public Sportsman() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCups() {
		return this.cups;
	}

	public void setCups(Integer cups) {
		this.cups = cups;
	}

	public String getFio() {
		return this.fio;
	}

	public void setFio(String fio) {
		this.fio = fio;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPoints() {
		return this.points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public float getShooting() {
		return this.shooting;
	}

	public void setShooting(float shooting) {
		this.shooting = shooting;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}