public class Municipal implements BankProcess {
    @Override
    public void process(Account account, Command command) {
        switch (command.code) {
            case Command.MUNICIPAL_ELECTRICITY:
                account.addAmount(-command.param * 2);
                System.out.println( "buy " + command.param + " unit of electricity, remain balance is " + account.getAmount());
                break;
        }
    }
}
