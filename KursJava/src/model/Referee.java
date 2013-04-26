package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.CascadeType.ALL;


/**
 * The persistent class for the referee database table.
 * 
 */
@Entity
public class Referee extends SystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private String contry;

	private String fio;

	private String password;

	private String rang;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="referee")
	private List<Message> messages;

	//bi-directional many-to-one association to Race
	@OneToMany(mappedBy="referee", fetch = EAGER, cascade = ALL)
	private List<Race> races;

	public Referee() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContry() {
		return this.contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
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

	public String getRang() {
		return this.rang;
	}

	public void setRang(String rang) {
		this.rang = rang;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Race> getRaces() {
		return this.races;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
	}

}