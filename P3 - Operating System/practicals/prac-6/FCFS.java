import java.util.*;

public class FCFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int ar[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int ta[] = new int[n];
        int wt[] = new int[n];
        int temp;
        float avgwt = 0, avgta = 0;

        // Input process arrival time and burst time
        for (int i = 0; i < n; i++) {
            System.out.print("Enter process " + (i + 1) + " arrival time: ");
            ar[i] = sc.nextInt();
            System.out.print("Enter process " + (i + 1) + " burst time: ");
            bt[i] = sc.nextInt();
            pid[i] = i + 1; // Assign process IDs
        }

        // Sort processes based on their arrival times using bubble sort
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (ar[j] > ar[j + 1]) {
                    // Swap arrival time, burst time, and process IDs
                    temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;
                    temp = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = temp;
                }
            }
        }

        // Calculate completion time, turnaround time, and waiting time for each process
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ct[i] = ar[i] + bt[i];
            } else {
                if (ar[i] > ct[i - 1]) {
                    ct[i] = ar[i] + bt[i];
                } else
                    ct[i] = ct[i - 1] + bt[i];
            }
            ta[i] = ct[i] - ar[i];
            wt[i] = ta[i] - bt[i];
            avgwt += wt[i];
            avgta += ta[i];
        }

        // Display the process details
        System.out.println("\nPID  Arrival  Burst  Complete  Turnaround  Waiting");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t\t" + wt[i]);
        }

        sc.close();
        
        // Calculate and display average waiting time and average turnaround time
        System.out.println("\nAverage Waiting Time: " + (avgwt / n));
        System.out.println("Average Turnaround Time: " + (avgta / n));
    }
}
