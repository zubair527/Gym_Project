package org.fitnessgym.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.dao.UserDAO;
import org.fitnessgym.model.Link;
import org.fitnessgym.model.User;

/**
 *
 * @author vu
 */
public class GenericController<E> implements java.io.Serializable{
    
    protected int TOTAL_ROWS;
    public int getTOTAL_ROWS() {
        return TOTAL_ROWS;
    }

    public void setTOTAL_ROWS(int TOTAL_ROWS) {
        this.TOTAL_ROWS = TOTAL_ROWS;
    }

    

    
}
