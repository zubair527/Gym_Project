package org.fitnessgym.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.dao.LinkDAO;
import org.fitnessgym.dao.MailDAO;
import org.fitnessgym.dao.UserDAO;
import org.fitnessgym.model.Link;
import org.fitnessgym.model.Mail;
import org.fitnessgym.model.User;

public class Test {

    public static void main(String[] args) {
        
        Iterator<Mail> it=getList().iterator();
        while(it.hasNext()){
            Mail m=it.next();
            System.out.println(m.getFrom().getUserName()+" - "+m.getDiscription());
        }
//        Iterator<User> it=getUsers().iterator();
//        while(it.hasNext()){
//            User m=it.next();
//            System.out.println(m.getUserName());
//        }

        
//        GenericDAO<User> g = new UserDAO();
}
    
        public static List<Mail> getList(){
        List<Mail> list=new ArrayList();
        GenericDAO<Mail> mailDAO = new MailDAO();
        list = mailDAO.getList("From Mail");
        return list;
    }
        public static List<User> getUsers(){
        List<User> list=new ArrayList();
        GenericDAO<User> userDAO = new UserDAO();
        list = userDAO.getList("From User");
        return list;
    }

    

}
