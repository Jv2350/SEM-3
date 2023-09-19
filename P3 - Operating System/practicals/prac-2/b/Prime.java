    import java.util.Scanner;

    // Create a class named "Job" that implements the Runnable interface
    class Job implements Runnable {
        int a1;        // Declare an integer variable to store a number
        Thread t;      // Declare a Thread object for concurrent execution

        // Constructor to initialize the number and start a new thread
        Job(int a) {
            a1 = a;       // Assign the input number to the instance variable
            t = new Thread(this);  // Create a new thread that runs the "run" method of this class
            t.start();   // Start the thread's execution
        }

        // The "run" method is called when the thread starts executing
        public void run() {
            try {
                int i, k = 0;
                for (i = 2; i < a1; i++) {
                    Thread.sleep(100);  // Pause the thread for 100 milliseconds
                    if (a1 % i == 0) {
                        System.out.println("Number is not prime");
                        k = 1;         // Set "k" to 1 to indicate the number is not prime
                        break;         // Exit the loop since we found a factor
                    }
                }
                if (k == 0) {
                    System.out.println("Number is prime");  // If "k" is still 0, the number is prime
                }
                System.out.println("Job is over");  // This message is printed when the thread completes its task
            } catch (InterruptedException e) {
                System.out.println("The job has been interrupted"); // Handle interruptions gracefully
            }
        }
    }

    public class Prime {
        public static void main(String args[]) {
            try {
                int n;
                Scanner s = new Scanner(System.in);
                System.out.print("Enter the value: ");
                n = s.nextInt();  // Read an integer from the user
                Job ji = new Job(n);  // Create a Job object with the user-provided number
            } catch (Exception e) {
                System.out.println("Some process failed to complete...");
                System.out.println("Please contact the system admin...");
            }
        }
    }
