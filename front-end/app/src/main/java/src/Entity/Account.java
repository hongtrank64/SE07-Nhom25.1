package src.Entity;

import com.google.gson.annotations.SerializedName;

public class Account {

    private String Response;

    @SerializedName("studentID")
    private String studentID;

    @SerializedName("Ten dang nhap")
    private String username;

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

    @SerializedName("Mat khau")
    private String pass;

    @SerializedName("")
    private int root;


    public Account() {

    }

    public Account(String studentID, String username, String pass, int root) {
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
