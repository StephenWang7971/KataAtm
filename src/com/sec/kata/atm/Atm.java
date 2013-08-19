package com.sec.kata.atm;

import com.sec.kata.atm.command.Command;
import com.sec.kata.atm.exception.InsufficientBalanceException;
import com.sec.kata.atm.process.BankProcess;
import com.sec.kata.atm.process.ProcessFactory;

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
            try {
                process.process(account, command);
            } catch (InsufficientBalanceException e) {
                System.out.println("You have no enough balance to operate.");
            } catch (IllegalArgumentException e) {
                System.out.println("The parameter to operate must be plus.");
            }
        }
    }

}
