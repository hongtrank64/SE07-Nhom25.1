package Entity;

public class Money {
    private String name;
    private int money;
    private int root;
    // 0 là thu, 1 là chi

    public Money() {
    }

    public Money(String name, int money, int root) {
        this.name = name;
        this.money = money;
        this.root = root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
