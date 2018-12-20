package sc.lab2_3.model;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lab2_3Model {
	static final Logger LOGGER = LogManager.getLogger("Model");
	public static final int ARRAYSIZE = 10; // Initial array size

	public final PatientGenerator patientGenerator = new PatientGenerator();
	private Patient[] patients;
	private int arrayPosition = 0;

	// Constructors
	public Lab2_3Model() {
		this(ARRAYSIZE, false);
	}

	public Lab2_3Model(boolean generatePatients) {
		this(ARRAYSIZE, generatePatients);
	}

	public Lab2_3Model(int initArraySize) {
		this(initArraySize, false);
	}

	public Lab2_3Model(int initArraySize, boolean generatePatients) {
		LOGGER.traceEntry("Entered Lab2_3Model constructor");

		patients = new Patient[initArraySize];

		if (generatePatients) { // Fully fill array with random patients if true
			for (; arrayPosition < patients.length; arrayPosition++) {
				patients[arrayPosition] = patientGenerator.generatePatient();
			}
		}
		LOGGER.info(String.format("Generated %d patients", ARRAYSIZE));
		LOGGER.traceEntry("Leaving Lab2_3Model constructor");
	}

	// Add randomly generated patient to patients
	public void addRandomPatient() {
		LOGGER.traceEntry("Entered addRandomPatient");
		addPatient(patientGenerator.generatePatient());
		LOGGER.info("Added random patient");
		LOGGER.traceExit("Leaving addRandomPatient");
	}

	// Add patient to patients
	public void addPatient(Patient patient) {
		LOGGER.traceEntry("Entered addPatient");
		patients = addElement(patients, patient, arrayPosition++);
		LOGGER.info("Added specific patient");
		LOGGER.traceExit("Leaving addPatient");
	}

	/*
	 * Assign patient to element at index, expand the array if index exceeds
	 * boundaries
	 */
	private Patient[] addElement(Patient[] array, Patient element, int index) {
		if (index >= array.length) {
			array = Arrays.copyOf(array, array.length * 2);
		}
		array[index] = element;

		return array;
	}

	// Get all patients in the array
	public Patient[] getPatients() {
		return patients;
	}

	public Patient getPatient(int index) {
		return patients[index];
	}

	// Get patients with specified diagnosis
	public Patient[] findByDiagnosis(String diagnosis) {
		Patient[] result = new Patient[ARRAYSIZE];

		for (int i = 0, j = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				continue;
			} else if (diagnosis.equals(patients[i].getDiagnosis())) {
				result = addElement(result, patients[i], j++);
			}
		}

		return result;
	}

	// Get patients whose medical card number is within the specified boundaries
	public Patient[] findByMedCardInRange(int start, int finish) {
		Patient[] result = new Patient[ARRAYSIZE];

		for (int i = 0, j = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				continue;
			} else if (patients[i].getMedicalCardNumber() >= start && patients[i].getMedicalCardNumber() <= finish) {
				result = addElement(result, patients[i], j++);
			}
		}
		return result;
	}
}
