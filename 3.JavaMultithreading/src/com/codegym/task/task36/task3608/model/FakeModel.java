package com.codegym.task.task36.task3608.model;

import com.codegym.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {

    private DataModel dataModel = new DataModel();

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    public void loadUsers(){
        List<User> temporaryUsers = new ArrayList<User>();
        temporaryUsers.add(new User("A", 1, 1));
        temporaryUsers.add(new User("B", 2, 1));
        temporaryUsers.add(new User("C", 3, 1));

        dataModel.setUsers(temporaryUsers);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userID) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }


}
