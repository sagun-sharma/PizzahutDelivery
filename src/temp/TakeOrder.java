package temp;

public class TakeOrder extends Thread {
	Pizzahut ph;

	public TakeOrder(Pizzahut ph) {
		super("OrderBoy");
		this.ph = ph;
	}

	public Order takeOrder(Customer customer) {
		Order order = new Order(customer);
		ph.placeorder(order);
		return order;

	}

	public void run() {
		// Always be ready to take order
		// talk to customer
		System.out.println("Please order");
	}
}