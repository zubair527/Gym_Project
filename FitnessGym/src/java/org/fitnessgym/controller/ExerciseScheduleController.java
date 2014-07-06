package org.fitnessgym.controller;

import java.io.InputStream;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.fitnessgym.dao.ExerciseDAO;
import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.model.ExerciseSchedule;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author vu
 */
@ManagedBean(name="exercise")
@RequestScoped
public class ExerciseScheduleController implements java.io.Serializable {

    private int esId;
    private String esDay;
    private String esGame;
    private String esNutrition;
    private String esVideo;

    public List<ExerciseSchedule> list;
    public int TOTAL_ROWS;
    private StreamedContent media;

    @PostConstruct
    public void init(){
        InputStream stream = this.getClass().getResourceAsStream("resources/media/test.flv");  
        media = new DefaultStreamedContent(stream, "video/flash");     
    }
    
    public List<ExerciseSchedule> getList(){
        GenericDAO<ExerciseSchedule> exerciseDAO=new ExerciseDAO();
        list=exerciseDAO.getList("From ExerciseSchedule");
        TOTAL_ROWS=list.size();
        return  list;
    }
    
    
    public int getEsId() {
        return esId;
    }

    public void setEsId(int esId) {
        this.esId = esId;
    }

    public String getEsDay() {
        return esDay;
    }

    public void setEsDay(String esDay) {
        this.esDay = esDay;
    }

    public String getEsGame() {
        return esGame;
    }

    public void setEsGame(String esGame) {
        this.esGame = esGame;
    }

    public String getEsNutrition() {
        return esNutrition;
    }

    public void setEsNutrition(String esNutrition) {
        this.esNutrition = esNutrition;
    }

    public String getEsVideo() {
        return esVideo;
    }

    public void setEsVideo(String esVideo) {
        this.esVideo = esVideo;
    }

    public int getTOTAL_ROWS() {
        return TOTAL_ROWS;
    }

    public void setTOTAL_ROWS(int TOTAL_ROWS) {
        this.TOTAL_ROWS = TOTAL_ROWS;
    }

    public StreamedContent getMedia() {
        return media;
    }

    public void setMedia(StreamedContent media) {
        this.media = media;
    }
    
    
    
}
