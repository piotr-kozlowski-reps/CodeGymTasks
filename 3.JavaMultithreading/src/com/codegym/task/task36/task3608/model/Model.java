package com.codegym.task.task36.task3608.model;

public interface Model {
    DataModel getDataModel();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userID);
    void deleteUserById(long id);
    void changeUserData(String name, long id, int level);
}
