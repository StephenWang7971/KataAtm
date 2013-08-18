
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
        BankProcess process = ProcessFactory.create(command);
        if (process != null) {
            process.process(account, command);
        }
    }

}
