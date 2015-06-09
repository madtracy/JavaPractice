package tracy.exceptions;

/**
 * User: tracy
 * Date: 2015/6/923:43
 */

class SleepJob {
    public void run() {
        try {
            System.out.println("Started sleeping.");
            Thread.sleep(1000);
            System.out.println("Finished sleeping.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Re-set the interrupted flag.
        }
    }
}

public class MultiSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread sleeperThread = new Thread() {
            public void run() {
                SleepJob job1 = new SleepJob();
                SleepJob job2 = new SleepJob();
                SleepJob job3 = new SleepJob();

                job1.run();
                if (Thread.interrupted()) {
                    System.out.println("Interrupted in job1. Stop.");
                    return;
                }
                job2.run();
                if (Thread.interrupted()) {
                    System.out.println("Interrupted in job2. Stop.");
                    return;
                }
                job3.run();
                if (Thread.interrupted()) {
                    System.out.println("Interrupted in job3. Stop.");
                    return;
                }
            }
        };

        sleeperThread.start();
        Thread.sleep(1500);
        sleeperThread.interrupt();
        sleeperThread.join();
    }
}
