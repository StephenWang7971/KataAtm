
public class User {

     Account account = new Account();


    public void initAccount(int amount) {
        account.setAmount(amount);
    }


    public static  void main(String [] args) {
        User user = new User();
        user.initAccount(800);
        Atm.getInstance().bindAccount(user.account);
        user.operate(Command.DEPOSIT, 300);
        user.operate(Command.CHECK_BALANCE, null);
        user.operate(Command.WITH_DRAW, 1000);
        user.operate(Command.CHECK_BALANCE, null);
        user.operate(Command.BUY_ELECTRICITY, 100);
        user.operate(Command.CHECK_BALANCE, null);
        user.operate(Command.BUY_ELECTRICITY, 10);
        user.operate(Command.CHECK_BALANCE, null);
        Atm.getInstance().unbindAccount();
    }

    private void operate(int command, Integer param) {
        Atm.getInstance().onCommand(command, param);
    }
}
