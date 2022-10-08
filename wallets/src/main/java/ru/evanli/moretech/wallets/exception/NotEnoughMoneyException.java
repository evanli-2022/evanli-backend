package ru.evanli.moretech.wallets.exception;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {
        super("The wallet has no enough money");
    }
}
