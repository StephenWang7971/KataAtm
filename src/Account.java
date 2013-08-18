
public class Account {
    private int amount;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(Integer param) {
        if (amount + param < 0 ) {
            System.out.println("You have no enough balance to operate.");
            return;
        }
        amount += param;
    }
}
