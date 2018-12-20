package sc.lab4.company;

import sc.lab4.Bill;
import sc.lab4.Task;
import sc.lab4.Tools;

public class BuildingCompany {
	private String name;

	private Order[] orders = new Order[10];

	private Manager manager;
	private Designer designer;

	// Constructors

	public BuildingCompany(String name, Manager manager, Designer designer) {
		this.name = name;
		this.manager = manager;
		this.designer = designer;
	}

	public BuildingCompany(String name) {
		this(name, new Manager(), new Designer());
	}

	// Process task and add order to array

	public Bill addOrder(Task task) {
		int orderNumber = Tools.getFreeElement(orders); // check if company has free space for new orders
		if (orderNumber == -1) {
			System.out.format("%s is busy, try again later.", name);
			return null;
		}

		Bill bill = designer.estimatePrice(task, orderNumber); // Create bill
		Order order;

		try {
			order = manager.registerTask(task, bill);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

		orders[orderNumber] = order; // Adding created order to array
		System.out.printf("Order number %d added successfully.\n", orderNumber);

		try {
			designer.assignBill(order); // Try to assign bill
			System.out.printf("Bill of order %d is successfully assigned to %s %s.\n", orderNumber,
					task.client.getFirstName(), task.client.getLastName());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.printf("Deleting order %d...\n", orderNumber);
			orders[orderNumber] = null;
			System.out.println("Done");
			return null;
		}

		return bill; // Return bill if assigned successfully
	}

	// Complete order which number is specified in bill

	public Building completeOrder(Bill bill) {
		if (bill == null) {
			System.out.println("Bill doesn't exist!");
			return null;
		}

		try {
			int orderNumber = bill.orderNumber;

			Order order = orders[orderNumber];

			if (!order.bill.isPaid()) {
				throw new Exception(String.format("The bill for order %d is not paid!", order.bill.orderNumber));
			}

			BuilderTeam builderTeam = designer.assessOrder(order); // Create a team of builders
			System.out.println("Team of builders is created.");

			Building building = builderTeam.createProject(order); // Create a foundation of the future building
			System.out.printf("Foundation for a %d-floor building with the size of %d m^2 is created.\n",
					building.floorsNumber, building.sizeM2);

			builderTeam.build(building); // Build the construction
			System.out.printf("%d-floor building %d m^2 in size is built.\n", building.floorsNumber, building.sizeM2);
			orders[orderNumber] = null; // Removing completed order from array
			System.out.printf("Order %d is completed.\n", orderNumber);

			return building; // Return the successfully built house
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Accessor & mutator methods

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
