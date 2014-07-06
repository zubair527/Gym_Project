package org.fitnessgym.converter;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.dao.UserDAO;
import org.fitnessgym.model.User;

/**
 *
 * @author vu
 */
public class UserConverter implements Converter {

    private static List<User> list;

    static {
        GenericDAO<User> userDao = new UserDAO();
        list = userDao.getList("From User");
    }

    public UserConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (User userList : list) {
                    if (userList.getUserId() == number) {
                        return userList;
                    }
                }

            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid User"));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((User) value).getUserId());
        }
    }

    public static List<User> getList() {
        return list;
    }

    public static void setList(List<User> list) {
        UserConverter.list = list;
    }
    
}
