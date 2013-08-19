package com.sec.kata.atm.process;

import com.sec.kata.atm.command.Command;

public class ProcessFactory {
    public static BankProcess create(Command command) {
        BankProcess process = null;
        if ((command.code & Command.MASK_BANKING) == Command.MASK_BANKING) {
            process = new Banking();
        } else if ((command.code & Command.MASK_MUNICIPAL) == Command.MASK_MUNICIPAL) {
            process = new Municipal();
        }
        return process;
    }
}
