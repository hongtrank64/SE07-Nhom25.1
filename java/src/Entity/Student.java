package Entity;

import java.util.*;

public class Student {
    private String studentID;
    private String name;
    private String gender;
    private Date birthday;
    private String address;
    private String classroom;
    private String email;
    private String phone;
    private Float GPA;
    private Account account;
    private List<TrainingScores> trainingScores = new ArrayList<TrainingScores>();
    private Set<Event> eventSet = new HashSet<>();
    private Set<StudentSubject> subjectSet = new HashSet<>();
    private Integer creditsCount = 0;

    public Student() {
    }

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public Student(String studentID, String name, String gender, Date birthday, String address, String classroom, String email, String phone) {
        this.studentID = studentID;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.classroom = classroom;
        this.email = email;
        this.phone = phone;
        this.GPA = (float) 0.0;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Float getGPA() {
        return GPA;
    }

    public void setGPA(Float GPA) {
        this.GPA = GPA;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }

    public Integer getCreditsCount() {
        return creditsCount;
    }

    public void setCreditsCount(Integer creditsCount) {
        this.creditsCount = creditsCount;
    }

    public List<TrainingScores> getTrainingScores() {
        return trainingScores;
    }

    public void setTrainingScores(List<TrainingScores> trainingScores) {
        this.trainingScores = trainingScores;
    }

    public Set<StudentSubject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<StudentSubject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", classroom='" + classroom + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", GPA=" + GPA +
                ", account=" + account +
                ", trainingScores=" + trainingScores +
                ", subjectSet=" + subjectSet +
                ", creditsCount=" + creditsCount +
                '}';
    }
}
