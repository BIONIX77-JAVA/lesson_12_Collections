package com.company.Bionix;

import java.util.Objects;

public class CallLog {
    public String phoneNumber;
    public long timestamp;
    public long duration;
    public Status status;

    public CallLog(String phoneNumber, long timestamp, long duration, Status status) {
        this.phoneNumber = phoneNumber;
        this.timestamp = timestamp;
        this.duration = duration;
        this.status = status;
    }

    public enum Status {
        Incoming,
        Outgoing,
        Missed,
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CallLog)) return false;
        CallLog callLog = (CallLog) o;
        return timestamp == callLog.timestamp && duration == callLog.duration && Objects.equals(phoneNumber, callLog.phoneNumber) && status == callLog.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber, timestamp, duration, status);
    }
}
