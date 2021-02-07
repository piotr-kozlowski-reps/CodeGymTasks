package com.codegym.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Server {

    //fields
    private static Map<String, Connection> connectionMap;

    static {
        connectionMap = new ConcurrentHashMap<String, Connection>();
    }


    private static class Handler extends Thread{

        //fields
        private Socket socket;

        //constructor
        public Handler(Socket socket){
            this.socket = socket;
        }

        //
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{

            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST, "Type your name, please."));
                Message newMessage = connection.receive();

                if (newMessage.getType() != MessageType.USER_NAME){
                    continue;
                } else {

                    if (newMessage.getData().equals("")) continue;

                    boolean isNameInConnectioMap = false;
                    for (Map.Entry<String, Connection> entryOfMap : connectionMap.entrySet()){
                        if (entryOfMap.getKey().equals(newMessage.getData())) isNameInConnectioMap = true;
                    }

                    if (isNameInConnectioMap) continue;
                    else {
                        connectionMap.put(newMessage.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED, "Your name was accepted, thank you."));
                        return newMessage.getData();
                    }
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{

            for (Map.Entry<String, Connection> entryMap : connectionMap.entrySet()){
                if (!entryMap.getKey().equals(userName)){
                    Message userActiveMessage = new Message(MessageType.USER_ADDED, entryMap.getKey());
                    connection.send(userActiveMessage);
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{

            while (true){
                Message receivedMessage = connection.receive();

                if (receivedMessage.getType() == MessageType.TEXT){
                    String messageText = userName + ": " + receivedMessage.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, messageText));
                } else {
                    ConsoleHelper.writeMessage("An error. Sorry.");
                }
            }

        }

        @Override
        public void run() {

            ConsoleHelper.writeMessage("New connection was established with a remote address: " + socket.getRemoteSocketAddress());

            String nameOfNewUser = null;
            try (Connection newConnection = new Connection(socket)){

                try{
                    nameOfNewUser = serverHandshake(newConnection);
                } catch (Exception e){
                    e.printStackTrace();
                }

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, nameOfNewUser));

                try {
                    notifyUsers(newConnection, nameOfNewUser);
                } catch (IOException e){
                    e.printStackTrace();
                }

                serverMainLoop(newConnection, nameOfNewUser);
            } catch (Exception e){
                e.printStackTrace();
            } finally {

                Iterator<String> iterator = connectionMap.keySet().iterator();
                while (iterator.hasNext()){
                    String nameOfUserFromMap = iterator.next();
                    if (nameOfUserFromMap.equals(nameOfNewUser)) iterator.remove();
                }
                
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, nameOfNewUser));

                ConsoleHelper.writeMessage("Connection was closed with a remote address: " + socket.getRemoteSocketAddress());
            }
        }

    }


    public static void main(String[] args) {

        int serverPort = ConsoleHelper.readInt();

        try(ServerSocket serverSocket = new ServerSocket(serverPort)){

            while (true){
                Thread thread = new Handler(serverSocket.accept());
                thread.start();
            }

        } catch (IOException e){
            ConsoleHelper.writeMessage("Error: " + e);
        }
    }

    
    public static void sendBroadcastMessage(Message message){

        try{
            for (Map.Entry<String, Connection> entity : connectionMap.entrySet()){
                entity.getValue().send(message);
            }
        } catch (IOException e){
            System.out.println("The message can't be sent :(.");
        }
    }

}
