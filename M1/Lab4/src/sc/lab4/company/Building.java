package sc.lab4.company;

public class Building {
	public final int floorsNumber;
	public final int sizeM2;
	private boolean isBuilt;

	Building(int floorsNumber, int sizeM2) {
		this.floorsNumber = floorsNumber;
		this.sizeM2 = sizeM2;
	}

	public boolean getIsBuilt() {
		return isBuilt;
	}

	void build() {
		isBuilt = true;
	}
}
