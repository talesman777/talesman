package sc.lab2_1;

import sc.lab2_1.tools.*;
import sc.lab2_1.enums.*;

public class Lab2_1 {
	static final int SIZE = 10; // Initial size of the array for storing patients
	private static Patient[] patients = new Patient[SIZE];
	private static int i;

	public static void main(String[] args) {
		// Main program loop
		while (true) {
			displayMainMenu();
			execute(InputTools.getEnum(MainMenuActions.EXIT, "Your choice : "));
		}
	}

	// Execute an action from the main menu
	private static void execute(MainMenuActions action) {
		switch (action) {
		case DISPLAY:
			PatientTools.displayPatients(patients);
			break;
		case ADD:
			displayPatientAdditionMenu();
			addPatientExecute(InputTools.getEnum(AdditionMenuActions.GOBACK, "Your choice : "));
			break;
		case FIND:
			displaySearchMenu();
			findPatientsExecute(InputTools.getEnum(SearchMenuActions.GOBACK, "Your choice : "));
			break;
		case EXIT:
			InputTools.scanner.close();
			System.exit(0);
		}
	}

	private static void displayMainMenu() {
		System.out.printf("%d. Display patients\n", MainMenuActions.DISPLAY.ordinal());
		System.out.printf("%d. Add patient\n", MainMenuActions.ADD.ordinal());
		System.out.printf("%d. Find patients\n", MainMenuActions.FIND.ordinal());
		System.out.printf("%d. Exit\n", MainMenuActions.EXIT.ordinal());
	}

	private static void displayPatientAdditionMenu() {
		System.out.println("Add patient :");
		System.out.printf("%d. Generate random\n", AdditionMenuActions.ADDRANDOM.ordinal());
		System.out.printf("%d. Enter manually\n", AdditionMenuActions.ADDSPECIFIC.ordinal());
		System.out.printf("%d. Go back\n", AdditionMenuActions.GOBACK.ordinal());
	}

	// Execute an action from the patient addition menu
	private static void addPatientExecute(AdditionMenuActions action) {
		Patient patient = null;

		switch (action) {
		case ADDRANDOM:
			patient = PatientGenerator.generatePatient();
			break;
		case ADDSPECIFIC:
			patient = PatientTools.askForPatient();
			break;
		case GOBACK:
			return;
		}
		patients = ArrayTools.addElement(patients, i++, patient);
	}

	private static void displaySearchMenu() {
		System.out.println("Search by :");
		System.out.printf("%d. Diagnosis\n", SearchMenuActions.DIAGNOSIS.ordinal());
		System.out.printf("%d. Medical card number in range\n", SearchMenuActions.MEDCARDN.ordinal());
		System.out.printf("%d. Go back\n", SearchMenuActions.GOBACK.ordinal());
	}

	// Execute an action from the patient search menu
	private static void findPatientsExecute(SearchMenuActions action) {
		switch (action) {
		case DIAGNOSIS:
			PatientTools.displayPatients(PatientTools.findByDiagnosis(patients, InputTools.getString("Diagnosis : ")));
			break;
		case MEDCARDN:
			PatientTools.displayPatients(PatientTools.findByMedCardInRange(patients, InputTools.getRange()));
			break;
		case GOBACK:
		}
	}
}
