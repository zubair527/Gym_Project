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
@WebService(name = "FGS",targetNamespace = "http://fitnessgym/")
public interface FGS {

    @WebMethod(operationName = "authenticate")
    public User authenticate(@WebParam(name = "param1") String userId, @WebParam(name = "param2") String password);

    @WebMethod(operationName = "todayGame")
    public String todayGame();

    @WebMethod(operationName = "todayDiet")
    public String todayDiet();

    @WebMethod(operationName = "getSpecialInstruction")
    public String getSpecialInstruction(@WebParam(name = "param1") int id);

    @WebMethod(operationName = "updateInfo")
    public boolean updateInfo(@WebParam(name = "param1") User u);

    @WebMethod(operationName = "getInfo")
    public User getInfo(@WebParam(name = "param1") int id);
}
