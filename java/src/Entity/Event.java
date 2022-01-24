package Entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

public class Event implements Serializable{

    @SerializedName("response")
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @SerializedName("eventID")
    private String eventId;

    @SerializedName("eventName")
    private String eventName;

    @SerializedName("timeStart")
    private Date timeStart;

    @SerializedName("timeEnd")
    private Date timeEnd;

    @SerializedName("address")
    private String address;

    @SerializedName("requirement")
    private Integer requirement;

    @SerializedName("status")
    private Integer status;

    private Set<Student> studentSet = new HashSet<Student>();

    public Event() {
    }

    public Event(String eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
    }

    public Event(String response, String eventId, String eventName, Date timeStart, Date timeEnd, String address, Integer requirement, Integer status) {
        this.response = response;
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

    public Integer getRequirement() {
        return requirement;
    }

    public void setRequirement(Integer requirement) {
        this.requirement = requirement;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
