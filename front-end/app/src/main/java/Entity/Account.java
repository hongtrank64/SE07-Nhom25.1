package Entity;

import com.google.gson.annotations.SerializedName;

public class Account {

    @SerializedName("response")
    private String response;

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

    public Account(String response, String studentID, String username, String pass, int root) {
        this.response = response;
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

