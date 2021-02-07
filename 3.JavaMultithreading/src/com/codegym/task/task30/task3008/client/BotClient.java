package com.codegym.task.task30.task3008.client;

import com.codegym.task.task30.task3008.ConsoleHelper;
import com.codegym.task.task30.task3008.Message;
import com.codegym.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client{


    public class BotSocketThread extends Client.SocketThread{

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Hello, there. I'm a bot. I understand the following commands: date, day, month, year, time, hour, minutes, seconds.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            ConsoleHelper.writeMessage(message);

            if (message.contains(":")){

                //split the message text:
                String[] splittedMessage = message.split(":");
                String nameReceived = splittedMessage[0];
                String messageReceived = splittedMessage[1].trim();

                String patternRegex = null;

                switch (messageReceived){
                    case "date":
                        patternRegex = "d.MM.YYYY";
                        sendTextMessage("Information for " + nameReceived + ": " + new SimpleDateFormat(patternRegex).format(Calendar.getInstance().getTime()));
                        break;
                    case "day":
                        patternRegex = "d";
                        sendTextMessage("Information for " + nameReceived + ": " + new SimpleDateFormat(patternRegex).format(Calendar.getInstance().getTime()));
                        break;
                    case "month":
                        patternRegex = "MMMM";
                        sendTextMessage("Information for " + nameReceived + ": " + new SimpleDateFormat(patternRegex).format(Calendar.getInstance().getTime()));
                        break;
                    case "year":
                        patternRegex = "YYYY";
                        sendTextMessage("Information for " + nameReceived + ": " + new SimpleDateFormat(patternRegex).format(Calendar.getInstance().getTime()));
                        break;
                    case "time":
                        patternRegex = "H:mm:ss";
                        sendTextMessage("Information for " + nameReceived + ": " + new SimpleDateFormat(patternRegex).format(Calendar.getInstance().getTime()));
                        break;
                    case "hour":
                        patternRegex = "H";
                        sendTextMessage("Information for " + nameReceived + ": " + new SimpleDateFormat(patternRegex).format(Calendar.getInstance().getTime()));
                        break;
                    case "minutes":
                        patternRegex = "m";
                        sendTextMessage("Information for " + nameReceived + ": " + new SimpleDateFormat(patternRegex).format(Calendar.getInstance().getTime()));
                        break;
                    case "seconds":
                        patternRegex = "s";
                        sendTextMessage("Information for " + nameReceived + ": " + new SimpleDateFormat(patternRegex).format(Calendar.getInstance().getTime()));
                        break;
                }
            }
        }


        
    }


    protected void sendTextMessage(String text){

        try {
            super.connection.send(new Message(MessageType.TEXT, text));
        } catch (Exception ignored){}

    }


    @Override
    protected SocketThread getSocketThread() {
        BotSocketThread botSocketThread = new BotSocketThread();
        return botSocketThread;
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int randomDigit0_99 = (int) ((Math.random() * 99) + 1);
        String botName = "date_bot_" + randomDigit0_99;
        return botName;
    }

    public static void main(String[] args) {


/*        String message = "Bob: timesdf";

        //check if message has ':'
        boolean isInMessageColon = message.contains(":");
        if (!isInMessageColon) return;

        //split the message text:
        String[] splittedMessage = message.split(":");
        String nameReceived = splittedMessage[0];
        String messageReceived = splittedMessage[1].trim();

        // create response
        StringBuilder result = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        Date currentTime = calendar.getTime();
        Format dateFormat = null;

        if(messageReceived.equals("date")){
            dateFormat = new SimpleDateFormat("d.MM.YYYY");
        }
        else if (messageReceived.equals("day")){
            dateFormat = new SimpleDateFormat("d");
        }
        else if (messageReceived.equals("month")){
            dateFormat = new SimpleDateFormat("MMMM");
        }
        else if (messageReceived.equals("year")){
            dateFormat = new SimpleDateFormat("YYYY");
        }
        else if (messageReceived.equals("time")){
            dateFormat = new SimpleDateFormat("H:mm:ss");
        }
        else if (messageReceived.equals("hour")){
            dateFormat = new SimpleDateFormat("H");
        }
        else if (messageReceived.equals("minutes")){
            dateFormat = new SimpleDateFormat("m");
        }
        else if (messageReceived.equals("s")){
            dateFormat = new SimpleDateFormat("s");
        }
        else if (messageReceived.equals("year")){
            dateFormat = new SimpleDateFormat("YYYY");
        } else {
            return;
        }

        //"Information for Bob: 12:30:47"
        result = result.append("Information for ").append(nameReceived).append(": ").append(dateFormat.format(currentTime));
        System.out.println(result.toString());
//        sendTextMessage(result.toString());*/







        BotClient botClient = new BotClient();
        botClient.run();
    }
}