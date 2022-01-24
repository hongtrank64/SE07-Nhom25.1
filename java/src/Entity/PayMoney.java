package Entity;

import java.util.ArrayList;
import java.util.List;
import Entity.Money;

public class PayMoney {
    private List<Money> moneyList = new ArrayList<Money>();

    public static int pay(List<Money> monies) {
        int total = 0;
        for(int i = 0; i < monies.size(); i++) {
            if(monies.get(i).getRoot() == 0)
                total += monies.get(i).getMoney();
            else total -= monies.get(i).getMoney();
        }
        return total;
    }
}
