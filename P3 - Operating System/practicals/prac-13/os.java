class room {

    public synchronized void takesLecture(String name) throws InterruptedException {
        System.out.println(name + " enters...");
        Thread.sleep(250);
        System.out.println(name + " starts lecture...");
        Thread.sleep(500);
        System.out.println(name + " exits...");
        Thread.sleep(250);
    }
}

class lecturer implements Runnable {
    String name;
    room r;
    Thread t;

    lecturer(String n, room r) {
        name = n;
        t = new Thread(this, n);
        this.r = r;
    }

    public void start() {
        t.start();
    }

    public void run() {
        try {
            r.takesLecture(name);
        } catch (InterruptedException e) {
            System.out.println(name + " operation interrupted...");
        }
    }
}

class os {

    public static void main(String args[]) {
        room r = new room();
        lecturer kamlakar = new lecturer("Kamlakar Sir", r);
        lecturer madhavi = new lecturer("Madhavi Madam", r);
        lecturer prajisha = new lecturer("Prajisha Madam", r);
        kamlakar.start();
        madhavi.start();
        prajisha.start();
    }
}