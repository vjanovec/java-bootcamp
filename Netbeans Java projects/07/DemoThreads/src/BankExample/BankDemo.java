package BankExample;

/**
 *
 * @author vokrinek
 */
public class BankDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5);
        System.out.println("Bank account initial value is  " + account.getActualBalance());

        AccountantAsync accountant1 = new AccountantAsync();
        AccountantAsync accountant2 = new AccountantAsync();

        accountant1.updateAccount(account, +50);
        accountant2.updateAccount(account, -10);

        accountant1.waitToFinishOperations();
        accountant2.waitToFinishOperations();

        System.out.println("Bank account final value is " + account.getActualBalance());

    }

}
