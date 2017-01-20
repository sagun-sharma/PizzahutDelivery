package temp;

import java.util.concurrent.ArrayBlockingQueue;

class Pizzahut {
	
	public ArrayBlockingQueue<Order> pendingOrders = new ArrayBlockingQueue<Order>(100);
	Cook[] cooks=new Cook[]{new Cook(this, "Cook1"), new Cook(this, "cook2"), new Cook(this, "cook3")};
	TakeOrder orderBoy = new TakeOrder(this);
	DeliveryBoy deliveryBoy = new DeliveryBoy(this);
	public ArrayBlockingQueue<Order> preparedOrders = new ArrayBlockingQueue<Order>(100);

	public Pizzahut() {
	}

	public void openPizzaHut() {
		for(Cook cook : cooks) {
			cook.start();
		}
		orderBoy.start();
		deliveryBoy.start();
	}

	public void placeorder(Order order) {
		pendingOrders.add(order);
		
	}

	public Order whatisTheNextOrder() {
		return pendingOrders.remove();
	}
	
	public Order nextOrderToBedelivered() {
		return preparedOrders.remove();
	}
	
	public void completePreparation(Order order) {
		preparedOrders.add(order);
	}
	
}

