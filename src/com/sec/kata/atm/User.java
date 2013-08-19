package com.sec.kata.atm;

import com.sec.kata.atm.command.Command;

public class User {

     Account account = new Account();

    public void initAccount(int amount) {
        account.setAmount(amount);
    }

    public static  void main(String [] args) {
        User user = new User();
        user.initAccount(800);
        Atm.getInstance().bindAccount(user.account);
        user.operate(Command.DEPOSIT, 300f);
        user.operate(Command.CHECK_BALANCE, null);
        user.operate(Command.WITH_DRAW, 1000f);
        user.operate(Command.CHECK_BALANCE, null);
        user.operate(Command.MUNICIPAL_ELECTRICITY, 100f);
        user.operate(Command.CHECK_BALANCE, null);
        user.operate(Command.MUNICIPAL_ELECTRICITY, 10f);
        user.operate(Command.CHECK_BALANCE, null);
        Atm.getInstance().unbindAccount();
    }

    private void operate(int code, Float param) {
        Atm.getInstance().onCommand(new Command(code, param));
    }
}
