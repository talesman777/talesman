package sc.lab4;

public class Client extends Person {
	private Bill[] billsToPay = new Bill[10];

	// Constructors

	public Client() {
		super();
	}

	public Client(String firstName, String lastName, String telNumber) {
		super(firstName, lastName, telNumber);
	}

	// Methods

	public Task createTask(int floorsNumber, int sizeM2) {
		return new Task(this, floorsNumber, sizeM2);
	}

	public void addBill(Bill bill) throws Exception { // Add bill to array
		int index = Tools.getFreeElement(billsToPay);
		if (index == -1) {
			throw new Exception(String.format("%s %s can't have any more bills.", getFirstName(), getLastName()));
		}

		billsToPay[index] = bill;
	}

	public void payBill(Bill bill) {
		if (bill == null) {
			System.out.println("Bill doesn't exist!");
			return;
		}

		for (int i = 0; i < billsToPay.length; i++) {
			if (billsToPay[i] == bill) {
				billsToPay[i].pay();
				billsToPay[i] = null;
				System.out.printf("Bill of order %d is paid.\n", bill.orderNumber);
			}
		}
	}
}
