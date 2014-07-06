package org.fitnessgym.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.fitnessgym.model.User;
import org.fitnessgym.util.ScopeUtil;

@ManagedBean(name="pageController")
@RequestScoped
/**
 *
 * @author vu
 */
public class PageController implements java.io.Serializable {

    private  static String url = "member/blank";

    public void navigation(String path) {
        url = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        PageController.url = url;
    }
    
    public String logout(){
        ScopeUtil scopeUtil=new ScopeUtil();
        scopeUtil.getSession(false).invalidate();
        return "index?faces-redirect=true";
        
    }

    
}
