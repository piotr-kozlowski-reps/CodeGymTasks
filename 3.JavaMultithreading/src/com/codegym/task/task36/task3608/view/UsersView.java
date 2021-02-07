package com.codegym.task.task36.task3608.view;

import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.DataModel;

public class UsersView implements View{

    private Controller controller;

    @Override
    public void refresh(DataModel dataModel) {

        StringBuilder resultStringBuilder = new StringBuilder();
        if (dataModel.isDisplayDeletedUserList()) resultStringBuilder.append("All deleted users:\n");
        else resultStringBuilder.append("All users:\n");

        for (int i = 0; i < dataModel.getUsers().size(); i++){
            resultStringBuilder.append("\t").append(dataModel.getUsers().get(i)).append("\n");
        }
        resultStringBuilder.append("===================================================");
        System.out.println(resultStringBuilder.toString());

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireShowAllUsersEvent(){
        controller.onShowAllUsers();
    }

    public void fireOpenUserEditFormEvent(long id){
        controller.onOpenUserEditForm(id);
    }

    public void fireShowDeletedUsersEvent(){
        controller.onShowAllDeletedUsers();
    }
}
