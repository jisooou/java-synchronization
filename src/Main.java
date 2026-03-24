public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

//        Thread 1 : deposit
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                bankAccount.deposit(200);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        Thread 2 : withdraw
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                bankAccount.withdraw(100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        start
        t1.start();
        t2.start();

//        wait -> finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        결과 출력
        System.out.println("Final Balance : " + bankAccount.getBalance());
    }
}