package model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
public class Message extends SystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;

	private String textmsg;

	private String whomname;

	private String whoname;

	//bi-directional many-to-one association to Referee
	@ManyToOne
	@JoinColumn(name="idreferee")
	private Referee referee;

	//bi-directional many-to-one association to Sportsman
	@ManyToOne
	@JoinColumn(name="idsportsman")
	private Sportsman sportsman;

	public Message() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTextmsg() {
		return this.textmsg;
	}

	public void setTextmsg(String textmsg) {
		this.textmsg = textmsg;
	}

	public String getWhomname() {
		return this.whomname;
	}

	public void setWhomname(String whomname) {
		this.whomname = whomname;
	}

	public String getWhoname() {
		return this.whoname;
	}

	public void setWhoname(String whoname) {
		this.whoname = whoname;
	}

	public Referee getReferee() {
		return this.referee;
	}

	public void setReferee(Referee referee) {
		this.referee = referee;
	}

	public Sportsman getSportsman() {
		return this.sportsman;
	}

	public void setSportsman(Sportsman sportsman) {
		this.sportsman = sportsman;
	}

}