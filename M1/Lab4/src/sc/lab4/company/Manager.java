package sc.lab4.company;

import sc.lab4.Bill;
import sc.lab4.Person;
import sc.lab4.Task;

public class Manager extends Person {
	public Manager() {
		super();
	}

	public Manager(String firstName, String lastName, String telNumber) {
		super(firstName, lastName, telNumber);
	}

	Order registerTask(Task task, Bill bill) throws Exception { // Create an instance of Order with task and bill inside
		if (task.floorsNumber < 1 || task.sizeM2 < 1) {
			throw new IllegalArgumentException("Argument should be greater than 0");
		}

		return new Order(task, bill);
	}
}
