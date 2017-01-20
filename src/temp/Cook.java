package temp;

public class Cook extends Thread {

	Pizzahut hut;
	String cookName;
	Order o;

	public Cook(Pizzahut hut, String cookName) {
		super("cook");
		this.hut = hut;
		this.cookName = cookName;
	}

	public void run() {
		System.out.println("Cook:I am ready");
		// wait on queue
		// take order
		// prepare pizza
		// put in output queue
		// got back to 1

		for (int i = 0; i < 10; i++) {
			try {
				while (true) {
					System.out.println(cookName  + " : Waiting");
					Order order = hut.whatisTheNextOrder();
					System.out.println("Cook:Started preparing");
					Thread.sleep(15000);
					System.out.println("COok:Finished preparing");
					hut.preparedOrders.put(order);
				}
			} catch (Exception e) {
				System.err.print(e);
			}
		}
	}
}
