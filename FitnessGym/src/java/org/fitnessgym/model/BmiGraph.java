package org.fitnessgym.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bmi_graph database table.
 * 
 */
@Entity
@Table(name="bmi_graph")
public class BmiGraph implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ubId;
	private String userBmi;
	private User user;

	public BmiGraph() {
	}


	@Id
	@Column(name="bmi_id")
	public int getUbId() {
		return this.ubId;
	}

	public void setUbId(int ubId) {
		this.ubId = ubId;
	}


	@Column(name="user_bmi")
	public String getUserBmi() {
		return this.userBmi;
	}

	public void setUserBmi(String userBmi) {
		this.userBmi = userBmi;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}