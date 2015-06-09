package tracy.exceptions;

/**
 * User: tracy
 * Date: 2015/6/923:28
 */
public class InterruptibleSleep {

    // I know it is the whole job, so no need to re-set the flag.
    static class WholeJob extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(1000);
                System.out.println("I woke up by myself.");
            } catch (InterruptedException e) {
                System.out.println("I was interrupted.");
                // Thread.currentThread().interrupt();
                // I know it is the whole job, so no need to re-set the flag.
            }
        }
    }

    //Wrong handle case
    static class WrongHandle extends Thread{
        @Override
        public void run(){
            int i = 0;
            while (true) {
                System.out.println(i);
                i++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { // WRONG!!!
                    e.printStackTrace();
                    //won't stop the thread,after the exception is printed,the thread will
                    //continue execute
                }
            }
        }
    }

    static class RightHandle extends Thread{
        @Override
        public void run(){
            int i = 0;
            try {
                while (true) {
                    System.out.println(i);
                    i++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Counter interrupted. Stop.");
                // Thread.currentThread().interrupt();
                // I know it is the whole job, so no need to re-set the flag.
            }
        }
    }



    public static void main(String[] args) throws InterruptedException {
        Thread sleeper = new WholeJob();
        sleeper.start();
        Thread.sleep(500);
        System.out.println("Main thread woke up.");
        sleeper.interrupt();
        sleeper.join();
    }
}
