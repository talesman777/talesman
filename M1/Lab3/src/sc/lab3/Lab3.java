package sc.lab3;

import java.util.Scanner;

public class Lab3 {
	static final int SIZE = 10; // Initial size of arrays for storing patients
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Patient[] patients = new Patient[SIZE];
		int i = 0, choice;

		// Main program loop
		while (true) {
			displayMenu();
			choice = acceptNumber("Your choice : ", 0, 3);

			switch (choice) {
			case 1: // Display patients
				displayPatients(patients);
				break;
			case 2: // Add patients
				displayPatientAdditionMenu();
				choice = acceptNumber("Your choice : ", 0, 2);
				switch (choice) {
				case 0: // Iterate anew if 'Go back' was selected
					continue;
				case 1:
					patients = Tools.addElement(patients, i++, PatientGenerator.generatePatient());
					break;
				case 2:
					patients = Tools.addElement(patients, i++, askForPatient());
					break;
				default:
					break;
				}
				break;
			case 3: // Search patients
				displaySearchMenu();

				choice = acceptNumber("Your choice : ", 0, 2);

				if (choice == 0) { // Iterate anew if 'Go back' was selected
					continue;
				} else if (choice == 1) {
					System.out.print("Diagnosis : ");
				} else if (choice == 2) {
					System.out.print("Range (enter as \"StartN-EndN\") : ");
				}

				String query = scanner.nextLine().trim().toLowerCase();
				try {
					displayPatients(Tools.findPatients(patients, choice, query));
				} catch (NumberFormatException e) { // handle if Integer.parseInt in findPatients throws an exception
					System.out.println("Number conversion error");
				}
				break;
			case 0:
				scanner.close();
				System.exit(0);
			default:
				break;
			}
		}
	}

	private static Patient askForPatient() {
		System.out.println("Enter data (enter 0 for random)");

		System.out.print("First Name : ");
		String firstName = scanner.nextLine();
		if (firstName.trim().equals("0")) {
			firstName = PatientGenerator.generateFirstName();
		}

		System.out.print("Middle Name : ");
		String middleName = scanner.nextLine();
		if (middleName.trim().equals("0")) {
			middleName = "-";
		}

		System.out.print("Last Name : ");
		String lastName = scanner.nextLine();
		if (lastName.trim().equals("0")) {
			lastName = PatientGenerator.generateLastName();
		}

		int mediCardN;
		do {
			System.out.print("Medical Card Number : ");

			try {
				mediCardN = Integer.parseInt(scanner.nextLine());
				if (mediCardN >= 0) {
					break;
				} else {
					System.out.println("Number should be greater tha 0!");
				}
			} catch (NumberFormatException e) { // handling incorrect input
				System.out.println("Number conversion error");
			}
		} while (true);

		if (mediCardN == 0) {
			mediCardN = PatientGenerator.generateMedicalCardNumber();
		}

		System.out.print("Diagnosis : ");
		String diagnosis = scanner.nextLine();
		if (diagnosis.trim().equals("0")) {
			diagnosis = PatientGenerator.generateDiagnosis();
		}

		System.out.print("Address : ");
		String address = scanner.nextLine();
		if (address.trim().equals("0")) {
			address = PatientGenerator.generateAddress();
		}

		System.out.print("Phone number : ");
		String phoneNumber = scanner.nextLine();
		if (phoneNumber.trim().equals("0")) {
			phoneNumber = PatientGenerator.generatePhoneNumber();
		}

		return new Patient(PatientGenerator.generateIdentificationNumber(), mediCardN, firstName, middleName, lastName,
				address, phoneNumber, diagnosis);
	}

	private static int acceptNumber(String promptMessage, int lowerBound, int upperBound) { // Accept input while in
																							// menu
		int number = -1;

		do {
			System.out.print(promptMessage);
			try {
				number = Integer.parseInt(scanner.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Incorrect input, try again");
				continue;
			}
		} while (number > upperBound || number < lowerBound); // Ask again if input is incorrect

		System.out.println();
		return number;
	}

	private static void displayPatients(Patient[] array) { // Display table of patients
		if (Tools.empty(array)) {
			System.out.println("No patients to display\n");
			return;
		}

		System.out.println(String.format("%-15s%-15s%-30s%-15s%-15s%-15s%-50s%s", "PatientID", "MCardN", "Diagnosis",
				"FirstN", "MiddleN", "LastN", "Address", "PhoneN")); // Table frame

		for (Patient patient : array) {
			if (patient != null) {
				System.out.println(patient);
			}
		}
		System.out.println();
	}

	private static void displayMenu() { // Display available actions
		System.out.println("1. Display patients");
		System.out.println("2. Add patient");
		System.out.println("3. Find patients");
		System.out.println("0. Exit");
	}

	private static void displaySearchMenu() {
		System.out.println("Search by :");
		System.out.println("1. Diagnosis");
		System.out.println("2. Medical card number in range");
		System.out.println("0. Go back");
	}

	private static void displayPatientAdditionMenu() {
		System.out.println("Add patient :");
		System.out.println("1. Generate random");
		System.out.println("2. Enter manually");
		System.out.println("0. Go back");
	}
}
