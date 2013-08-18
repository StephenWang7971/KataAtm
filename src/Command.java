
public class Command {

    public static final int MASK_BANKING = 0x4000;

    public static final int CHECK_BALANCE = 0x4000;
    public static final int WITH_DRAW = 0x4001;
    public static final int DEPOSIT = 0x4002;
    public static final int TRANSFER = 0x4004;
    public static final int INTEREST = 0x4008;

    public static final int MASK_CREDIT = 0x2000;
    public static final int PAYBACK = 0x2001;
    public static final int EXPENSE = 0x2002;
    public static final int CASH_LOAN = 0x2004;

    public static final int MASK_MUNICIPAL = 0x1000;

    public static final int MUNICIPAL_ELECTRICITY = 0x1001;
    public static final int MUNICIPAL_WATER = 0x1002;
    public static final int MUNICIPAL_GAS = 0x1004;
    public static final int MUNICIPAL_NET = 0x1008;
    public static final int MUNICIPAL_TELEPHONE = 0x1010;

    public int code;
    public Float param;

    public Command(int code, Float param) {
        this.code = code;
        this.param = param;
    }
}
