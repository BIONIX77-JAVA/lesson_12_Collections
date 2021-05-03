package com.company.Bionix;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {

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

        Collection<Message> messages = Arrays.asList(
                new Message("+380985869432", " there was a cat", Message.Status.Incoming),
                new Message("+380987676788", " there was a dog", Message.Status.Outgoing),
                new Message("+380578788888", " there was a big cat", Message.Status.Incoming),
                new Message("+380668866888", " there was a small cat", Message.Status.Incoming),
                new Message("+380657878895", " there was a big dog", Message.Status.Outgoing),
                new Message("+380858785656", " there was a sweet cat", Message.Status.Incoming),
                new Message("+380985869432", " there was a ugly dog", Message.Status.Incoming),
                new Message("+380985869432", " there was a fast cat", Message.Status.Incoming),
                new Message("+380985869432", " there was a slowly dog", Message.Status.Outgoing));

        Map<String, List<CallLog>> groupedCalls =
                GroupItemsByUtils.groupCallLogsByNumber(callLogs);
        Map<String, Contact> groupedContacts =
                GroupItemsByUtils.groupContactsByNumber(contacts);
        Map<String, List<Message>> groupedMessages =
                GroupItemsByUtils.groupMessagesByNumber(messages);
        for (Map.Entry<String, List<CallLog>> entry : groupedCalls.entrySet()) {
            String phoneNumber = entry.getKey();
            Contact contact = groupedContacts.get(phoneNumber);
            String contactName = contact != null
                    ? contact.name
                    : phoneNumber;
            System.out.println("Name : " + contactName);

            for (Message message : groupedMessages.get(phoneNumber)) {
                String text = message.massageText != null
                        ? message.massageText
                        : "There is no messages dy this number";
                System.out.println("Text of message : " + message.massageText);
            }

            for (CallLog callLog : entry.getValue()) {
                System.out.println("Duration: " + callLog.duration);
                System.out.println("Is incoming: " + (callLog.status == CallLog.Status.Incoming));
            }
        }


        System.out.println("How many calls are associated with the number \"+380985869432\"? Such calls were: " + groupedCalls.get("+380985869432").size());
        System.out.println("How many calls are associated with the number \"+380987676788\"? Such calls were: " + groupedCalls.get("+380987676788").size());
        System.out.println("How many calls are associated with the number \"+380987674322\"? Such calls were: "
                + (groupedCalls.get("+380987674322") == null
                ? 0
                : groupedCalls.get("+380987674322").size()));

        for (String candidateToCheck : Arrays.asList("+380985869432", "+380987676788", "+380578788888", "+380668866888", "+380987674322")) {
            List<CallLog> calls = groupedCalls.get(candidateToCheck);
            int countOfCalls = calls == null ? 0 : calls.size();

            System.out.printf("How many calls are associated with the number '%s': %d", candidateToCheck, countOfCalls);
            System.out.println();
        }


        Set<Contact> contactsSet = new HashSet<>(contacts);
        System.out.println("----------------------------------------\n");
        System.out.println("We have " + contactsSet.size() + " unique contacts ( 3 of it not unique): ");
        for (Contact contact1 : contactsSet) {
            System.out.printf("Name :  \'%6s\'   phone number : \'%5s\' \n", contact1.name, contact1.phoneNumber);
        }
        System.out.println("----------------------------------------\n");
        Set<CallLog> callLogSet = new HashSet<>(callLogs);
        System.out.println("We have " + callLogSet.size() + " unique callLogs( 4 of it not unique): ");
        for (CallLog callLog : callLogSet) {
            System.out.printf("Phone number : \'%5s%10d%15s\' \n", callLog.phoneNumber, callLog.duration, callLog.status);
        }
        System.out.println("----------------------------------------\n");

        Set<Message> messageSet = new HashSet<>(messages);
        System.out.println("We have " + callLogSet.size() + " unique callLogs( 4 of it not unique): ");
        for (CallLog callLog : callLogSet) {
            System.out.printf("Phone number : \'%5s%10d%15s\' \n", callLog.phoneNumber, callLog.duration, callLog.status);
        }

    }
}
//    Реализуйте классы, описывающие контакт в телефонной книге, запись в
//        журнале звонков и одно сообщение (Contact, CallLog, Message). Классы не
//        имеют явной связи между собой.
//        2.
//        Определите тестовый набор контактов, звонков и сообщений, используя
//        коллекции (List<Contact>, List<CallLog>, List<Message>).
//        3.
//        Реализуйте функции текстового поиска по коллекциям с контактами,
//        звонками и сообщениями (Collection<Contact> find(Collection<Contact>, String)).
//        4.
//        Используя отображения, сгруппируйте все звонки по контактам и выведите на
//        консоль (Map<String, Contact>, Map<String, List<CallLog>>).
//        7Практика #2
//        5.
//        Определить и вывести уникальные элементы в коллекциях контактов,
//        звонков и сообщений (List<Contact>, Set<Contact>).
//        5.
//        Используя отображения, сгруппируйте все сообщения по контактам
//        (Map<String, Contact>, Map<String, List<Message>>).
//        6.
//        Реализуйте вывод топ-5 контактов с наибольшим количеством звонков
//        (List<Pair<Contact, Integer>>, Map<Contact, Integer>).
//        7.
//        Реализуйте вывод топ-5 контактов с наибольшим количеством сообщений
//        (List<Pair<Contact, Integer>>, Map<Contact, Integer>).