package com.codegym.task.task30.task3008.client;

public class ClientGuiController extends Client{

    //fields
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(ClientGuiController.this);

    //constructors
//    public ClientGuiController(ClientGuiModel clientGuiModel, ClientGuiView clientGuiView){
//        this.clientGuiModel = clientGuiModel;
//        this.clientGuiView = clientGuiView;
//    }

    //set/get
    public ClientGuiModel getModel() {
        return this.model;
    }





    public class GuiSocketThread extends Client.SocketThread{

        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        GuiSocketThread guiSocketThread = new GuiSocketThread();
        return guiSocketThread;
    }

    @Override
    public void run() {
        getSocketThread().run();
    }


    //The ClientGuiController class's getServerAddress(), getServerPort(), and getUserName() methods should call the appropriate methods on the view object.

    @Override
    protected String getServerAddress() {
       return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }


    //
    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }


}
