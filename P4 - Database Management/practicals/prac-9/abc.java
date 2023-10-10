public class abc {
    public static void main(String[] args) {
        // Create three instances of the Runnable object
        RunnableTask task1 = new RunnableTask("Thread 1");
        RunnableTask task2 = new RunnableTask("Thread 2");
        RunnableTask task3 = new RunnableTask("Thread 3");

        // Create three threads and start them
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Wait for all three threads to complete
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished execution.");
    }

    // Define a Runnable task
    static class RunnableTask implements Runnable {
        private final String threadName;
        private static final int NUM_EXECUTIONS = 10;

        public RunnableTask(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i = 1; i <= NUM_EXECUTIONS; i++) {
                synchronized (RunnableTask.class) {
                    System.out.println(threadName + " - Execution " + i);
                }
                try {
                    Thread.sleep(100); // Sleep for 100 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
