package tracy.exceptions;

/**
 * User: tracy
 * Date: 2015/6/923:40
 */
public class InterruptibleSumCal {
    //throw InterruptedException,let the execute thread handle the exception
    public static long sum(long low, long high) throws InterruptedException {
        final long CHUNK_SIZE = 1024;
        long s = 0;

        for (long i = low; i <= high; i += CHUNK_SIZE) {
            for (long j = i; j < i + CHUNK_SIZE; j++) {
                s += j;
            }
            if (Thread.interrupted()) {
                throw new InterruptedException(String.format("Sum calculation interrupted. Current i: %d, partial sum: %d", i, s));
            }
        }
        return s;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run(){
                try {
                    long result = sum(0L, 1000000000L);
                    System.out.println("Finished. Result is " + result);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted.");
                    // Thread.currentThread().interrupt();
                    // I know it is the whole job, so no need to re-set the flag.
                }
            }
        };

        System.out.println("Start calculating...");
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
    }
}
