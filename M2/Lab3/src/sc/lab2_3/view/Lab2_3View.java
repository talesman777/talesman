package sc.lab2_3.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sc.lab2_3.enums.AdditionMenuActions;
import sc.lab2_3.enums.MainMenuActions;
import sc.lab2_3.enums.SearchMenuActions;
import sc.lab2_3.model.Patient;

public class Lab2_3View {
	static final Logger LOGGER = LogManager.getLogger("View");
	
	public void displaySearchMenu() {
		LOGGER.traceEntry("Entered displaySearchMenu");
		LOGGER.debug("Displaying search menu");
		System.out.println("Search by :");
		System.out.printf("%d. Diagnosis\n", SearchMenuActions.DIAGNOSIS.ordinal());
		System.out.printf("%d. Medical card number in range\n", SearchMenuActions.MEDCARDN.ordinal());
		System.out.printf("%d. Go back\n", SearchMenuActions.GOBACK.ordinal());
		LOGGER.traceExit("Leaving displaySearchMenu");
	}

	public void displayMainMenu() {
		LOGGER.traceEntry("Entered displayMainMenu");
		LOGGER.debug("Displaying main menu");
		System.out.printf("%d. Display patients\n", MainMenuActions.DISPLAY.ordinal());
		System.out.printf("%d. Add patient\n", MainMenuActions.ADD.ordinal());
		System.out.printf("%d. Find patients\n", MainMenuActions.FIND.ordinal());
		System.out.printf("%d. Exit\n", MainMenuActions.EXIT.ordinal());
		LOGGER.traceExit("Leaving displayMainMenu");
	}

	public void displayPatientAdditionMenu() {
		LOGGER.traceEntry("Entered displayPatientAdditionMenu");
		LOGGER.debug("Displaying patient addition menu");
		System.out.println("Add patient :");
		System.out.printf("%d. Generate random\n", AdditionMenuActions.ADDRANDOM.ordinal());
		System.out.printf("%d. Enter manually\n", AdditionMenuActions.ADDSPECIFIC.ordinal());
		System.out.printf("%d. Go back\n", AdditionMenuActions.GOBACK.ordinal());
		LOGGER.traceExit("Leaving displayPatientAdditionMenu");
	}

	// Display table of patients
	public void displayPatients(Patient[] patients) {
		LOGGER.traceEntry("Entered displayPatients");
		System.out.println();
		if (isEmpty(patients)) {
			System.out.println("No patients to display\n");
			LOGGER.info("No patients to display");
			return;
		}

		System.out.println(String.format("%-15s%-15s%-31s%-15s%-15s%-50s%s", "PatientID", "MCardN", "Diagnosis",
				"FirstN", "LastN", "Address", "PhoneN")); // Table frame

		for (Patient patient : patients) {
			if (patient != null) {
				System.out.println(patient);
				LOGGER.debug("Displayed patient with ID " + patient.getIdentificationNumber());
			}
		}
		System.out.println();
		LOGGER.traceExit("Leaving displayPatients");
	}

	// Check if array is null or contains no initialised elements
	private boolean isEmpty(Patient[] arr) {
		if (arr == null || arr.length == 0) {
			return true;
		}

		for (Patient patient : arr) {
			if (patient != null) {
				return false;
			}
		}

		return true;
	}
}
