package com.codegym.task.task36.task3608.model;
import com.codegym.task.task36.task3608.bean.User;
import com.codegym.task.task36.task3608.model.service.UserService;
import com.codegym.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model{

    private DataModel dataModel = new DataModel();
    private UserService userService = new UserServiceImpl();



    private List<User> getAllUsers(){
        List<User> temporaryUsersList = userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1,100));
        return temporaryUsersList;
    }

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        dataModel.setDisplayDeletedUserList(false);
        dataModel.setUsers(getAllUsers());
        dataModel.setUsers(userService.getUsersBetweenLevels(1, 100));
    }

    public void loadDeletedUsers(){
        dataModel.setDisplayDeletedUserList(true);
        dataModel.setUsers(userService.getAllDeletedUsers());
    }

    @Override
    public void loadUserById(long userID) {
        User user = userService.getUsersById(userID);
        dataModel.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        //dataModel.setUsers(userService.getAllDeletedUsers());
        dataModel.setUsers(getAllUsers());
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        dataModel.setUsers(getAllUsers());
    }

}
