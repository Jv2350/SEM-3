import java.util.Scanner;

public class Summation {

    public static void main(String[] args) {
        try {
            int n;
            Scanner s = new Scanner(System.in);
            System.out.print("Enter the value: ");
            n = s.nextInt(); // Read the user input
            Job j1 = new Job(n); // Create a new Job object with the user input as the parameter
        } catch (Exception e) {
            // If any exception occurs during input or job creation, this block will execute
            System.out.println("Some process failed to complete...");
            System.out.println("Please contact the system admin...");
        }
    }
}


// Class representing a job that calculates the summation of numbers from 1 to a given input value
class Job implements Runnable {
    int a1; // Variable to store the input value
    Thread t; // Thread to run the job

    // Constructor to create a Job object and start a new thread for this job
    Job(int a) {
        a1 = a;
        t = new Thread(this);
        t.start(); // Start the thread and execute the run() method
    }

    // The run() method is called when the thread starts running
    public void run() {
        int b = 0; // Variable to store the summation result

        try {
            // Calculate the summation of numbers from 1 to the input value (a1)
            for (int i = 1; i <= a1; i++) {
                b = b + i;
                Thread.sleep(100); // Add a delay of 100 milliseconds to simulate some processing
            }
            // The 'try' block finishes here

            // Print the result inside the 'try' block
            System.out.println("The summation is: " + b);
            System.out.println("Job is over");
        } catch (InterruptedException e) {
            // If the thread is interrupted during the sleep, this block will execute
            System.out.println("The job has been interrupted...");
        }
    }
}

// Main class that takes user input and starts the job
