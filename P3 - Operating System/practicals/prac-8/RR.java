import java.util.Arrays;

public class RR {
    static void findWaitingTime(int processes[], int n, int bt[], int wt[], int quantum) {
        int rem_bt[] = new int[n];
        // Initialize remaining burst times as the original burst times
        for (int i = 0; i < n; i++)
            rem_bt[i] = bt[i];
        
        int t = 0; // Current time
        
        while (true) {
            boolean done = true; // To check if all processes are done
            
            // Traverse all processes
            for (int i = 0; i < n; i++) {
                if (rem_bt[i] > 0) {
                    done = false;
                    
                    // If remaining burst time is more than the quantum, decrease it by quantum
                    if (rem_bt[i] > quantum) {
                        t += quantum;
                        rem_bt[i] -= quantum;
                    } 
                    // If remaining burst time is less than or equal to the quantum, finish the process
                    else {
                        t = t + rem_bt[i];
                        wt[i] = t - bt[i];
                        rem_bt[i] = 0;
                    }
                }
            }
            
            // If all processes are done, exit the loop
            if (done == true)
                break;
        }
    }

    static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
        for (int i = 0; i < n; i++)
            tat[i] = bt[i] + wt[i];
    }

    static void findavgTime(int processes[], int n, int bt[], int quantum) {
        int wt[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;

        // Calculate waiting time for all processes
        findWaitingTime(processes, n, bt, wt, quantum);

        // Calculate turnaround time for all processes
        findTurnAroundTime(processes, n, bt, wt, tat);

        // Print the table
        System.out.println("Processes\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            total_wt += wt[i];
            total_tat += tat[i];
            System.out.println(processes[i] + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }

        // Calculate and print average waiting time and average turnaround time
        float avg_wt = (float) total_wt / n;
        float avg_tat = (float) total_tat / n;
        System.out.println("\nAverage Waiting Time = " + avg_wt);
        System.out.println("Average Turnaround Time = " + avg_tat);
    }

    public static void main(String[] args) {
        int processes[] = {1, 2, 3};
        int n = processes.length;
        int burst_time[] = {10, 5, 8};
        int quantum = 2;

        findavgTime(processes, n, burst_time, quantum);
    }
}
