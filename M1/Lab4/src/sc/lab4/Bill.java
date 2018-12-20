package sc.lab4;

public class Bill {
	public final int orderNumber;
	public final double sum;
	private boolean paid; // true if bill has been paid

	public Bill(int orderNumber, double sum) {
		this.orderNumber = orderNumber;
		this.sum = sum;
	}

	public boolean isPaid() {
		return paid;
	}

	public void pay() {
		paid = true;
	}
}
