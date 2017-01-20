package temp;

import java.util.ArrayList;
import java.util.List;

public class DeliveryBoy extends Thread {
	
	Pizzahut hut;
	Order o;
	List<Order> toBeDelivered = new ArrayList<Order>();
	public DeliveryBoy(Pizzahut hut) {
		super("DeliveryBoy");
		this.hut = hut;
	}

	public void run() {
		while(true){
			try{
				Order order = hut.nextOrderToBedelivered();
				if(order.custname.type == 0) {
					System.out.println("DeliveryBoy: Handing over order to customer");
					synchronized (order) {
						order.notify();
					}
				} else {
					toBeDelivered.add(order);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	public Boolean isOrderReady(Order order) {
		return toBeDelivered.contains(order);
	}
	
	public Order deliverOrder(Order order) {
		if(isOrderReady(order)) {
			System.out.println("DeliveryBoy: Handing over order to customer");
			return order;
		} else
			return null;
	}
}