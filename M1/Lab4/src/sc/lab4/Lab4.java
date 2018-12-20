package sc.lab4;

import sc.lab4.company.Building;
import sc.lab4.company.BuildingCompany;

public class Lab4 {
	public static void main(String[] args) {
		BuildingCompany company = new BuildingCompany("Test");
		Client client = new Client();
		Task task = client.createTask(Tools.acceptNumber("Number of floors : "), Tools.acceptNumber("Size in m^2 : "));

		Bill bill = company.addOrder(task);
		client.payBill(bill);

		Building builtHouse = company.completeOrder(bill);
	}
}
