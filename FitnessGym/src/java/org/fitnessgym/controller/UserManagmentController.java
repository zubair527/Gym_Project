package org.fitnessgym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.fitnessgym.dao.GenericDAO;
import org.fitnessgym.dao.UserDAO;
import org.fitnessgym.datamodel.UserDataModel;
import org.fitnessgym.model.User;
import org.fitnessgym.util.ScopeUtil;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author vu
 */
@ManagedBean
@RequestScoped
public class UserManagmentController implements java.io.Serializable {

    private int userId;
    private String userLogin;
    private String userEmail;
    private String cell;
    private float userHeight;
    private String userName;
    private String userNumber;
    private String userPassword;
    private String userType;
    private float userWeight;
    private User user;
    private User instructor;
    private User selectedUser;
    private int TOTAL_ROWS;

    private List<User> list;
    private List<User> allList;
    private UserDataModel userDataModel;
    private List<User> filterUser;
    private ScopeUtil scopeUtil;

    @PostConstruct
    public void init() {
        scopeUtil = new ScopeUtil();
        userDataModel = new UserDataModel(getList());
    }

    public void addMember() {
        user = new User();
        HttpSession session=scopeUtil.getSession(false);
        instructor=(User)session.getAttribute("userInfo");
        user.setUserName(userName);
        user.setUserLogin(userLogin);
        user.setUserPassword(userPassword);
        user.setCell(userEmail);
        user.setUserEmail(userEmail);
        user.setCell(cell);
        user.setUserHeight(userHeight);
        user.setUserWeight(userWeight);
        user.setUserType(userType);
        user.setInstructor(instructor);
        GenericDAO<User> userDAO = new UserDAO();
        userDAO.add(user);
        userDataModel = new UserDataModel(getList());       // refresh the table that will update the new result
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Added SuccessFully"));
//        reset();

    }

    public void deleteMember() {
        GenericDAO<User> userDAO = new UserDAO();
        userDAO.delete(User.class, selectedUser.getUserId());
        init();      // refresh the table that will update the new result
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Deleted SuccessFully"));
        reset();
    }

    public void editMember() {
        user = new User();
        user.setUserName(userName);
        user.setUserLogin(userLogin);
        user.setUserPassword(userPassword);
        user.setCell(userEmail);
        user.setUserEmail(userEmail);
        user.setCell(cell);
        user.setUserHeight(userHeight);
        user.setUserWeight(userWeight);
        user.setUserType(userType);
        GenericDAO<User> userDAO = new UserDAO();
        userDAO.edit(user);
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Edited SuccessFully"));

    }

    public void getUser() {

    }

//    public List<User> complete(String query) {
//        
//        GenericDAO<User> userDAO = new UserDAO();
//       List<User> suggestion=new ArrayList<User>();
//        list = userDAO.getList("From User");
//        List<String> results = new ArrayList<String>();
//        for (User u:userConverter) {
//            if(u.getUserName().startsWith(query)){
//                suggestion.add(u);
//            }
//        }
//        return suggestion;
//    }
    public List<User> getList() {
        GenericDAO<User> userDAO = new UserDAO();
        HttpSession session = scopeUtil.getSession(false);
        User u = (User) session.getAttribute("userInfo");
        list = userDAO.getList("From User  where user_instructor='" + u.getUserId() + "'");
        TOTAL_ROWS = list.size();
        return list;
    }

    public List<User> getAllList() {
        GenericDAO<User> userDAO = new UserDAO();
        allList = userDAO.getList("From User");
        TOTAL_ROWS = allList.size();
        return allList;
    }

    public void onEdit(RowEditEvent event) {
        GenericDAO<User> userDAO = new UserDAO();
        User u = new User();
        int uid = ((User) event.getObject()).getUserId();
        u.setUserName(((User) event.getObject()).getUserName());
        u.setUserLogin(((User) event.getObject()).getUserLogin());
        u.setUserHeight(((User) event.getObject()).getUserHeight());
        u.setUserWeight(((User) event.getObject()).getUserWeight());
        u.setCell(((User) event.getObject()).getCell());
        u.setUserEmail(((User) event.getObject()).getUserEmail());
        userDAO.edit(u);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User has been updated", ""));

    }


public void reset() {
        userLogin = "";
        userEmail = "";
        cell = "";
        userHeight = 0;
        userName = "";
        userNumber = "";
        userPassword = "";
        userType = "";
        userWeight = 0;

    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public float getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(float userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public float getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(float userWeight) {
        this.userWeight = userWeight;
    }

    public User getU() {
        return user;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public void setU(User user) {
        this.user = user;
    }

    public int getTOTAL_ROWS() {
        return TOTAL_ROWS;
    }

    public void setTOTAL_ROWS(int TOTAL_ROWS) {
        this.TOTAL_ROWS = TOTAL_ROWS;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public UserDataModel getUserDataModel() {
        return userDataModel;
    }

    public void setUserDataModel(UserDataModel userDataModel) {
        this.userDataModel = userDataModel;
    }

    public List<User> getFilterUser() {
        return filterUser;
    }

    public void setFilterUser(List<User> filterUser) {
        this.filterUser = filterUser;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
