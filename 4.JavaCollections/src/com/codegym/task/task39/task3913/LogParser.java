package com.codegym.task.task39.task3913;

import com.codegym.task.task39.task3913.query.IPQuery;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery {

    //fields
    Path logDir;
    List<LogItem> logItemsList;

    //constr
    public LogParser(Path logDir) {
        this.logDir = logDir;
        logItemsList = createLogItemList();
    }

    ////////////
    private List<LogItem> createLogItemList() {

        List<LogItem> logsList = new ArrayList<>();
        List<File> logsFileList = createLogFilesList(logDir);

        try {
            for (File currentFile : logsFileList) {

                FileReader fileReader = new FileReader(currentFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    logsList.add(addNewLogItem(line));
                }
                bufferedReader.close();
                fileReader.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return logsList;
    }

    private LogItem addNewLogItem(String line) {

        String[] stringSplited = line.split("\\s+");
        System.out.println(stringSplited);

        int index = stringSplited.length - 1;


        //status
        Status statusLogged = null;
        String status = stringSplited[index];
        if (status.equals("OK")) statusLogged = Status.OK;
        if (status.equals("FAILED")) statusLogged = Status.FAILED;
        if (status.equals("ERROR")) statusLogged = Status.ERROR;
        index--;


        //event
        Event eventLogged = null;
        Integer taskNumberIfPresent = null;
        String event1 = stringSplited[index];
        index--;
        if (event1.equals("LOGIN")) eventLogged = Event.LOGIN;
        if (event1.equals("DOWNLOAD_PLUGIN")) eventLogged = Event.DOWNLOAD_PLUGIN;
        if (event1.equals("SEND_MESSAGE")) eventLogged = Event.SEND_MESSAGE;
        else if (eventLogged == null) {
            String event2 = stringSplited[index];
            index--;
            taskNumberIfPresent = Integer.parseInt(event1);
            if (event2.equals("ATTEMPT_TASK")) eventLogged = Event.ATTEMPT_TASK;
            if (event2.equals("COMPLETE_TASK")) eventLogged = Event.COMPLETE_TASK;
        }


        //date
        // ("146.34.15.5 Eduard Bentley 05.01.2021 20:22:55 COMPLETE_TASK 48 FAILED")
        Date date = null;
        String hourMinuteSecond = stringSplited[index];
        index--;
        String dayMonthYear = stringSplited[index];
        index--;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");  // <day.month.year hour:minute:second>
        try {
            date = simpleDateFormat.parse(dayMonthYear + " " + hourMinuteSecond);
        } catch (ParseException e) {
            e.printStackTrace();
        }










        LogItem logItem = new LogItem(); //todo: add all elements to constructor and create full object
        return logItem;
    }


    private List<File> createLogFilesList(Path logDir) {

        List<File> logFilesList = new ArrayList<>();
        File directoryPath = logDir.toFile();
        File[] fileList = directoryPath.listFiles();

        for (File file : fileList) {
            if (file.toString().endsWith(".log")) logFilesList.add(file);
        }

        return logFilesList;
    }






    //
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return 0;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }


    private class LogItem {

        //fields

        private Event event;
        private Integer taskNumberIfPresent;
        private Status status;

    }
}