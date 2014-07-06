package org.fitnessgym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.dao.UserDAO;
import org.fitnessgym.model.User;
import org.fitnessgym.util.ScopeUtil;

/**
 *
 * @author vu
 */
@ManagedBean(name="instruction")
@ViewScoped
public class SpecialInstruction implements java.io.Serializable{

    private int userId;
    private String specialInstruction;
    private boolean flag = true;
    private Map<String, Integer> userMap;
    private List<User> list;
    private int TOTAL_ROWS;
    private ScopeUtil scopeUtil;

    @PostConstruct
    public void init() {
        scopeUtil=new  ScopeUtil();
        userMap = new HashMap<String, Integer>();
    }

    public void putFalse() {
        if (userId == 0) {
            flag = true;
        } else {
            GenericDAO<User> userDAO = new UserDAO();
            User u = (User) userDAO.findById(User.class, userId);
            specialInstruction = u.getSpecialInstruction();
            flag = false;
        }
    }

    public Map<String, Integer> getUserMap() {
        for (User u : getList()) {
            userMap.put(u.getUserLogin(), u.getUserId());
        }
        return userMap;
    }

    public void assignInstruction() {
        GenericDAO<User> userDAO = new UserDAO();
        User u = (User) userDAO.findById(User.class, userId);
        u.setSpecialInstruction(specialInstruction);
        userDAO.edit(u);
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Successfull"));
        reset();  // reset the page  
    }

    public List<User> getList() {
        GenericDAO<User> userDAO = new UserDAO();
        HttpSession session = scopeUtil.getSession(false);
        User u = (User) session.getAttribute("userInfo");
        list = userDAO.getList("From User  where user_instructor='" + u.getUserId() + "'");
        TOTAL_ROWS = list.size();
        return list;
    }
    
    public void reset(){ 
        flag=true;  
        userId=0;
        specialInstruction="";
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getTOTAL_ROWS() {
        return TOTAL_ROWS;
    }

    public void setTOTAL_ROWS(int TOTAL_ROWS) {
        this.TOTAL_ROWS = TOTAL_ROWS;
    }
    
    
    

}
