package com.company.Bionix;

import java.util.Objects;

public class Message {
    public String phoneNumber;
    public String massageText;

    public Message(String phoneNumber, String massageText) {
        this.phoneNumber = phoneNumber;
        this.massageText = massageText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(phoneNumber, message.phoneNumber) && Objects.equals(massageText, message.massageText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, massageText);
    }
}