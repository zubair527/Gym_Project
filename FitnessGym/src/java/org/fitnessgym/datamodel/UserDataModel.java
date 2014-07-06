
package org.fitnessgym.datamodel;

import java.util.List;
import javax.faces.model.ListDataModel;
import org.fitnessgym.model.User;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author vu
 */
public class UserDataModel extends ListDataModel<User> implements SelectableDataModel<User> {

    public UserDataModel() {
    }

    public UserDataModel(List<User> user) {

        super(user);
    }

    @Override
    public Object getRowKey(User user) {
        return user.getUserLogin();
    }

    @Override
    public User getRowData(String rowkey) {
        List<User> users = (List<User>) getWrappedData();
        for(User user:users){
            if(user.getUserLogin().equals(rowkey)){
                return user;
            }
        }
        return null;
    }
}
