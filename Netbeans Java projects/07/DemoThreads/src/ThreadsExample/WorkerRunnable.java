package ThreadsExample;


public class WorkerRunnable implements Runnable {

    private final int id;
    private final int numberOfJobs;

    public WorkerRunnable(int id, int jobs) {
        this.id = id;
        numberOfJobs = jobs;
    }

    public String getName() {
        return "WorkerRunnable " + id;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (int i = 0; i < numberOfJobs; ++i) {
            System.out.println("Thread name: " + thread.getName());
        }
    }

    public static void main(String[] args) {
        WorkerRunnable worker = new WorkerRunnable(1, 10);

        Thread thread = new Thread(worker, worker.getName());
        thread.start();
    }
}
