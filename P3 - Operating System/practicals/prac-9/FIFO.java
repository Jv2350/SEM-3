import java.util.Scanner;

public class FIFO {
    public static void main(String[] args) {
        int f, p, num = 0, pageHit = 0;
        int pages[];
        int frame[];
        boolean flag = true;

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter number of frames: ");
            f = input.nextInt();

            System.out.print("Enter number of pages: ");
            p = input.nextInt();

            frame = new int[f];
            pages = new int[p];

            for (int i = 0; i < f; i++)
                frame[i] = -1;

            System.out.print("Enter page number: ");
            for (int i = 0; i < p; i++)
                pages[i] = input.nextInt();
        }
        for (int i = 0; i < p; i++) {
            flag = true;
            int page = pages[i];
            for (int j = 0; j < f; j++) {
                if (frame[j] == page) {
                    flag = false;
                    pageHit++;
                    break;
                }
            }
            if (num == f)
                num = 0;
            if (flag) {
                frame[num] = page;
                num++;
            }
            System.out.print("Frame: ");
            for (int k = 0; k < f; k++)
                System.out.print(frame[k] + " ");
            System.out.println();
        }
        System.out.print("No. of pages hit: " + pageHit);
    }
}