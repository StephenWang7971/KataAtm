package com.sec.kata.atm.process;

import com.sec.kata.atm.command.Command;
import com.sec.kata.atm.Account;

public interface BankProcess {
    public void process(Account account, Command command);
}
