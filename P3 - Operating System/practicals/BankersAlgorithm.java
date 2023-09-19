import java.io.*;

public class BankersAlgorithm {
    static int safe_sequence[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the total number of resources: ");

        // Input: Total number of resources
        int res_n = Integer.parseInt(br.readLine());
        int res[] = new int[res_n];
        int cur_avail[] = new int[res_n];

        // Input: Total instances for each resource and initialize current available resources
        for (int i = 0; i < res_n; i++) {
            System.out.print("Enter total number of instances for resources " + (i + 1) + ": ");
            res[i] = Integer.parseInt(br.readLine());
            cur_avail[i] = res[i];
        }

        System.out.print("\nEnter number of processes: ");
        int pros_n = Integer.parseInt(br.readLine());

        safe_sequence = new int[pros_n];
        int max[][] = new int[res_n][pros_n];
        int alloc[][] = new int[res_n][pros_n];

        // Input: Maximum resource allocation for each process
        for (int i = 0; i < pros_n; i++) {
            System.out.print("Enter the maximum string for process " + (i + 1) + ": ");
            String ip = br.readLine();
            for (int j = 0; j < res_n; j++)
                max[j][i] = Integer.parseInt(String.valueOf(ip.charAt(j)));
        }

        // Input: Allocation matrix for each process and update current available resources
        for (int i = 0; i < pros_n; i++) {
            System.out.print("Enter the allocation string for process " + (i + 1) + ": ");
            String ip = br.readLine();
            for (int j = 0; j < res_n; j++) {
                alloc[j][i] = Integer.parseInt(String.valueOf(ip.charAt(j)));
                cur_avail[j] = cur_avail[j] - alloc[j][i];
            }
        }
        
        int need[][] = new int[res_n][pros_n];

        // Calculate the resource needs of each process
        for (int i = 0; i < pros_n; i++) {
            for (int j = 0; j < res_n; j++)
                need[j][i] = max[j][i] - alloc[j][i];
        }

        // Check if the system is in a safe state
        boolean safe = check_state(need, alloc, cur_avail, res_n, pros_n);
        System.out.println();

        if (safe) {
            System.out.print("The system is in a safe state.");
            System.out.println("\nThe safe sequence is: ");
            for (int i = 0; i < pros_n; i++)
                System.out.print("P" + (safe_sequence[i] + 1) + " ");
            System.out.println();
        } else
            System.out.print("The system is not in a safe state.");

        if (safe) {
            System.out.println();
            System.out.print("Please enter the number of the process that is requesting more resources: ");
            int req_n = Integer.parseInt(br.readLine()) - 1;
            int req[] = new int[res_n];
            System.out.print("Please enter the request matrix: ");
            String ip = br.readLine();
            int need_count = 0;
            int avl_count = 0;

            // Input: Resource request for a process
            for (int i = 0; i < res_n; i++) {
                req[i] = Integer.parseInt(String.valueOf(ip.charAt(i)));
                if (req[i] <= need[i][req_n])
                    need_count++;
                if (req[i] <= cur_avail[i])
                    avl_count++;
            }

            if (need_count != res_n)
                System.out.println("The request cannot be granted since requested resources are more than previously declared maximum.");
            if (avl_count != res_n)
                System.out.println("The request cannot be granted since the amount of resources requested are not available.");
            if (need_count == res_n && avl_count == res_n) {
                for (int i = 0; i < res_n; i++) {
                    alloc[i][req_n] += req[i];
                    need[i][req_n] -= req[i];
                    cur_avail[i] -= req[i];
                }
                safe = check_state(need, alloc, cur_avail, res_n, pros_n);
                System.out.println();

                if (safe) {
                    System.out.print("The system will be in a safe state if the request is granted.");
                    System.out.println("\nThe safe sequence is: ");
                    for (int i = 0; i < pros_n; i++)
                        System.out.println("p" + (safe_sequence[i] + 1) + " ");
                    System.out.println();
                } else
                    System.out.print("The system will not be in a safe state if the request is granted.");
            }
        }
    }

    static boolean check_state(int need[][], int alloc[][], int cur_avail[], int res_n, int pros_n) {
        boolean marked[] = new boolean[pros_n];
        int safe_pos = 0;
        boolean safe = true;
        int avail[] = new int[res_n];

        // Copy current available resources
        for (int i = 0; i < res_n; i++)
            avail[i] = cur_avail[i];

        // Check if the system is in a safe state
        while (safe_pos < pros_n && safe) {
            for (int i = 0; i < pros_n; i++) {
                int c = 0;
                for (int j = 0; j < res_n; j++) {
                    if (need[j][i] <= avail[j])
                        c++;
                }
                if ((c == res_n) && (marked[i] == false)) {
                    for (int j = 0; j < res_n; j++) {
                        avail[j] += alloc[j][i];
                    }
                    marked[i] = true;
                    safe_sequence[safe_pos] = i;
                    safe_pos++;
                    break;
                }
                if (i == pros_n - 1 && c < res_n) {
                    safe = false;
                }
            }
        }
        return safe;
    }
}
