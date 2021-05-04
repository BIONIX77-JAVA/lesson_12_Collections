package com.company.Bionix;

import java.util.*;

public class TopMessages {
    public static List<ContactWithMessages> getTop5ContactsByMessages(
            Collection<Contact> contacts,
            Collection<Message> messages) {
        Map<String, Integer> messageCountPerNumber = new HashMap<>();
        for (Message message : messages) {
            Integer messageCount = messageCountPerNumber.get(message.phoneNumber);
            if (messageCount == null) {
                messageCount = 0;
            }
            messageCount++;
            messageCountPerNumber.put(message.phoneNumber, messageCount);
        }
        Map<String, Contact> contactsByNumber =
                GroupItemsByUtils.groupContactsByNumber(contacts);

        List<ContactWithMessages> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : messageCountPerNumber.entrySet()) {
            String phoneNumber = entry.getKey();
            Integer messageCount = entry.getValue();
            result.add(new ContactWithMessages(
                    contactsByNumber.get(phoneNumber),
                    messageCount
            ));
        }
        result.sort(new Comparator<ContactWithMessages>() {
            @Override
            public int compare(ContactWithMessages contactWithMessages, ContactWithMessages t1) {
                return Integer.compare(t1.messageCount, contactWithMessages.messageCount);
            }
        });
        List<ContactWithMessages> finalResult = new ArrayList<>();
        for (int i = 0; (i < 5 && i < result.size()); i++) {
            finalResult.add(result.get(i));
        }
        return finalResult;
    }

    public static class ContactWithMessages {
        public Contact contact;
        public int messageCount;

        public ContactWithMessages(Contact contact, int messageCount) {
            this.contact = contact;
            this.messageCount = messageCount;
        }

        @Override
        public String toString() {
            return
                    contact +
                            " messageCount : " + messageCount;
        }
    }
}