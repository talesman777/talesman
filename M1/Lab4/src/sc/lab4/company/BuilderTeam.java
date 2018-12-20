package sc.lab4.company;

import sc.lab4.Person;

class BuilderTeam {
	private Person[] members;

	BuilderTeam(int workerNumber) {
		members = new Person[workerNumber];

		for (int i = 0; i < members.length; i++) {
			members[i] = new Person();
		}
	}

	Building createProject(Order order) {
		return new Building(order.task.floorsNumber, order.task.sizeM2);
	}
	
	void build(Building b) {
		b.build();
	}
}
