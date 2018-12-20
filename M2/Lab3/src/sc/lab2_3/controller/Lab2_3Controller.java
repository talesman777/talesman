package sc.lab2_3.controller;

import sc.lab2_3.model.Lab2_3Model;
import sc.lab2_3.model.Patient;
import sc.lab2_3.view.Lab2_3View;
import sc.lab2_3.enums.*;
import static sc.lab2_3.controller.InputTools.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lab2_3Controller {
	static final Logger LOGGER = LogManager.getLogger("Controller");
	
	Lab2_3Model model;
	Lab2_3View view;

	boolean run = true;

	// Constructors
	public Lab2_3Controller() {
		LOGGER.traceEntry("Entered Lab2_3Controller constructor");
		boolean generatePatiens;
		if (getString("Would you like to fill the patient table with random data? [y/n] : ").trim().toLowerCase()
				.equals("y")) {
			LOGGER.debug("User selected \"y\", setting generatePatients to true");
			generatePatiens = true;
		} else {
			LOGGER.debug("User selected \"n\" or else, setting generatePatients to false");
			generatePatiens = false;
		}
		
		model = new Lab2_3Model(generatePatiens);
		view = new Lab2_3View();
		LOGGER.traceExit("Leaving Lab2_3Controller constructor");
	}

	public Lab2_3Controller(Lab2_3Model model, Lab2_3View view) {
		LOGGER.traceEntry("Entered parameterized Lab2_3Controller constructor");
		this.model = model;
		this.view = view;
		LOGGER.traceExit("Leaving parameterized Lab2_3Controller constructor");
	}

	public void run() {
		LOGGER.traceEntry("Entered run");
		while (run) {
			view.displayMainMenu();
			mainMenuExecute(getEnum(MainMenuActions.EXIT, "Your choice : "));
		}
		LOGGER.traceExit("Leaving run");
	}

	// Execute an action from the main menu
	private void mainMenuExecute(MainMenuActions action) {
		LOGGER.traceEntry("Entered mainMenuExecute");
		switch (action) {
		case DISPLAY:
			view.displayPatients(model.getPatients());
			break;
		case ADD:
			view.displayPatientAdditionMenu();
			patientAdditionMenuExecute(getEnum(AdditionMenuActions.GOBACK, "Your choice : "));
			break;
		case FIND:
			view.displaySearchMenu();
			patientSearchMenuExecute(getEnum(SearchMenuActions.GOBACK, "Your choice : "));
			break;
		case EXIT:
			scanner.close();
			run = false;
		}
		LOGGER.traceExit("Leaving mainMenuExecute");
	}

	// Execute an action from the patient addition menu
	private void patientAdditionMenuExecute(AdditionMenuActions action) {
		LOGGER.traceEntry("Entered patientAdditionMenuExecute");
		switch (action) {
		case ADDRANDOM:
			model.addRandomPatient();
			break;
		case ADDSPECIFIC:
			model.addPatient(askForPatient());
			break;
		case GOBACK:
		}
		LOGGER.traceExit("Leaving patientAdditionMenuExecute");
	}

	// Execute an action from the patient search menu
	private void patientSearchMenuExecute(SearchMenuActions action) {
		LOGGER.traceEntry("Entered patientSearchMenuExecute");
		switch (action) {
		case DIAGNOSIS:
			view.displayPatients(model.findByDiagnosis(getString("Diagnosis : ")));
			break;
		case MEDCARDN:
			Range range = getRange();
			view.displayPatients(model.findByMedCardInRange(range.from, range.to));
			break;
		case GOBACK:
		}
		LOGGER.traceExit("Leaving patientSearchMenuExecute");
	}

	private Patient askForPatient() {
		LOGGER.traceEntry("Entered askForPatient");
		System.out.println("Enter data (enter 0 for random)");

		int mediCardN = getPositiveInteger("Medical card number : ");
		String firstName = getString("First Name : ");
		String lastName = getString("Last Name : ");
		String address = getString("Address : ");
		String phoneNumber = getString("Phone number : ");
		String diagnosis = getString("Diagnosis : ");

		LOGGER.traceExit("Leaving askForPatient");
		return new Patient(model.patientGenerator.generateIdentificationNumber(),
				mediCardN == 0 ? model.patientGenerator.generateMedicalCardNumber() : mediCardN,
				firstName.equals(String.valueOf(0)) ? model.patientGenerator.generateFirstName() : firstName,
				lastName.equals(String.valueOf(0)) ? model.patientGenerator.generateLastName() : lastName,
				address.equals(String.valueOf(0)) ? model.patientGenerator.generateAddress() : address,
				phoneNumber.equals(String.valueOf(0)) ? model.patientGenerator.generatePhoneNumber() : phoneNumber,
				diagnosis.equals(String.valueOf(0)) ? model.patientGenerator.generateDiagnosis() : diagnosis);
	}
}
