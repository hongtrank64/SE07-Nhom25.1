package Entity;

import com.google.gson.annotations.SerializedName;

import java.util.HashSet;
import java.util.Set;

public class Subject {

    @SerializedName("response")
    private String response;

    @SerializedName("subjectCode")
    private String subjectCode;

    @SerializedName("subjectTitle")
    private String subjectTitle;

    @SerializedName("credits")
    private Integer credits;

    @SerializedName("teacherName")
    private String teacherName;

    @SerializedName("type")
    private String type;

    @SerializedName("room")
    private String room;

    @SerializedName("timeStart")
    private Integer timeStart;

    @SerializedName("timeEnd")
    private Integer timeEnd;

    @SerializedName("day")
    private String day;

    @SerializedName("semester")
    private Integer semester;

    @SerializedName("year")
    private String year;

    private Set<StudentSubject> studentSubjectSet = new HashSet<>();

    public Subject() {
    }

    public Subject(String response, String subjectCode, String subjectTitle) {
        this.response = response;
        this.subjectCode = subjectCode;
        this.subjectTitle = subjectTitle;
    }

    public Subject(String response, String subjectCode, String subjectTitle, Integer credits, String teacherName) {
        this.response = response;
        this.subjectCode = subjectCode;
        this.subjectTitle = subjectTitle;
        this.credits = credits;
        this.teacherName = teacherName;
    }

    public String getResponse() {
        return response;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Integer timeStart) {
        this.timeStart = timeStart;
    }

    public Integer getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Integer timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Set<StudentSubject> getStudentSubjectSet() {
        return studentSubjectSet;
    }

    public void setStudentSubjectSet(Set<StudentSubject> studentSubjectSet) {
        this.studentSubjectSet = studentSubjectSet;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectTitle='" + subjectTitle + '\'' +
                '}';
    }
}
