package org.fitnessgym.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exercise_schedule database table.
 * 
 */
@Entity
@Table(name="exercise_schedule")
@NamedQuery(name="ExerciseSchedule.findAll", query="SELECT e FROM ExerciseSchedule e")
public class ExerciseSchedule implements Serializable {
	private static final long serialVersionUID = 1L;
	private int esId;
	private String esDay;
	private String esGame;
	private String esNutrition;
	private String esVideo;

	public ExerciseSchedule() {
	}


	@Id
	@Column(name="es_id")
	public int getEsId() {
		return this.esId;
	}

	public void setEsId(int esId) {
		this.esId = esId;
	}


	@Column(name="es_day")
	public String getEsDay() {
		return this.esDay;
	}

	public void setEsDay(String esDay) {
		this.esDay = esDay;
	}


	@Column(name="es_game")
	public String getEsGame() {
		return this.esGame;
	}

	public void setEsGame(String esGame) {
		this.esGame = esGame;
	}


	@Column(name="es_nutrition")
	public String getEsNutrition() {
		return this.esNutrition;
	}

	public void setEsNutrition(String esNutrition) {
		this.esNutrition = esNutrition;
	}


	@Column(name="es_video")
	public String getEsVideo() {
		return this.esVideo;
	}

	public void setEsVideo(String esVideo) {
		this.esVideo = esVideo;
	}

}