public class Banking implements BankProcess {
    @Override
    public void process(Account account, Command command) {
        switch(command.code) {
            case Command.CHECK_BALANCE:
                System.out.println("remain balance is " + account.getAmount());
                break;
            case Command.DEPOSIT:
                account.addAmount(command.param);
                System.out.println( "deposit " + command.param + ", remain balance is " + account.getAmount());
                break;
            case Command.WITH_DRAW:
                account.addAmount(-command.param);
                System.out.println( "withdraw " + command.param + ", remain balance is " + account.getAmount());
                break;
        }
    }
}
