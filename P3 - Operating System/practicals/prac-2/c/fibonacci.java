import java.io.*;
import java.util.Scanner;

class job implements Runnable{
    int a1;
    Thread t;
    job(int a){
        a1 = a;
        t = new Thread(this);
        t.start();
    }

    public void run(){
        int t1 = 0, t2 =1;
        try{
            int i;
            for (i=1;i<=a1;++i){
                Thread.sleep(100);
                System.out.print(t1+" ");
                int sum = t1 + t2;
                t1 = t2;
                t2 = sum;
            }
            System.out.println("\nJob is over!!");
        } catch(InterruptedException e){
            System.out.println("The job has beeen interrupted");
        }
    }
}

class fibonacci{
    public static void main(String[] args){
        try{
            int n;
            Scanner s = new Scanner(System.in);
            System.out.print("Enter the value: ");
            n = s.nextInt();
            job j1 = new job(n);
        } catch(Exception e){
            System.out.println("Some process failed to complete");
            System.out.println("Please contact system admin");
        }
    }
}