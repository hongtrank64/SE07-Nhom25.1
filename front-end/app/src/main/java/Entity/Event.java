package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Event implements Serializable{
    private String eventId;
    private String eventName;
    private Date timeStart;
    private Date timeEnd;
    private String address;
    private boolean requirement = true;
    private boolean status;

    private Set<Student> studentSet = new HashSet<Student>();

    public Event() {
    }

    public Event(String eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
    }

    public Event(String eventId, String eventName, Date timeStart, Date timeEnd, String address, boolean requirement, boolean status) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.address = address;
        this.requirement = requirement;
        this.status = status;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isRequirement() {
        return requirement;
    }

    public void setRequirement(boolean requirement) {
        this.requirement = requirement;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", eventName='" + eventName + '\'' +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", address='" + address + '\'' +
                ", requirement=" + requirement +
                ", status=" + status +
                ", studentSet=" + studentSet +
                '}';
    }
}
