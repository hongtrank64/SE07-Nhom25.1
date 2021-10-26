package Entity;
import java.io.Serializable;

public class Account implements Serializable{
    private String studentID;
    private String username;
    private String pass;
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

    @Override
    public String toString() {
        return "Account{" +
                "studentID='" + studentID + '\'' +
                ", username='" + username + '\'' +
                ", pass='" + pass + '\'' +
                ", root=" + root +
                '}';
    }
}
