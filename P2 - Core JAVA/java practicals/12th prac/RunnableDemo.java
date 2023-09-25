// Define a class A that implements the Runnable interface
class A implements Runnable {
    public void run() {
        int i;
        // Print numbers from 1 to 10 with thread identifier A
        for (i = 1; i <= 3; i++) {
            System.out.println("Thread A : " + i);
        }
    }
}

// Define a class B that implements the Runnable interface
class B implements Runnable {
    public void run() {
        int i;
        // Print numbers from 1 to 10 with thread identifier B
        for (i = 1; i <= 3; i++) {
            System.out.println("Thread B : " + i);
        }
    }
}

// Define a class C that implements the Runnable interface
class C implements Runnable {
    public void run() {
        int i;
        // Print numbers from 1 to 10 with thread identifier C
        for (i = 1; i <= 3; i++) {
            System.out.println("Thread C : " + i);
        }
    }
}

// Define a class RunnableDemo
class RunnableDemo {
    public static void main(String hello[]) throws Exception {
        System.out.println("Main starts");
        
        // Create three thread objects (t1, t2, t3) associated with A, B, and C
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new B());
        Thread t3 = new Thread(new C());

        // Start the threads
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to finish
        t1.join();
        t2.join();
        t3.join();

        System.out.println("Main ends");
    }// end main()
}// end class
