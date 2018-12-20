package sc.lab2_1.tools;

import sc.lab2_1.Patient;
import sc.lab2_1.PatientGenerator;

public class PatientTools {

	public static Patient askForPatient() {
		System.out.println("Enter data (enter 0 for random)");

		int mediCardN = InputTools.getPositiveInteger("Medical card number : ");
		String firstName = InputTools.getString("First Name : ");
		String lastName = InputTools.getString("Last Name : ");
		String address = InputTools.getString("Address : ");
		String phoneNumber = InputTools.getString("Phone number : ");
		String diagnosis = InputTools.getString("Diagnosis : ");

		return new Patient(PatientGenerator.generateIdentificationNumber(),
				mediCardN == 0 ? PatientGenerator.generateMedicalCardNumber() : mediCardN,
				firstName.equals(String.valueOf(0)) ? PatientGenerator.generateFirstName() : firstName,
				lastName.equals(String.valueOf(0)) ? PatientGenerator.generateLastName() : lastName,
				address.equals(String.valueOf(0)) ? PatientGenerator.generateAddress() : address,
				phoneNumber.equals(String.valueOf(0)) ? PatientGenerator.generatePhoneNumber() : phoneNumber,
				diagnosis.equals(String.valueOf(0)) ? PatientGenerator.generateDiagnosis() : diagnosis);
	}

	// Display table of patients
	public static void displayPatients(Patient[] patients) {
		System.out.println();
		if (ArrayTools.empty(patients)) {
			System.out.println("No patients to display\n");
			return;
		}

		System.out.println(String.format("%-15s%-15s%-31s%-15s%-15s%-50s%s", "PatientID", "MCardN", "Diagnosis",
				"FirstN", "LastN", "Address", "PhoneN")); // Table frame

		for (Patient patient : patients) {
			if (patient != null) {
				System.out.println(patient);
			}
		}
		System.out.println();
	}

	// Get patients with specified diagnosis
	public static Patient[] findByDiagnosis(Patient[] patients, String diagnosis) {
		Patient[] result = new Patient[patients.length];

		for (int i = 0, j = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				continue;
			} else if (diagnosis.equals(patients[i].getDiagnosis().trim())) {
				result = ArrayTools.addElement(result, j++, patients[i]);
			}
		}

		return result;
	}

	// Get patients whose medical card number is within the specified boundaries
	public static Patient[] findByMedCardInRange(Patient[] patients, InputTools.Range range) {
		Patient[] result = new Patient[patients.length];

		for (int i = 0, j = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				continue;
			} else if (patients[i].getMedicalCardNumber() >= range.from
					&& patients[i].getMedicalCardNumber() <= range.to) {
				result = ArrayTools.addElement(result, j++, patients[i]);
			}
		}

		return result;
	}

}
