package com.company.Bionix;

import java.util.*;


public class GroupItemsByUtils {

    public static Map<String, Contact> groupContactsByNumber( Collection<Contact> contacts) {
        Map<String, Contact> result = new HashMap<>();
        for (Contact contact : contacts) {
            result.put(contact.phoneNumber, contact);
        }
        return result;
    }

    public static Map<String, List<Message>>groupMessagesByNumber(Collection<Message> messages) {
        Map<String, List<Message>> output = new HashMap<>();
        for (Message message : messages) {
            List<Message> exitingGroup1 = output.get(message.phoneNumber);
            if (exitingGroup1 == null) {
                List<Message> newGroup = new ArrayList<>();
                newGroup.add(message);
                output.put(message.phoneNumber, newGroup);
                if(message.phoneNumber==null||message.massageText==null){
//                    message.massageText.equals("There is no messages");
                }
            } else {
                exitingGroup1.add(message);
            }
        }
        return output;
    }

    public static Map<String, List<CallLog>> groupCallLogsByNumber(Collection<CallLog> callLogs) {

        Map<String, List<CallLog>> output = new HashMap<>();
        for (CallLog callLog : callLogs) {

            List<CallLog> exitingGroup2 = output.get(callLog.phoneNumber);
            if (exitingGroup2 == null) {
                List<CallLog> newGroup = new ArrayList<>();
                newGroup.add(callLog);
                output.put(callLog.phoneNumber, newGroup);
            } else {
                exitingGroup2.add(callLog);
            }
        }
        return output;
    }

    private Collection<String> find(Collection<String> items, String text) {
        Collection<String> result = new LinkedList<>();
        for (String item : items) {
            if (item.contains(text)) {
                result.add(item);
            }
        }
        return result;
    }
}