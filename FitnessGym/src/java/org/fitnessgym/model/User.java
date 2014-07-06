package org.fitnessgym.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private int userId;
    private String cell;
    private String specialInstruction;
    private Date userDoe;
    private String userEmail;
    private float userHeight;
    private String userLogin;
    private String userName;
    private String userPassword;
    private String userType;
    private float userWeight;
    private List<BmiGraph> bmiGraphs;
    private User instructor;
    private List<User> instructors;
    private List<Mail> fromMail;
    private List<Mail> toMail;

    public User() {
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int UserId) {
        this.userId = UserId;
    }

    @Column(name = "cell")
    public String getCell() {
        return this.cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    @Column(name = "special_instruction")
    public String getSpecialInstruction() {
        return this.specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "user_doe")
    public Date getUserDoe() {
        return this.userDoe;
    }

    public void setUserDoe(Date userDoe) {
        this.userDoe = userDoe;
    }

    @Column(name = "user_email")
    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "user_height")
    public float getUserHeight() {
        return this.userHeight;
    }

    public void setUserHeight(float userHeight) {
        this.userHeight = userHeight;
    }

    @Column(name = "user_login")
    public String getUserLogin() {
        return this.userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Column(name = "user_name")
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "user_password")
    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Column(name = "user_type")
    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Column(name = "user_weight")
    public float getUserWeight() {
        return this.userWeight;
    }

    public void setUserWeight(float userWeight) {
        this.userWeight = userWeight;
    }

    public void setBmiGraphs(List<BmiGraph> bmiGraphs) {
        this.bmiGraphs = bmiGraphs;
    }

    //bi-directional many-to-one association to BmiGraph
    @OneToMany(mappedBy = "user")
    public List<BmiGraph> getBmiGraphs() {
        return this.bmiGraphs;
    }

    @ManyToOne
    @JoinColumn(name = "user_instructor")
    public User getInstructor() {
        return this.instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }

    //bi-directional many-to-one association to User
    @OneToMany(mappedBy = "instructor")
    public List<User> getInstructors() {
        return this.instructors;
    }

    public void setInstructors(List<User> instructors) {
        this.instructors = instructors;
    }

    @OneToMany(mappedBy = "from")
    public List<Mail> getFromMail() {
        return fromMail;
    }

    public void setFromMail(List<Mail> fromMail) {
        this.fromMail = fromMail;
    }

    @OneToMany(mappedBy = "to")
    public List<Mail> getToMail() {
        return toMail;
    }

    public void setToMail(List<Mail> toMail) {
        this.toMail = toMail;
    }
    
    
    

}
