import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SleepingBarber {
    public static void main(String args[]) {
        // Create an instance of the barbershop.
        Bshop shop = new Bshop();

        // Create a barber and a customer generator, passing the shop instance.
        Barber barber = new Barber(shop);
        CustomerGenerator cg = new CustomerGenerator(shop);

        // Create threads for the barber and customer generator.
        Thread thbarber = new Thread(barber);
        Thread thcg = new Thread(cg);

        // Start the threads.
        thcg.start();
        thbarber.start();
    }
}

class Barber implements Runnable {
    Bshop shop;

    public Barber(Bshop shop) {
        this.shop = shop;
    }

    public void run() {
        System.out.println("Barber started..");
        while (true) {
            // The barber keeps cutting hair as long as there are customers in the shop.
            shop.cutHair();
        }
    }
}

class Customer implements Runnable {
    String name;
    Date inTime;

    Bshop shop;

    public Customer(Bshop shop) {
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public Date getIntime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntime(Date inTime) {
        this.inTime = inTime;
    }

    public void run() {
        // When a customer runs, they go for a hair cut.
        goForHairCut();
    }

    // This method adds the customer to the barbershop.
    private synchronized void goForHairCut() {
        shop.add(this);
    }
}

class CustomerGenerator implements Runnable {
    Bshop shop;
    private static int customerCount = 0;

    public CustomerGenerator(Bshop shop) {
        this.shop = shop;
    }

    public void run() {
        while (true) {
            // Generate a new customer and set their arrival time.
            Customer customer = new Customer(shop);
            customer.setIntime(new Date());

            // Generate a unique customer name.
            String customerName = "Customer " + customerCount++;
            customer.setName(customerName);

            Thread thcustomer = new Thread(customer);

            // Start the customer thread.
            thcustomer.start();

            try {
                // Wait for a random time (up to 10 seconds) before generating the next customer.
                TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
    }
}

class Bshop {
    int nchair;
    List<Customer> listCustomer;

    public Bshop() {
        // Initialize the barbershop with 2 chairs and an empty customer list.
        nchair = 2;
        listCustomer = new LinkedList<Customer>();
    }

    public void cutHair() {
        Customer customer;

        // The barber waits for the lock on the customer list.
        System.out.println("Barber is waiting for lock");
        synchronized (listCustomer) {
            // If the customer list is empty, the barber waits for a customer.
            while (listCustomer.isEmpty()) {
                System.out.println("Barber is waiting for customer");
                try {
                    listCustomer.wait();
                } catch (InterruptedException iex) {
                    iex.printStackTrace();
                }
            }

            // When a customer is found in the queue, remove them from the list.
            System.out.println("Barber found a customer in the queue");
            customer = listCustomer.remove(0);
        }

        long duration = 0;
        try {
            // The barber simulates cutting hair for a random duration (up to 10 seconds).
            System.out.println("Cutting hair of customer: " + customer.getName());
            duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException iex) {
            iex.printStackTrace();
        }

        // After cutting hair, the barber informs that the customer's hair is cut.
        System.out.println("Completed cutting hair of customer: " + customer.getName() + " in " + duration + " seconds.");
    }

    public void add(Customer customer) {
        // When a customer enters the shop, their arrival time is displayed.
        System.out.println("Customer: " + customer.getName() + " entering the shop at " + customer.getIntime());

        synchronized (listCustomer) {
            // If there are no available chairs, the customer leaves the shop.
            if (listCustomer.size() == nchair) {
                System.out.println("No chair available for customer " + customer.getName());
                System.out.println("Customer " + customer.getName() + " exits..");
                return;
            }

            // If there is an available chair, the customer takes it and is added to the list.
            listCustomer.add(customer);
            System.out.println("Customer: " + customer.getName() + " got the chair.");

            // If this is the first customer in the list, notify the barber that a customer is waiting.
            if (listCustomer.size() == 1) {
                listCustomer.notify();
            }
        }
    }
}
