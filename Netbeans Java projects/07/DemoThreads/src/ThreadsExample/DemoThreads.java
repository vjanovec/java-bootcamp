package ThreadsExample;


import java.util.ArrayList;

public class DemoThreads {

    public void start(int numberOfThreads) {
        ArrayList<Worker> threads = new ArrayList();
        for (int i = 0; i < numberOfThreads; ++i) {
            threads.add(new Worker(i, 10));
        }
        
        // start threads
        for (Thread thread : threads) {
            thread.setDaemon(true);
            thread.start();
        }
        Thread killer = new Thread(new ThreadKiller(threads, 2));
        killer.start();
        // wait for threads
        try {
            killer.join();
            System.out.println("Wait for threads");
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Watting for the thread end has been interrupted");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DemoThreads demo = new DemoThreads();
        demo.start(3);
    }

}
