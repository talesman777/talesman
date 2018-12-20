package sc.lab4.company;

import sc.lab4.Bill;
import sc.lab4.Task;

class Order {
	public final Task task;
	public final Bill bill;

	Order(Task task, Bill bill) {
		this.task = task;
		this.bill = bill;
	}
}
