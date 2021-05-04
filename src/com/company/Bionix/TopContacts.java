package com.company.Bionix;

import java.util.*;

public class TopContacts {

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
            return contact +
                    "callsCounts : " + callsCount;
        }
    }
}