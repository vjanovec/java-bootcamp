import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance;
    private String accountNumber;
    private Lock lock = new ReentrantLock();

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
            if (lock.tryLock()) {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                }
                balance -= amount;
                System.out.printf("%s: Withdrew %f\n", Thread.currentThread().getName(), amount);
                return true;
            }

        return false;
    }

    public boolean deposit(double amount) {
            if (lock.tryLock()) {
                try {
                    // Simulate database access
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                } finally {
                    lock.unlock();
                }
                balance += amount;
                System.out.printf("%s: Deposited %f\n", Thread.currentThread().getName(), amount);
                return true;
            }


        return false;
    }

    public boolean transfer(BankAccount destinationAccount, double amount) {
        if (withdraw(amount)) {
            if (destinationAccount.deposit(amount)) {
                System.out.println("Successfull transfer");
                return true;
            } else {
                // The deposit failed. Refund the money back into the account.
                System.out.printf("%s: Destination account busy. Refunding money\n",
                        Thread.currentThread().getName());
                deposit(amount);
            }
        }

        return false;
    }
}