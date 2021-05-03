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

    public static Map<String, Message> groupMessagesByNumber(Collection<Message> messages) {
        Map<String, Message> result = new HashMap<>();
        for (Message message : messages) {
            result.put(message.phoneNumber, message);
        }
        return result;
    }

    public static Map<String, List<CallLog>> groupCallLogsByNumber(Collection<CallLog> callLogs) {

        Map<String, List<CallLog>> output = new HashMap<>();
        for (CallLog callLog : callLogs) {

            List<CallLog> exitingGroup = output.get(callLog.phoneNumber);
            if (exitingGroup == null) {
                List<CallLog> newGroup = new ArrayList<>();
                newGroup.add(callLog);
                output.put(callLog.phoneNumber, newGroup);
            } else {
                exitingGroup.add(callLog);
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