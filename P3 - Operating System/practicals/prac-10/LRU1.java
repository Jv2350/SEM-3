import java.util.*;

class LRU {
    Scanner sc = new Scanner(System.in);
    int[] frame, page, present;
    int size, pages, pf = 0, flag = 0, flag1 = 0;

    LRU(int size, int pages) {
        this.size = size;
        this.pages = pages;
        frame = new int[size];
        present = new int[size];
        page = new int[pages];
    }

    void get() {
        System.out.println("Enter pages");
        for (int i = 0; i < pages; i++)
            page[i] = sc.nextInt();
        for (int i = 0; i < size; i++)
            frame[i] = -1;
    }

    int check(int x) {
        flag = -1;
        for (int i = 0; i < size; i++)
            if (frame[i] == x) {
                flag = i;
                break;
            }
        return flag;
    }

    int replace(int x) {
        int i;
        for (i = 0; i < size; i++)
            present[i] = 0;
        flag1 = 0;
        for (i = x - 1; i >= 0; i--) {
            if (check(page[i]) >= 0) {
                flag1++;
                present[check(page[i])] = 1;
            }
            if (flag1 == (size - 1))
                break;
        }
        for (i = 0; i < size; i++)
            if (present[i] == 0) {
                flag1 = i;
                break;
            }
        return i;
    }

    void lru() {
        for (int i = 0; i < pages; i++) {
            if (i < size) {
                frame[i] = page[i];
                pf++;
                for (int j = 0; j < size; j++)
                    System.out.print(frame[j] + "    ");
                System.out.println();
            } else {
                if (check(page[i]) == -1) {
                    int r = replace(i);
                    frame[r] = page[i];
                    pf++;
                    for (int j = 0; j < size; j++)
                        System.out.print(frame[j] + "    ");
                    System.out.println();
                } else {
                    for (int j = 0; j < size; j++)
                        System.out.print(frame[j] + "    ");
                    System.out.println();
                }
            }
        }
        System.out.println("PAGE FAULT: " + pf);
    }
}

class LRU1 {
    public static void main(String arg[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter frame size:");
        int n = s.nextInt();
        System.out.print("Enter no of pages:");
        int p = s.nextInt();
        LRU obj = new LRU(n, p);
        obj.get();
        obj.lru();
    }
}
