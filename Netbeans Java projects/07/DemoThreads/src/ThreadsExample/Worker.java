package ThreadsExample;


public class Worker extends Thread {

    private final int numberOfJobs;
    private volatile boolean stop;

    public Worker(int id, int jobs) {
        super("Worker " + id);
        numberOfJobs = jobs;
        stop = false;
        System.out.println("Worker id: " + id + " has been created threadID:" + getId());
    }

    public void run() {
        for (int i = 0; i < numberOfJobs; ++i) {
            if (stop) {
                System.out.println("Thread '" + getName() + "' receives a request to stop");
                break;
            }
            doWork();
            System.out.println("This is thread '" + getName() + "' threadID: " + getId() + " job: " + i + " done");
        }
    }

    public void shutdown() {
        stop = true;
    }

    private void doWork() {
        try {
            Thread.sleep(500); //sleep for 0.5 second
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
