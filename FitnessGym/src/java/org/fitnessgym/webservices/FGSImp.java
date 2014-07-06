package org.fitnessgym.webservices;

import java.util.Iterator;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.fitnessgym.dao.ExerciseDAO;
import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.dao.UserDAO;
import org.fitnessgym.model.ExerciseSchedule;
import org.fitnessgym.model.User;

/**
 *
 * @author vu
 */
@WebService(serviceName = "FitnessServices", portName = "fitnessport",
        targetNamespace = "http://fitnessgym/",
        endpointInterface = "org.fitnessgym.webservices.FGS")
public class FGSImp implements FGS {

    @Override
    public User authenticate(String userId, String password) {
        String redirect = "";
        boolean loop = true;
        GenericDAO<User> userDAO = new UserDAO();
        User user = null;
        List<User> list = userDAO.getList("from User");
        Iterator<User> it = list.iterator();
        while (it.hasNext() && loop) {
            User u = it.next();
            if (userId.equals(u.getUserLogin()) && password.equals(u.getUserPassword())) {
                user = u;
                loop = false;  // will break loop
            }
        }
        return user;
    }

    @Override
    public String todayGame() {
        GenericDAO<ExerciseSchedule> exerciseDAO = new ExerciseDAO();
        ExerciseSchedule es = (ExerciseSchedule) exerciseDAO.findById(ExerciseSchedule.class, 3);
        return es.getEsGame();
    }

   @Override
    public String todayDiet() {
        GenericDAO<ExerciseSchedule> exerciseDAO = new ExerciseDAO();
        ExerciseSchedule es = (ExerciseSchedule) exerciseDAO.findById(ExerciseSchedule.class, 3);
        return es.getEsNutrition();
    }

    @Override
    public String getSpecialInstruction(int id) {
        GenericDAO<User> userDAO = new UserDAO();
        User u = (User) userDAO.findById(User.class, id);
        return u.getSpecialInstruction();
    }

    @Override
    public boolean updateInfo(User u) {
        return false;
    }

    @Override
    public User getInfo(int id) {
        GenericDAO<User> userDAO = new UserDAO();
        User u = (User) userDAO.findById(User.class, id);
        return u;
    }
}
