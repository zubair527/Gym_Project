package org.fitnessgym.controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.dao.MailDAO;
import org.fitnessgym.dao.UserDAO;
import org.fitnessgym.model.Mail;
import org.fitnessgym.model.User;
import org.fitnessgym.util.ScopeUtil;

/**
 *
 * @author vu
 */
@ManagedBean(name = "mail")
@ViewScoped
public class MailController extends GenericController<Mail> implements java.io.Serializable {

    private int mailId;
    private User from;
    private User to;
    private String discription;
    private List<Mail> mailList;
   private List<Mail> sendList;
    private ScopeUtil scopeUtil;
    private boolean flag = false;
    private String userName;
    private int userIndexId;

    @PostConstruct
    public void init() {
        scopeUtil = new ScopeUtil();
    }

    public List<Mail> getMailList() {
        GenericDAO<Mail> mailDAO = new MailDAO();
        HttpSession session = scopeUtil.getSession(false);
        User u = (User) session.getAttribute("userInfo");
        mailList = mailDAO.getList("From Mail  where mail_to='" + u.getUserId() + "'");
//        list=mailDAO.getList("From Mail");
        TOTAL_ROWS = mailList.size();
        return mailList;
    }

    public List<Mail> getSendList() {
        GenericDAO<Mail> mailDAO = new MailDAO();
        HttpSession session = scopeUtil.getSession(false);
        User u = (User) session.getAttribute("userInfo");
        mailList = mailDAO.getList("From Mail  where mail_from='" + u.getUserId() + "'");
//        list=mailDAO.getList("From Mail");
        TOTAL_ROWS = mailList.size();
        return mailList;
    }

    public void showEditor(Mail m) {
        flag = true;
        userName = m.getFrom().getUserName();
        userIndexId = m.getFrom().getUserId();
        //System.out.println(m.getFrom().getUserName());
    }

    public void sendMail() {
        if (userName == null || userIndexId == 0) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please Select Member First", ""));
        }
        if (discription.equals("")) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Message Cant be empty", ""));
        } else {
            HttpSession session = scopeUtil.getSession(false);
            GenericDAO<Mail> mailDAO = new MailDAO();
//        Mail m = (Mail) mailDAO.findById(Mail.class, mailId);
            Mail m = new Mail();
            User toUser = new User();
            User fromUser = new User();
            toUser.setUserId(userIndexId);
            fromUser.setUserId(((User) session.getAttribute("userInfo")).getUserId());
            m.setTo(toUser);     // saving the status of To user
            m.setFrom(fromUser); // saving the status of  send by user
            m.setDiscription(discription);
            mailDAO.add(m);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mail has been sent", ""));
            reset();
        }
    }

    public void reset() {
        flag = false;
        discription = "";
        userName = "";
    }

    public MailController() {

    }

    public int getMailId() {
        return mailId;
    }

    public void setMailId(int mailId) {
        this.mailId = mailId;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserIndexId() {
        return userIndexId;
    }

    public void setUserIndexId(int userIndexId) {
        this.userIndexId = userIndexId;
    }

}
