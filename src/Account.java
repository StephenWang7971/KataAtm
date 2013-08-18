
public class Account {
    private int amount;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(Float param) {
        if (amount + param < 0 ) {
            throw new InsufficientBalanceException();
        }
        amount += param;
    }
}
