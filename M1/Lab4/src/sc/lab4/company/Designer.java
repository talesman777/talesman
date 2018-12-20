package sc.lab4.company;

import sc.lab4.Bill;
import sc.lab4.Person;
import sc.lab4.Task;

public class Designer extends Person {
	// Constructors
	
	public Designer() {
		super();
	}

	public Designer(String firstName, String lastName, String telNumber) {
		super(firstName, lastName, telNumber);
	}

	// Create bill basing on the construction size

	Bill estimatePrice(Task task, int orderNumber) {
		return new Bill(orderNumber, (double) task.floorsNumber * task.sizeM2 * 1000);
	}

	// Assign bill to a client

	void assignBill(Order order) throws Exception {
		order.task.client.addBill(order.bill);
	}

	// Create a team of builders to build

	BuilderTeam assessOrder(Order order) {
		return new BuilderTeam(10);
	}
}
