package BankExample;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author vokrinek
 */
public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

//    may be used to solve the problem somehow?
//    public void updateBalance(int amount) {
//        writeNewBalance(getActualBalance() + amount);
//    }

    public int getActualBalance() {
        doLookBusy();
        return balance;
    }

    public void writeNewBalance(int balance) {
        doLookBusy();
        this.balance = balance;
    }

    private void doLookBusy() {
        try {
            TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            System.out.println("Someone is disturbing me!");
        }
    }
}
