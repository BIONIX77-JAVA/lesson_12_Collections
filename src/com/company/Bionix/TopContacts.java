package com.company.Bionix;

import java.util.*;

public class TopContacts {
//    public static Collection<Contact> contacts = Arrays.asList(
//            new Contact("+380985869432", "John"),
//            new Contact("+380987676788", "Anton"),
//            new Contact("+380578788888", "Mark"),
//            new Contact("+380668866888", "Ioan"),
//            new Contact("+380657878895", "Rob"),
//            new Contact("+380568787876", "Mihael"),
//            new Contact("+380657889885", "Sandra"),
//            new Contact("+380858785656", "Olly"),
//            new Contact("+08005675675676", "Bob"),
//            new Contact("+380978654675", "Peter"),
//            new Contact("+380858785656", "Olly"),
//            new Contact("+08005675675676", "Bob"),
//            new Contact("+380978654675", "Peter"));
//
//    public static Collection<CallLog> callLogs = Arrays.asList(
//            new CallLog("+380985869432", 0, 10, CallLog.Status.Incoming),
//            new CallLog("+380985869432", 0, 0, CallLog.Status.Missed),
//            new CallLog("+380985869432", 0, 36, CallLog.Status.Outgoing),
//            new CallLog("+380987676788", 0, 232, CallLog.Status.Incoming),
//            new CallLog("+380578788888", 0, 3, CallLog.Status.Outgoing),
//            new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
//            new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
//            new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
//            new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
//            new CallLog("+380668866888", 0, 46, CallLog.Status.Incoming),
//            new CallLog("+380657878895", 0, 345, CallLog.Status.Incoming),
//            new CallLog("+380987676788", 0, 45, CallLog.Status.Incoming),
//            new CallLog("+380568787876", 0, 370, CallLog.Status.Missed),
//            new CallLog("+380657889885", 0, 212, CallLog.Status.Outgoing),
//            new CallLog("+380858785656", 0, 3, CallLog.Status.Incoming),
//            new CallLog("+380987676788", 0, 34, CallLog.Status.Incoming),
//            new CallLog("+08005675675676", 0, 45, CallLog.Status.Outgoing),
//            new CallLog("+380987676788", 0, 234, CallLog.Status.Outgoing),
//            new CallLog("+380978654675", 0, 166, CallLog.Status.Incoming));

    public static List<ContactWithCallsCount> getTop5Contacts(
            Collection<Contact> contacts,
            Collection<CallLog> callLogs) {
        Map<String, Integer> callsCountPerNumber = new HashMap<>();
        for (CallLog callLog : callLogs) {
            Integer callsCount = callsCountPerNumber.get(callLog.phoneNumber);
            if (callsCount == null) {
                callsCount = 0;
            }
            callsCount++;
            callsCountPerNumber.put(callLog.phoneNumber, callsCount);
        }
        Map<String, Contact> contactsByNumber =
                GroupItemsByUtils.groupContactsByNumber(contacts);

        List<ContactWithCallsCount> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : callsCountPerNumber.entrySet()) {
            String phoneNumber = entry.getKey();
            Integer callsCount = entry.getValue();
            result.add(new ContactWithCallsCount(
                    contactsByNumber.get(phoneNumber),
                    callsCount
            ));
        }
        result.sort(new Comparator<ContactWithCallsCount>() {
            @Override
            public int compare(ContactWithCallsCount contactWithCallsCount, ContactWithCallsCount t1) {
                return Integer.compare(t1.callsCount, contactWithCallsCount.callsCount);
            }
        });
        List<ContactWithCallsCount> finalResult = new ArrayList<>();
        for (int i = 0; (i < 5 && i < result.size()); i++) {
            finalResult.add(result.get(i));
        }
        return finalResult;
    }

    public static class ContactWithCallsCount {
        public Contact contact;
        public int callsCount;

        public ContactWithCallsCount(Contact contact, int callsCount) {
            this.contact = contact;
            this.callsCount = callsCount;
        }

        @Override
        public String toString() {
            return  contact +
                    "callsCounts : " + callsCount;
        }
    }
}
