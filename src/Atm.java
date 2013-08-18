
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

        if ((command.code & Command.MASK_BANKING) == Command.MASK_BANKING) {
            processBanking(command);
        } else if ((command.code & Command.MASK_MUNICIPAL) == Command.MASK_MUNICIPAL) {
            processMunicipal(command);
        }

    }

    public void processBanking(Command command) {
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
        }
    }
    public void processMunicipal(Command command) {
        switch (command.code) {
            case Command.MUNICIPAL_ELECTRICITY:
                account.addAmount(-command.param * 2);
                System.out.println( "buy " + command.param + " unit of electricity, remain balance is " + account.getAmount());
                break;
       }
    }
}
