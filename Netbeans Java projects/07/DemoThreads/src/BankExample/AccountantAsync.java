package BankExample;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vokrinek
 */
public class AccountantAsync extends Thread {

    private BankAccount account;
    private int amount;

    public void updateAccount(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
        start();
    }

    @Override
    public void run() {
        // do do job
        int balance = account.getActualBalance();
        int newBalance = balance + amount;
        account.writeNewBalance(newBalance);

        // smarter version?
        //account.updateBalance(amount);
    }

    public void waitToFinishOperations() {
        try {
            this.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountantAsync.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
