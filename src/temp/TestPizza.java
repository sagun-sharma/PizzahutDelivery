package temp;

public class TestPizza {
	public static void main(String args[]) {
		Pizzahut pizzahut = new Pizzahut();
		pizzahut.openPizzaHut();
		
		Customer customer = new Customer(pizzahut, 0);
		customer.start();
		Customer customer1 = new Customer(pizzahut, 1);
		customer1.start();
	}
}
