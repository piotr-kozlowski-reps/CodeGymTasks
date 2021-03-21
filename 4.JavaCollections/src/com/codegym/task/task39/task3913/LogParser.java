package com.codegym.task.task39.task3913;

import com.codegym.task.task39.task3913.query.*;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    //fields
    Path logDir;
    List<LogItem> logItemsList;

    //constr
    public LogParser(Path logDir) {
        this.logDir = logDir;
        logItemsList = createLogItemList();
    }


    //------------------------------------
    //IPQuery
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {

        Set<String> uniqueIPsSet = new HashSet<>();

        if (after != null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if ((currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after))
                        && (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before))) {
                    uniqueIPsSet.add(currentLogItem.getIp());
                }
            }
        } else if (after == null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before)) {
                    uniqueIPsSet.add(currentLogItem.getIp());
                }
            }
        } else if (after != null && before == null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after)) {
                    uniqueIPsSet.add(currentLogItem.getIp());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                uniqueIPsSet.add(currentLogItem.getIp());
            }
        }

        return uniqueIPsSet.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPsSet = new HashSet<>();

        if (after != null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if ((currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after))
                        && (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before))) {
                    uniqueIPsSet.add(currentLogItem.getIp());
                }
            }
        } else if (after == null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before)) {
                    uniqueIPsSet.add(currentLogItem.getIp());
                }
            }
        } else if (after != null && before == null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after)) {
                    uniqueIPsSet.add(currentLogItem.getIp());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                uniqueIPsSet.add(currentLogItem.getIp());
            }
        }

        return uniqueIPsSet;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {

        Set<String> uniqueIPsSetForUser = new HashSet<>();


        if (after != null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if ((currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after))
                        && (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before))) {
                    if (currentLogItem.getName().equals(user)) uniqueIPsSetForUser.add(currentLogItem.getIp());
                }
            }
        } else if (after == null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before)) {
                    if (currentLogItem.getName().equals(user)) uniqueIPsSetForUser.add(currentLogItem.getIp());
                }
            }
        } else if (after != null && before == null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after)) {
                    if (currentLogItem.getName().equals(user)) uniqueIPsSetForUser.add(currentLogItem.getIp());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getName().equals(user)) uniqueIPsSetForUser.add(currentLogItem.getIp());
            }
        }

        return uniqueIPsSetForUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {

        Set<String> uniqueIPsSetForEvent = new HashSet<>();

        if (after != null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if ((currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after))
                        && (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before))) {
                    if (currentLogItem.getEvent().equals(event)) uniqueIPsSetForEvent.add(currentLogItem.getIp());
                }
            }
        } else if (after == null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before)) {
                    if (currentLogItem.getEvent().equals(event)) uniqueIPsSetForEvent.add(currentLogItem.getIp());
                }
            }
        } else if (after != null && before == null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after)) {
                    if (currentLogItem.getEvent().equals(event)) uniqueIPsSetForEvent.add(currentLogItem.getIp());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(event)) uniqueIPsSetForEvent.add(currentLogItem.getIp());
            }
        }

        return uniqueIPsSetForEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {

        Set<String> uniqueIPsSetForStatus = new HashSet<>();

        if (after != null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if ((currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after))
                        && (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before))) {
                    if (currentLogItem.getStatus().equals(status)) uniqueIPsSetForStatus.add(currentLogItem.getIp());
                }
            }
        } else if (after == null && before != null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().before(before) || currentLogItem.getDate().equals(before)) {
                    if (currentLogItem.getStatus().equals(status)) uniqueIPsSetForStatus.add(currentLogItem.getIp());
                }
            }
        } else if (after != null && before == null) {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getDate().after(after) || currentLogItem.getDate().equals(after)) {
                    if (currentLogItem.getStatus().equals(status)) uniqueIPsSetForStatus.add(currentLogItem.getIp());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getStatus().equals(status)) uniqueIPsSetForStatus.add(currentLogItem.getIp());
            }
        }

        return uniqueIPsSetForStatus;
    }


    //------------------------------------
    //UserQuery
    @Override
    public Set<String> getAllUsers() {

        Set<String> allUsersSet = new HashSet<>();

        for (LogItem currentLogItem : logItemsList) {
            allUsersSet.add(currentLogItem.getName());
        }

        return allUsersSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {

        Set<String> usersSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) usersSet.add(currentLogItem.getName());
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) usersSet.add(currentLogItem.getName());
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) usersSet.add(currentLogItem.getName());
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                usersSet.add(currentLogItem.getName());
            }
        }

        return usersSet.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {

        Set<Event> userEventSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user)) userEventSet.add(currentLogItem.getEvent());
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user)) userEventSet.add(currentLogItem.getEvent());
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user)) userEventSet.add(currentLogItem.getEvent());
                }
            }
        } else if (isAfterAndBeforeNull(after, before)){
            for (LogItem currentLogItem : logItemsList) {
                    if (currentLogItem.getName().equals(user)) userEventSet.add(currentLogItem.getEvent());
            }
        }

        return userEventSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {

        Set<String> usersForGivenIP = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getIp().equals(ip)) usersForGivenIP.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getIp().equals(ip)) usersForGivenIP.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)){
                    if (currentLogItem.getIp().equals(ip)) usersForGivenIP.add(currentLogItem.getName());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getIp().equals(ip)) usersForGivenIP.add(currentLogItem.getName());
            }
        }

        return usersForGivenIP;
    }

    @Override
    public Set<String> getUsersWhoHaveLoggedIn(Date after, Date before) {

        Set<String> usersWhoLoggedInSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.LOGIN)) usersWhoLoggedInSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.LOGIN)) usersWhoLoggedInSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)){
                    if (currentLogItem.getEvent().equals(Event.LOGIN)) usersWhoLoggedInSet.add(currentLogItem.getName());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(Event.LOGIN)) usersWhoLoggedInSet.add(currentLogItem.getName());
            }
        }

        return usersWhoLoggedInSet;
    }

    @Override
    public Set<String> getUsersWhoHaveDownloadedPlugin(Date after, Date before) {

        Set<String> usersWhoDownloadedPluginSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.DOWNLOAD_PLUGIN)) usersWhoDownloadedPluginSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.DOWNLOAD_PLUGIN)) usersWhoDownloadedPluginSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)){
                    if (currentLogItem.getEvent().equals(Event.DOWNLOAD_PLUGIN)) usersWhoDownloadedPluginSet.add(currentLogItem.getName());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(Event.DOWNLOAD_PLUGIN)) usersWhoDownloadedPluginSet.add(currentLogItem.getName());
            }
        }

        return usersWhoDownloadedPluginSet;
    }

    @Override
    public Set<String> getUsersWhoHaveSentMessages(Date after, Date before) {

        Set<String> usersWhoSentMessageSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.SEND_MESSAGE)) usersWhoSentMessageSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.SEND_MESSAGE)) usersWhoSentMessageSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)){
                    if (currentLogItem.getEvent().equals(Event.SEND_MESSAGE)) usersWhoSentMessageSet.add(currentLogItem.getName());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(Event.SEND_MESSAGE)) usersWhoSentMessageSet.add(currentLogItem.getName());
            }
        }

        return usersWhoSentMessageSet;
    }

    @Override
    public Set<String> getUsersWhoHaveAttemptedTasks(Date after, Date before) {

        Set<String> usersWhoAttemptedTaskSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)) usersWhoAttemptedTaskSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)) usersWhoAttemptedTaskSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)){
                    if (currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)) usersWhoAttemptedTaskSet.add(currentLogItem.getName());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)) usersWhoAttemptedTaskSet.add(currentLogItem.getName());
            }
        }

        return usersWhoAttemptedTaskSet;
    }

    @Override
    public Set<String> getUsersWhoHaveAttemptedTasks(Date after, Date before, int task) {

        Set<String> usersWhoAttemptedSpecyficTaskSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)
                            && currentLogItem.getTaskNumberIfPresent() == task ) {
                        usersWhoAttemptedSpecyficTaskSet.add(currentLogItem.getName());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)
                            && currentLogItem.getTaskNumberIfPresent() == task ) {
                        usersWhoAttemptedSpecyficTaskSet.add(currentLogItem.getName());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)){
                    if (currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)
                            && currentLogItem.getTaskNumberIfPresent() == task ) {
                        usersWhoAttemptedSpecyficTaskSet.add(currentLogItem.getName());
                    }
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)
                        && currentLogItem.getTaskNumberIfPresent() == task ) {
                    usersWhoAttemptedSpecyficTaskSet.add(currentLogItem.getName());
                }
            }
        }

        return usersWhoAttemptedSpecyficTaskSet;
    }

    @Override
    public Set<String> getUsersWhoHaveCompletedTasks(Date after, Date before) {

        Set<String> usersWhoCompletedTaskSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.COMPLETE_TASK)) usersWhoCompletedTaskSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.COMPLETE_TASK)) usersWhoCompletedTaskSet.add(currentLogItem.getName());
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)){
                    if (currentLogItem.getEvent().equals(Event.COMPLETE_TASK)) usersWhoCompletedTaskSet.add(currentLogItem.getName());
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(Event.COMPLETE_TASK)) usersWhoCompletedTaskSet.add(currentLogItem.getName());
            }
        }

        return usersWhoCompletedTaskSet;
    }

    @Override
    public Set<String> getUsersWhoHaveCompletedTasks(Date after, Date before, int task) {

        Set<String> usersWhoCompletedSpecificTaskSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.COMPLETE_TASK)
                            && currentLogItem.getTaskNumberIfPresent() == task ) {
                        usersWhoCompletedSpecificTaskSet.add(currentLogItem.getName());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.COMPLETE_TASK)
                            && currentLogItem.getTaskNumberIfPresent() == task ) {
                        usersWhoCompletedSpecificTaskSet.add(currentLogItem.getName());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)){
                    if (currentLogItem.getEvent().equals(Event.COMPLETE_TASK)
                            && currentLogItem.getTaskNumberIfPresent() == task ) {
                        usersWhoCompletedSpecificTaskSet.add(currentLogItem.getName());
                    }
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(Event.COMPLETE_TASK)
                        && currentLogItem.getTaskNumberIfPresent() == task ) {
                    usersWhoCompletedSpecificTaskSet.add(currentLogItem.getName());
                }
            }
        }

        return usersWhoCompletedSpecificTaskSet;
    }



    //------------------------------------
    //DateQuery
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {


        Set<Date> datesForUserAndEventOccuredSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user) && currentLogItem.getEvent().equals(event)) {
                        datesForUserAndEventOccuredSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user) && currentLogItem.getEvent().equals(event)) {
                        datesForUserAndEventOccuredSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user) && currentLogItem.getEvent().equals(event)) {
                        datesForUserAndEventOccuredSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getName().equals(user) && currentLogItem.getEvent().equals(event)) {
                    datesForUserAndEventOccuredSet.add(currentLogItem.getDate());
                }
            }
        }

        return datesForUserAndEventOccuredSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {

        Set<Date> datesForAnyFailureOccuredSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getStatus().equals(Status.FAILED)) {
                        datesForAnyFailureOccuredSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getStatus().equals(Status.FAILED)) {
                        datesForAnyFailureOccuredSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getStatus().equals(Status.FAILED)) {
                        datesForAnyFailureOccuredSet.add(currentLogItem.getDate());
                    }
                }

            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getStatus().equals(Status.FAILED)) {
                    datesForAnyFailureOccuredSet.add(currentLogItem.getDate());
                }
            }
        }

        return datesForAnyFailureOccuredSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorOccurred(Date after, Date before) {

        Set<Date> datesForAnyErrorOccuredSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getStatus().equals(Status.ERROR)) {
                        datesForAnyErrorOccuredSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getStatus().equals(Status.ERROR)) {
                        datesForAnyErrorOccuredSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getStatus().equals(Status.ERROR)) {
                        datesForAnyErrorOccuredSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getStatus().equals(Status.ERROR)) {
                    datesForAnyErrorOccuredSet.add(currentLogItem.getDate());
                }
            }
        }

        return datesForAnyErrorOccuredSet;
    }

    @Override
    public Date getDateWhenUserLoggedInFirstTime(String user, Date after, Date before) {

        List<Date> datesWhenUserLoggedList = new ArrayList<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.LOGIN) && currentLogItem.getName().equals(user)) {
                        datesWhenUserLoggedList.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.LOGIN) && currentLogItem.getName().equals(user)) {
                        datesWhenUserLoggedList.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.LOGIN) && currentLogItem.getName().equals(user)) {
                        datesWhenUserLoggedList.add(currentLogItem.getDate());
                    }
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(Event.LOGIN) && currentLogItem.getName().equals(user)) {
                    datesWhenUserLoggedList.add(currentLogItem.getDate());
                }
            }
        }

        Date firstDate = null;
        if (datesWhenUserLoggedList.size() == 0) return null;
        else {
            firstDate = datesWhenUserLoggedList.get(0);
            for (Date currentDate : datesWhenUserLoggedList) {
                if (currentDate.before(firstDate)) firstDate = currentDate;
            }
        }

        return firstDate;
    }

    @Override
    public Date getDateWhenUserAttemptedTask(String user, int task, Date after, Date before) {

        List<Date> datesWhenUserAttemptedTaskList = new ArrayList<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user)
                            && currentLogItem.getTaskNumberIfPresent() != null
                            && currentLogItem.getTaskNumberIfPresent() == task
                            && currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)) {
                        datesWhenUserAttemptedTaskList.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user)
                            && currentLogItem.getTaskNumberIfPresent() != null
                            && currentLogItem.getTaskNumberIfPresent() == task
                            && currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)) {
                        datesWhenUserAttemptedTaskList.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user)
                            && currentLogItem.getTaskNumberIfPresent() != null
                            && currentLogItem.getTaskNumberIfPresent() == task
                            && currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)) {
                        datesWhenUserAttemptedTaskList.add(currentLogItem.getDate());
                    }
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getName().equals(user)
                        && currentLogItem.getTaskNumberIfPresent() != null
                        && currentLogItem.getTaskNumberIfPresent() == task
                        && currentLogItem.getEvent().equals(Event.ATTEMPT_TASK)) {
                    datesWhenUserAttemptedTaskList.add(currentLogItem.getDate());
                }
            }
        }

        Date firstDate = null;
        if (datesWhenUserAttemptedTaskList.size() == 0) return null;
        else {
            firstDate = datesWhenUserAttemptedTaskList.get(0);
            for (int i = 1; i < datesWhenUserAttemptedTaskList.size(); i++) {
                if (datesWhenUserAttemptedTaskList.get(i).before(firstDate)) firstDate = datesWhenUserAttemptedTaskList.get(i);
            }
        }

        return firstDate;
    }

    @Override
    public Date getDateWhenUserCompletedTask(String user, int task, Date after, Date before) {

        List<Date> datesWhenUserCompletedTaskList = new ArrayList<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user)
                            && currentLogItem.getTaskNumberIfPresent() != null
                            && currentLogItem.getTaskNumberIfPresent() == task
                            && currentLogItem.getEvent().equals(Event.COMPLETE_TASK)) {
                        datesWhenUserCompletedTaskList.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user)
                            && currentLogItem.getTaskNumberIfPresent() != null
                            && currentLogItem.getTaskNumberIfPresent() == task
                            && currentLogItem.getEvent().equals(Event.COMPLETE_TASK)) {
                        datesWhenUserCompletedTaskList.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user)
                            && currentLogItem.getTaskNumberIfPresent() != null
                            && currentLogItem.getTaskNumberIfPresent() == task
                            && currentLogItem.getEvent().equals(Event.COMPLETE_TASK)) {
                        datesWhenUserCompletedTaskList.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterAndBeforeNull(after, before)){
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getName().equals(user)
                        && currentLogItem.getTaskNumberIfPresent() != null
                        && currentLogItem.getTaskNumberIfPresent() == task
                        && currentLogItem.getEvent().equals(Event.COMPLETE_TASK)) {
                    datesWhenUserCompletedTaskList.add(currentLogItem.getDate());
                }
            }
        }

        Date firstDate = null;
        if (datesWhenUserCompletedTaskList.size() == 0) return null;
        else {
            firstDate = datesWhenUserCompletedTaskList.get(0);
            for (int i = 1; i < datesWhenUserCompletedTaskList.size(); i++) {
                if (datesWhenUserCompletedTaskList.get(i).before(firstDate)) firstDate = datesWhenUserCompletedTaskList.get(i);
            }
        }


        return firstDate;
    }

    @Override
    public Set<Date> getDatesWhenUserSentMessages(String user, Date after, Date before) {

        Set<Date> datesWhenUserSendMessageSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user) && currentLogItem.getEvent().equals(Event.SEND_MESSAGE)) {
                        datesWhenUserSendMessageSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user) && currentLogItem.getEvent().equals(Event.SEND_MESSAGE)) {
                        datesWhenUserSendMessageSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getName().equals(user) && currentLogItem.getEvent().equals(Event.SEND_MESSAGE)) {
                        datesWhenUserSendMessageSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getName().equals(user) && currentLogItem.getEvent().equals(Event.SEND_MESSAGE)) {
                    datesWhenUserSendMessageSet.add(currentLogItem.getDate());
                }
            }
        }

        return datesWhenUserSendMessageSet;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {

        Set<Date> datesWhenUserDownloadedPluginSet = new HashSet<>();

        if (isBothDatesArentNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenBothArentNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.DOWNLOAD_PLUGIN) && currentLogItem.getName().equals(user)) {
                        datesWhenUserDownloadedPluginSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.DOWNLOAD_PLUGIN) && currentLogItem.getName().equals(user)) {
                        datesWhenUserDownloadedPluginSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            for (LogItem currentLogItem : logItemsList) {
                if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentLogItem.getDate(), after, before)) {
                    if (currentLogItem.getEvent().equals(Event.DOWNLOAD_PLUGIN) && currentLogItem.getName().equals(user)) {
                        datesWhenUserDownloadedPluginSet.add(currentLogItem.getDate());
                    }
                }
            }
        } else {
            for (LogItem currentLogItem : logItemsList) {
                if (currentLogItem.getEvent().equals(Event.DOWNLOAD_PLUGIN) && currentLogItem.getName().equals(user)) {
                    datesWhenUserDownloadedPluginSet.add(currentLogItem.getDate());
                }
            }
        }

        return datesWhenUserDownloadedPluginSet;
    }


    //------------------------------------
    //EventQuery
    @Override
    public int getNumberOfEvents(Date after, Date before) {

        Set<Event> allEventsSet = new HashSet<>();

        for (int i = 0; i < logItemsList.size(); i++) {
            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {
                allEventsSet.add(logItemsList.get(i).getEvent());
            }
        }
        return allEventsSet.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {

        Set<Event> allEventsSet = new HashSet<>();

        for (int i = 0; i < logItemsList.size(); i++) {
            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {
                allEventsSet.add(logItemsList.get(i).getEvent());
            }
        }
        return allEventsSet;
    }



    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {

        Set<Event> allEventsForSpecyficIPSet = new HashSet<>();

        for (int i = 0; i < logItemsList.size(); i++) {
            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {
                if (logItemsList.get(i).getIp().equals(ip)) {
                    allEventsForSpecyficIPSet.add(logItemsList.get(i).getEvent());
                }
            }
        }
        return allEventsForSpecyficIPSet;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {

        Set<Event> allEventsForSpecyficUserSet = new HashSet<>();

        for (int i = 0; i < logItemsList.size(); i++) {
            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {
                if (logItemsList.get(i).getName().equals(user)) {
                    allEventsForSpecyficUserSet.add(logItemsList.get(i).getEvent());
                }
            }
        }
        return allEventsForSpecyficUserSet;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {

        Set<Event> allFailedEventsSet = new HashSet<>();

        for (int i = 0; i < logItemsList.size(); i++) {
            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {
                if (logItemsList.get(i).getStatus().equals(Status.FAILED)) {
                    allFailedEventsSet.add(logItemsList.get(i).getEvent());
                }
            }
        }
        return allFailedEventsSet;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {

        Set<Event> allErrorEventsSet = new HashSet<>();

        for (int i = 0; i < logItemsList.size(); i++) {
            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {
                if (logItemsList.get(i).getStatus().equals(Status.ERROR)) {
                    allErrorEventsSet.add(logItemsList.get(i).getEvent());
                }
            }
        }
        return allErrorEventsSet;
    }

    @Override
    public int getNumberOfAttemptsToCompleteTask(int task, Date after, Date before) {

        int numberOfAttempts = 0;

        for (int i = 0; i < logItemsList.size(); i++) {
            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {
                if (logItemsList.get(i).getTaskNumberIfPresent() != null
                        && logItemsList.get(i).getTaskNumberIfPresent() == task
                        && logItemsList.get(i).getEvent().equals(Event.ATTEMPT_TASK)) {
                    numberOfAttempts++;
                }
            }
        }
        return numberOfAttempts;
    }

    @Override
    public int getNumberOfSuccessfulAttemptsToCompleteTask(int task, Date after, Date before) {
        int numberOfAttempts = 0;

        for (int i = 0; i < logItemsList.size(); i++) {
            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {
                if (logItemsList.get(i).getTaskNumberIfPresent() != null
                        && logItemsList.get(i).getTaskNumberIfPresent() == task
                        && logItemsList.get(i).getEvent().equals(Event.COMPLETE_TASK)) {
                    numberOfAttempts++;
                }
            }
        }
        return numberOfAttempts;
    }

    @Override
    public Map<Integer, Integer> getAllAttemptedTasksAndNumberOfAttempts(Date after, Date before) {

        Map<Integer, Integer> allAttemptedTasksAndNumberOfAttemptsMap = new HashMap<>();

        for (int i = 0; i < logItemsList.size(); i++) {

            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {

                if (logItemsList.get(i).getEvent().equals(Event.ATTEMPT_TASK)
                        && logItemsList.get(i).getTaskNumberIfPresent() != null) {

                    int taskNumber = logItemsList.get(i).getTaskNumberIfPresent();
                    boolean isEntryKeyPresent = false;
                    for (Map.Entry<Integer, Integer> entry : allAttemptedTasksAndNumberOfAttemptsMap.entrySet()) {
                        if (entry.getKey() == taskNumber) {
                            isEntryKeyPresent = true;
                            int numberOfAttempts = entry.getValue();
                            allAttemptedTasksAndNumberOfAttemptsMap.put(taskNumber, ++numberOfAttempts);
                        }
                    }
                    if (!isEntryKeyPresent) allAttemptedTasksAndNumberOfAttemptsMap.put(taskNumber, 1);
                }
            }
        }
        return allAttemptedTasksAndNumberOfAttemptsMap;
    }

    @Override
    public Map<Integer, Integer> getAllCompletedTasksAndNumberOfCompletions(Date after, Date before) {

        Map<Integer, Integer> allCompletedTasksAndNumberOfAttemptsMap = new HashMap<>();

        for (int i = 0; i < logItemsList.size(); i++) {

            if (dateBetweenDates(logItemsList.get(i).getDate(), after, before)) {

                if (logItemsList.get(i).getEvent().equals(Event.COMPLETE_TASK)
                        && logItemsList.get(i).getTaskNumberIfPresent() != null) {

                    int taskNumber = logItemsList.get(i).getTaskNumberIfPresent();
                    boolean isEntryKeyPresent = false;
                    for (Map.Entry<Integer, Integer> entry : allCompletedTasksAndNumberOfAttemptsMap.entrySet()) {
                        if (entry.getKey() == taskNumber) {
                            isEntryKeyPresent = true;
                            int numberOfAttempts = entry.getValue();
                            allCompletedTasksAndNumberOfAttemptsMap.put(taskNumber, ++numberOfAttempts);
                        }
                    }
                    if (!isEntryKeyPresent) allCompletedTasksAndNumberOfAttemptsMap.put(taskNumber, 1);
                }
            }
        }
        return allCompletedTasksAndNumberOfAttemptsMap;
    }


    //------------------------------------
    //QLQuery
    @Override
    public Set<Object> execute(String query) {

        Set<Object> result = new HashSet<>();

        Pattern pattern = Pattern.compile("get (ip|user|date|event|status)");
        Matcher matcher = pattern.matcher(query);
        if (!matcher.matches()) return result;


        String queryToLowerCase = query.toLowerCase();
        switch (queryToLowerCase) {

            case "get ip":
                Set<String> resultIPStringSet = getUniqueIPs(null, null);
                for (String entry : resultIPStringSet) {
                    result.add(entry);
                }
                return result;

            case "get user":
                for (LogItem item : logItemsList) {
                    result.add(item.getName());
                }
                return result;

            case "get date":
                for (LogItem item : logItemsList) {
                    result.add(item.getDate());
                }
                return result;

            case "get event":
                for (LogItem item : logItemsList) {
                    result.add(item.getEvent());
                }
                return result;

            case "get status":
                for (LogItem item : logItemsList) {
                    result.add(item.getStatus());
                }
                return result;

            default:
                return result;
                
        }



    }


    //5.1.5. get status
    //
    //Example: A call to execute("get ip") must return a Set<String> containing all the unique IP
    // addresses in the log (i.e. 127.0.0.1, 12.12.12.12, 146.34.15.5, 192.168.100.2 for the test file).
    // The other queries should work in a similar manner.
    //
    //The objects in the returned set must be Strings for ip and user queries, Dates for date queries,
    // Events for event queries, and Statuses for status queries.


    //4. A call to the LogParser class's execute("get date") method must return a Set<Date> containing all unique dates.
    //5. A call to the LogParser class's execute("get event") method must return a Set<Event> containing all unique events.
    //6. A call to the LogParser class's execute("get status") method must return a Set<Status> containing all unique statuses.


    private class LogItem {

        //fields
        private String ip;
        private String name;
        private Date date;
        private Event event;
        private Integer taskNumberIfPresent;
        private Status status;

        //constr
        public LogItem(String ip, String name, Date date, Event event, Integer taskNumberIfPresent, Status status) {
            this.ip = ip;
            this.name = name;
            this.date = date;
            this.event = event;
            this.taskNumberIfPresent = taskNumberIfPresent;
            this.status = status;
        }

        //get
        public String getIp() {
            return ip;
        }
        public String getName() {
            return name;
        }
        public Date getDate() {
            return date;
        }
        public Event getEvent() {
            return event;
        }
        public Integer getTaskNumberIfPresent() {
            return taskNumberIfPresent;
        }
        public Status getStatus() {
            return status;
        }
    }


    ////////////Utils
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");  // <day.month.year hour:minute:second>
        try {
            date = simpleDateFormat.parse(dayMonthYear + " " + hourMinuteSecond);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //name
        StringBuilder name = new StringBuilder();
        for (int i = 1; i <= index; i++) {
            if (i != index) name.append(stringSplited[i]).append(" ");
            if (i == index) name.append(stringSplited[i]);
        }

        //ip
        String ip = stringSplited[0];



        LogItem logItem = new LogItem(ip, name.toString(), date, eventLogged, taskNumberIfPresent, statusLogged);
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

    private boolean isBothDatesArentNull(Date after, Date before) {
        return after != null && before != null;
    }

    private boolean isAfterIsNullAndBeforeIsNotNull(Date after, Date before) {
        return after == null && before != null;
    }

    private boolean isAfterIsNotNullAndbeforeIsNull(Date after, Date before) {
        return after != null && before == null;
    }

    private boolean isAfterAndBeforeNull(Date after, Date before) {
        return after == null && before == null;
    }

    private boolean dateSuitsWhenBothArentNull(Date currentDate, Date after, Date before) {

        if ((currentDate.after(after) || currentDate.equals(after)) && (currentDate.before(before) || currentDate.equals(before))) {
            return true;
        } else {
            return false;
        }

    }

    private boolean dateSuitsWhenAfterIsNullAndBeforeIsNotNull(Date currentDate, Date after, Date before) {
        return currentDate.before(before) || currentDate.equals(before);
    }

    private boolean dataSuitsWhenAfterIsNotNullAndBeforeIsNull(Date currentDate, Date after, Date before) {
        return currentDate.after(after) || currentDate.equals(after);
    }

    private boolean dateBetweenDates(Date currentDate, Date after, Date before) {

        if (isBothDatesArentNull(after, before)) {
            if (dateSuitsWhenBothArentNull(currentDate, after, before)) {
                return true;
            }
        }

        if (isAfterIsNullAndBeforeIsNotNull(after, before)) {
            if (dateSuitsWhenAfterIsNullAndBeforeIsNotNull(currentDate, after, before)) {
                return true;
            }
        }

        if (isAfterIsNotNullAndbeforeIsNull(after, before)) {
            if (dataSuitsWhenAfterIsNotNullAndBeforeIsNull(currentDate, after, before)) {
                return true;
            }
        }

        if (isAfterAndBeforeNull(after, before)) {
            return true;
        }

        return false;
    }

}