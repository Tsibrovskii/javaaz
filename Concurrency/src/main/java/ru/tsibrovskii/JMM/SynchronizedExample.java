package ru.tsibrovskii.JMM;

public class SynchronizedExample implements Runnable {

    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        Thread firstThread = new Thread(synchronizedExample);
        Thread secondThread = new Thread(synchronizedExample);
        firstThread.setName("First");
        secondThread.setName("Second");
        firstThread.start();
        secondThread.start();
    }

    private void makeWithdrawal(int amount) {
        if(account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " tries to withdraw money");
            try {
                System.out.println(Thread.currentThread().getName() + " sleep");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " awake");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " finishes transaction");
        } else {
            System.out.println("For " + Thread.currentThread().getName() + " not enough money");
        }
        System.out.println("Balance: " + account.getBalance());
    }

    @Override
    public void run() {
        while (account.getBalance() > 0) {
            makeWithdrawal(10);
        }
        System.out.println(Thread.currentThread().getName() + ", limit exceeded");
    }
}
