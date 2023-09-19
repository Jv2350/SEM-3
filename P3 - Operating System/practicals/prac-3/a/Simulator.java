class Database {
	private int readers;

	public Database() {
		this.readers = 0;
	}

	public void read(int number) {
		synchronized (this) {
			this.readers++;
			System.out.println("Reader " + " starts reading.");
		}
		final int DELAY = 5000;
		try {
			Thread.sleep((int) (Math.random() * DELAY));
		} catch (InterruptedException e) {
		}
		synchronized (this) {
			System.out.println("Reader " + number + "stops reading.");
			this.readers--;
			if (this.readers == 0) {
				this.notifyAll();
			}
		}
	}

	public synchronized void write(int number) {
		while (this.readers != 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Writer " + number + "starts waiting.");
		final int DELAY = 5000;
		try {
			Thread.sleep((int) (Math.random() * DELAY));
		} catch (InterruptedException e) {
		}
		System.out.println("Writer " + number + "stops writing.");
		this.notifyAll();
	}
}

class Reader extends Thread {
	private static int readers = 0;
	private int number;
	private Database database;

	/**
	 * Creates a Reader for the specified database.
	 * 
	 * @param database database from which to be read.
	 */
	public Reader(Database database) {
		this.database = database;
		this.number = Reader.readers++;
	}

	public void run() {
		while (true) {
			final int DELAY = 5000;
			try {
				Thread.sleep((int) (Math.random() * DELAY));
			} catch (InterruptedException e) {
			}
			this.database.read(this.number);
		}
	}
}

class Writer extends Thread {
	private static int writers = 0;

	private int number;
	private Database database;

	/**
	 * Creates a Writer for the specified database.
	 * 
	 * @param database database to which to write.
	 */
	public Writer(Database database) {
		this.database = database;
		this.number = Writer.writers++;
	}

	/**
	 * writes.
	 */
	public void run() {
		while (true) {
			final int DELAY = 5000;
			try {
				Thread.sleep((int) (Math.random() * DELAY));
			} catch (InterruptedException e) {
			}
			this.database.write(this.number);
		}
	}
}

public class Simulator {
	/**
	 * Creates the specified number of readers and writers and starts them.
	 * 
	 * @param args[0] The number of readers.
	 * @param args[1] The number of writers.
	 */
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: java Simulator <number of readers> <number of writers>");
		} else {
			final int READER = Integer.parseInt(args[0]);
			final int WRITER = Integer.parseInt(args[1]);
			Database database = new Database();
			for (int i = 0; i < READER; i++) {
				new Reader(database).start();
			}
			for (int i = 0; i < WRITER; i++) {
				new Writer(database).start();
			}
		}
	}
}
