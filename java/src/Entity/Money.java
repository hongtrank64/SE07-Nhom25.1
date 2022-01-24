package Entity;

import com.google.gson.annotations.SerializedName;

public class Money {

    @SerializedName("response")
    private String response;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String nameMoney;

    @SerializedName("money")
    private int money;

    @SerializedName("root")
    private int root; // 0 là thu, 1 là chi

    public Money() {
    }

    public Money(String response, int id, String nameMoney, int money, int root) {
        this.response = response;
        this.id = id;
        this.nameMoney = nameMoney;
        this.money = money;
        this.root = root;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMoney() {
        return nameMoney;
    }

    public void setNameMoney(String nameMoney) {
        this.nameMoney = nameMoney;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "Money{" +
                "response='" + response + '\'' +
                ", id=" + id +
                ", nameMoney='" + nameMoney + '\'' +
                ", money=" + money +
                ", root=" + root +
                '}';
    }
}