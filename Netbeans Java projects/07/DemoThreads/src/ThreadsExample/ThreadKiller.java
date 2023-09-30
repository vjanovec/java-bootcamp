package ThreadsExample;


import java.util.ArrayList;

public class ThreadKiller implements Runnable {

    ArrayList<Worker> threads;
    int timeout;

    public ThreadKiller(ArrayList<Worker> threads, int timeout) {
        this.threads = threads;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeout * 1000);
            System.out.println("ThreadKiller starts to shutdown threads");
            for (Worker thread : threads) {
                thread.shutdown();
            }
            for (Worker thread : threads) {
                thread.join();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
