package com.codegym.task.task30.task3008.client;

import com.codegym.task.task30.task3008.Connection;
import com.codegym.task.task30.task3008.ConsoleHelper;
import com.codegym.task.task30.task3008.Message;
import com.codegym.task.task30.task3008.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    //fields
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread{

        @Override
        public void run() {

            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            Socket socket = null;
            try{
                socket = new Socket(serverAddress, serverPort);
                connection = new Connection(socket);
            } catch (Exception e){
                notifyConnectionStatusChanged(false);
            }

            try{
                clientHandshake();
                clientMainLoop();
            } catch (Exception e){
                notifyConnectionStatusChanged(false);
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{

            while (true){

                Message incommingMessage = connection.receive();

                if (incommingMessage.getType() == MessageType.NAME_REQUEST){
                    String userName = getUserName();
                    Message messageToServer = new Message(MessageType.USER_NAME, userName);
                    connection.send(messageToServer);
                }

                else if (incommingMessage.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    break;
                }

                else {
                    throw new IOException("Unexpected MessageType");
                }

            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{

            while (true){

                Message incommingMessage = connection.receive();

                if (incommingMessage.getType() == MessageType.TEXT){
                    processIncomingMessage(incommingMessage.getData());
                }
                else if (incommingMessage.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(incommingMessage.getData());
                }
                else if (incommingMessage.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(incommingMessage.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }

            }
        }

        protected void processIncomingMessage(String message){
            System.out.println(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            System.out.println(String.format("User: %s has joined the chat.", userName));
        }

        protected void informAboutDeletingNewUser(String userName){
            System.out.println(String.format("User: %s has left the chat.", userName));
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            synchronized (Client.this){
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }


    }


    //
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {

        SocketThread thread = getSocketThread();
        thread.setDaemon(true);
        thread.start();

        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("An error happened, sorry.");
                System.exit(0);
            }
        }

        if (clientConnected) System.out.println("Connection established. To exit, enter 'exit'.");
        else System.out.println("An error occurred while working with the client.");

        while (true){

            if (clientConnected){
                String messageFromConsole = ConsoleHelper.readString();
                if (messageFromConsole.equals("exit")) break;
                else{
                    if (shouldSendTextFromConsole()) sendTextMessage(messageFromConsole);
                }
            }
            else break;
        }

    }

    protected String getServerAddress(){

        String serverAddressAchieved = null;
        System.out.println("Enter the server address, please.");
        serverAddressAchieved = ConsoleHelper.readString();

        return serverAddressAchieved;

    }

    protected int getServerPort(){

        int serverPort = 0;
        System.out.println("Enter the server port, please.");
        serverPort = ConsoleHelper.readInt();

        return serverPort;
    }

    protected String getUserName(){
        String userName = null;
        System.out.println("Enter your name, please.");
        userName = ConsoleHelper.readString();

        return userName;
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        SocketThread socketThread = new SocketThread();
        return socketThread;
    }

    protected void sendTextMessage(String text){
        Message message = null;

        try{
            message = new Message(MessageType.TEXT, text);
            connection.send(message);
        } catch (IOException e){
            System.out.println("Cannot send the message.");
            clientConnected = false;
        }



    }

}