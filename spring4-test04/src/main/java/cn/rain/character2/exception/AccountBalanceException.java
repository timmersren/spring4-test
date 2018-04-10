package cn.rain.character2.exception;

/**
 * description:
 *
 * @author 任伟
 * @date create on 2018-04-10 14:08
 **/
public class AccountBalanceException extends RuntimeException {
    public AccountBalanceException() {
        this("账户余额不足，请充值后再购买!");
    }

    public AccountBalanceException(String message) {
        super(message);
    }
}
