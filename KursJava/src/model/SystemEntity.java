package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the country database table.
 * 
 */
public class SystemEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;

	public SystemEntity() {
	}
	
	public Integer getId(){
		return this.id;
	}

}