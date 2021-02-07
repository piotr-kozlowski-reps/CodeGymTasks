package com.codegym.task.task36.task3608;

import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.FakeModel;
import com.codegym.task.task36.task3608.model.MainModel;
import com.codegym.task.task36.task3608.model.Model;
import com.codegym.task.task36.task3608.view.EditUserView;
import com.codegym.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        Controller controller = new Controller();
        EditUserView editUserView = new EditUserView();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        editUserView.setController(controller);
        controller.setEditUserView(editUserView);

        usersView.fireShowAllUsersEvent();
        usersView.fireOpenUserEditFormEvent(126L);
        editUserView.fireUserDeletedEvent(124L);
        editUserView.fireUserDataChangedEvent("nowaNazwaUzytkownika", 125L, 3);
        editUserView.fireShowDeletedUsersEvent();
    }
}