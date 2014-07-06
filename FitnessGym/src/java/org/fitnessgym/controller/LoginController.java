package org.fitnessgym.controller;

import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.dao.UserDAO;
import org.fitnessgym.model.User;
import org.fitnessgym.util.ScopeUtil;

@ManagedBean
@RequestScoped
public class LoginController implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String loginId;
    private String password;

    public String authenticate() {
        ScopeUtil scopeUtil = new ScopeUtil();
        String redirect = "";
        loginId = "test";
        password = "123";
        boolean loop = true;
        GenericDAO<User> userDAO = new UserDAO();
        List<User> list = userDAO.getList("from User");
        Iterator<User> it = list.iterator();
        while (it.hasNext() && loop) {
            User u = it.next();
            if (loginId.equals(u.getUserLogin()) && password.equals(u.getUserPassword())) {
                HttpSession session=scopeUtil.getSession(true);
                session.setAttribute("userInfo",u);
                redirect = "Home?faces-redirect=true";
                loop = false;  // will break loop
            }
        }
        if (loop) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Username or password is incorrect"));
        }
        return redirect;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
