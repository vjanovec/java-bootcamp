package com.vojtechjanovec;

public class Main {

    public static void main(String[] args) {
	// write your code here
    final BankAccount account = new BankAccount("123245-678", 1000.00);
    Thread man = new Thread() {
        public void run() {
            account.deposit(300);
            account.withdraw(50);
        }
    };

    Thread women = new Thread(new Runnable() {
        @Override
        public void run() {
            account.deposit(203.75);
            account.withdraw(100);
        }
    });

    man.start();
    women.start();

    }
}
