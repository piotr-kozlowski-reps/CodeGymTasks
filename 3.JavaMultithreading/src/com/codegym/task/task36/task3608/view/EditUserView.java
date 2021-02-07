package com.codegym.task.task36.task3608.view;

import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.DataModel;

public class EditUserView implements View{

    private Controller controller;

    @Override
    public void refresh(DataModel dataModel) {

        StringBuilder resultStringBuilder = new StringBuilder();
        resultStringBuilder.append("User to be edited:\n");
        resultStringBuilder.append("\t").append(dataModel.getActiveUser());
        resultStringBuilder.append("\n").append("===================================================");
        System.out.println(resultStringBuilder.toString());

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;

    }

    public void fireEventUserDeleted(long id) {
        controller.onDeleteUser(id);
    }

    public void fireUserDeletedEvent(long id) {
        controller.onDeleteUser(id);
    }

    public void fireShowDeletedUsersEvent(){
        controller.onShowAllDeletedUsers();
    }

    public void fireOpenUserEditFormEvent(long id){
        controller.onOpenUserEditForm(id);
    }

    public void fireUserDataChangedEvent(String name, long id, int level) {
        controller.onChangeUserData(name, id, level);
    }
}
