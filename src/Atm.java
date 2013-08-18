
public class Atm {

    private static Atm instance = null;

    private Account account;

    public void bindAccount(Account account) {
        this.account = account;
    }
    public  void unbindAccount() {
        account = null;
    }

    public static Atm getInstance() {
        if (instance == null) {
            instance = new Atm();
        }
        return instance;
    }

    public void onCommand(int command, Integer param) {
       switch(command) {
           case Command.CHECK_BALANCE:
               System.out.println("remain balance is " + account.getAmount());
               break;
           case Command.DEPOSIT:
               //TODO assert param is a plus.
               account.addAmount(param);
               System.out.println( "deposit " + param + ", remain balance is " + account.getAmount());
               break;
           case Command.WITH_DRAW:
               //TODO assert param is a plus.
               account.addAmount(-param);
               System.out.println( "withdraw " + param + ", remain balance is " + account.getAmount());
               break;
           case Command.BUY_ELECTRICITY:
               account.addAmount(-param * 2);
               System.out.println( "buy " + param + " unit of electricity, remain balance is " + account.getAmount());
               break;
       }
    }
}
