package sc.lab4;

public class Task {
	public final Client client;
	public final int floorsNumber;
	public final int sizeM2;

	public Task(Client client, int floorsNumber, int sizeM2) {
		this.client = client;
		this.floorsNumber = floorsNumber;
		this.sizeM2 = sizeM2;
	}
}
