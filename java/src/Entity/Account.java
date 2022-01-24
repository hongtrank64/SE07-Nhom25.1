package Entity;

import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("response")
    private String response;

    @SerializedName("name")
    private String full_name;


    @SerializedName("studentID")
    private String studentID;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String pass;

    @SerializedName("root")
    private int root;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Account() {
    }

    public Account(String response, String full_name, String studentID, String username, String pass, int root) {
        this.response = response;
        this.full_name = full_name;
        this.studentID = studentID;
        this.username = username;
        this.pass = pass;
        this.root = root;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }


}

