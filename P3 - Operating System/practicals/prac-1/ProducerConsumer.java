public class ProducerConsumer {
    public static void main(String[] args) {
        // Create a shared Shop object
        Shop c = new Shop();

        // Create and start a Producer thread
        Producer p1 = new Producer(c, 1);
        p1.start();

        // Create and start a Consumer thread
        Consumer c1 = new Consumer(c, 1);
        c1.start();
    }
}

// Shop class represents a shared resource where producers put materials and consumers get materials
class Shop {
    private int materials;
    private boolean available = false;

    // Consumer method to get materials from the shop
    public synchronized int get() {
        while (!available) {
            try {
                // If materials are not available, the consumer waits until materials are put by the producer
                wait();
            } catch (InterruptedException ie) {
                // Handle interrupted exception if it occurs during waiting
                ie.printStackTrace();
            }
        }
        // When materials are available, the consumer takes them and notifies waiting threads (producers)
        available = false;
        notifyAll();
        return materials;
    }

    // Producer method to put materials into the shop
    public synchronized void put(int value) {
        while (available) {
            try {
                // If materials are available, the producer waits until they are consumed by the consumer
                wait();
            } catch (InterruptedException ie) {
                // Handle interrupted exception if it occurs during waiting
                ie.printStackTrace();
            }
        }
        // When materials are consumed, the producer puts new materials and notifies waiting threads (consumers)
        materials = value;
        available = true;
        notifyAll();
    }
}

// Consumer class represents a thread that consumes materials from the shop
class Consumer extends Thread {
    private Shop shop;
    private int number;

    public Consumer(Shop c, int number) {
        shop = c;
        this.number = number;
    }

    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
            // The consumer gets materials from the shop and prints the output
            value = shop.get();
            System.out.println("Consumer consumed " + this.number + " value and got: " + value);
        }
    }
}

// Producer class represents a thread that produces and puts materials into the shop
class Producer extends Thread {
    private Shop shop;
    private int number;

    public Producer(Shop c, int number) {
        shop = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            // The producer puts materials into the shop and prints the output
            shop.put(i);
            System.out.println("Producer produced " + this.number + " value and put: " + i);
            try {
                // The producer sleeps for a random time (up to 100 milliseconds) to simulate production time
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException ie) {
                // Handle interrupted exception if it occurs during sleeping
                ie.printStackTrace();
            }
        }
    }
}


// The program demonstrates a classic producer-consumer problem, where one thread (producer) produces materials and puts them into a shared shop, and another thread (consumer) consumes the materials from the shop. The Shop class is used to synchronize access to the shared resource, ensuring that the producer and consumer threads do not interfere with each other during their operations.