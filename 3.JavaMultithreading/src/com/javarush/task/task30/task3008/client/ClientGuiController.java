package com.javarush.task.task30.task3008.client;

/**
 * Created by work on 14.02.2017.
 */
public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();


    public static void main (String... args){
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }
    @Override
    protected String getServerAddress() {
       return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
       return  view.getServerPort();
    }

    @Override
    protected String getUserName() {
       return  view.getUserName();
    }
    public ClientGuiModel getModel(){
        return model;
    }
    @Override
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();

    }

    private ClientGuiView view = new ClientGuiView(this);

    public class GuiSocketThread extends SocketThread{
        @Override
        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }
    }

}
