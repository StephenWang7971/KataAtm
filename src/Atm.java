
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

    public void onCommand(Command command) {
       switch(command.code) {
           case Command.CHECK_BALANCE:
               System.out.println("remain balance is " + account.getAmount());
               break;
           case Command.DEPOSIT:
               //TODO assert param is a plus.
               account.addAmount(command.param);
               System.out.println( "deposit " + command.param + ", remain balance is " + account.getAmount());
               break;
           case Command.WITH_DRAW:
               //TODO assert param is a plus.
               account.addAmount(-command.param);
               System.out.println( "withdraw " + command.param + ", remain balance is " + account.getAmount());
               break;
           case Command.MASK_MUNICIPAL:
               account.addAmount(-command.param * 2);
               System.out.println( "buy " + command.param + " unit of electricity, remain balance is " + account.getAmount());
               break;
       }
    }
}
