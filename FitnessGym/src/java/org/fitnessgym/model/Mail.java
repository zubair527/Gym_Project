package org.fitnessgym.model;

/**
 *
 * @author vu
 */
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mail")
@NamedQuery(name = "Mail.findAll", query = "SELECT m FROM Mail m")

public class Mail implements java.io.Serializable {

    private int mailId;
    private User from;
    private User to;
    private String discription;
    private Date date;

    @Id
    @Column(name = "mail_id")
    public int getMailId() {
        return mailId;
    }

    public void setMailId(int mailId) {
        this.mailId = mailId;
    }

    @ManyToOne
    @JoinColumn(name="mail_from")
    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    @ManyToOne
    @JoinColumn(name="mail_to")
    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    @Column(name = "mail_discription")
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

//    @Temporal(TemporalType.DATE)
//    @Column(name="mail_date")
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

}
