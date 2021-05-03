package com.company.Bionix;

import java.util.*;

public class TopContacts {
    public static void main(String[] args) {
        Collection<Contact> contacts = Arrays.asList(
                new Contact("+380985869432", "John"),
                new Contact("+380987676788", "Anton"),
                new Contact("+380578788888", "Mark"),
                new Contact("+380668866888", "Ioan"),
                new Contact("+380657878895", "Rob"),
                new Contact("+380568787876", "Mihael"),
                new Contact("+380657889885", "Sandra"),
                new Contact("+380858785656", "Olly"),
                new Contact("+08005675675676", "Bob"),
                new Contact("+380978654675", "Peter"),
                new Contact("+380858785656", "Olly"),
                new Contact("+08005675675676", "Bob"),
                new Contact("+380978654675", "Peter"));

        Collection<CallLog> callLogs = Arrays.asList(
                new CallLog("+380985869432", 0, 10, CallLog.Status.Incoming),
                new CallLog("+380985869432", 0, 0, CallLog.Status.Missed),
                new CallLog("+380985869432", 0, 36, CallLog.Status.Outgoing),
                new CallLog("+380987676788", 0, 232, CallLog.Status.Incoming),
                new CallLog("+380578788888", 0, 3, CallLog.Status.Outgoing),
                new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
                new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
                new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
                new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
                new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
                new CallLog("+380657878895", 0, 345, CallLog.Status.Incoming),
                new CallLog("+380987676788", 0, 45, CallLog.Status.Incoming),
                new CallLog("+380568787876", 0, 370, CallLog.Status.Missed),
                new CallLog("+380657889885", 0, 212, CallLog.Status.Outgoing),
                new CallLog("+380858785656", 0, 3, CallLog.Status.Incoming),
                new CallLog("+380987676788", 0, 34, CallLog.Status.Incoming),
                new CallLog("+08005675675676", 0, 45, CallLog.Status.Outgoing),
                new CallLog("+380987676788", 0, 234, CallLog.Status.Outgoing),
                new CallLog("+380978654675", 0, 166, CallLog.Status.Incoming));


    }
    private List<ContactWithCallsCount> getTop5Contacts(
            Collection<Contact> contacts,
            Collection<CallLog> callLogs)
    {
        Map<String,Integer> callsCountPerNumber = new HashMap<>();
        for (CallLog callLog : callLogs) {
           Integer callsCount = callsCountPerNumber.get(callLog.phoneNumber);
           if(callsCount == null){
               callsCount=0;
           }
           callsCount+=1;
           callsCountPerNumber.put(callLog.phoneNumber, callsCount);
        }

    }
    private static class ContactWithCallsCount{
        public Contact contact;
        public int callsCount;
    }
}
