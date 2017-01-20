package temp;

class Customer extends Thread {

	int type = 0;
	Pizzahut hut;

	public Customer(Pizzahut hut, int type) {
		super("customer");
		this.hut = hut;
		this.type = type;
	}

	public void run() {
		System.out.println("Customer: came");
		Order order = hut.orderBoy.takeOrder(this);
		System.out.println("Customer/I: placed order for pizza");
		if (type == 0) {
			synchronized (order) {
				try {
					System.out.println("Customer: Waiting for pizza");
					order.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			while (true) {
				try {
					System.out.println("Customer: Waiting for pizza");
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Order deliverOrder = hut.deliveryBoy.deliverOrder(order);
				if(deliverOrder != null) {
					break;
				}
			}
		}
		System.out.println("Customer:Order received By Customer");
	}
}
// give me order boy's handler
// want to buy a pizz -- orderpizza -- will return order
// using order id it can call enquire
// or we will call him based on the order id.
// based on customer type it will wait on order object.
// or will keep on enquiring
// placeorder();
