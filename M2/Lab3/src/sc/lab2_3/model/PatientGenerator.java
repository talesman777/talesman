package sc.lab2_3.model;

import java.util.Random;

public class PatientGenerator {
	private Random random = new Random();

	private static String[] diagnosisPool = { "Bacterial meningitis", "Blastocystis hominis infection",
			"Reiter's syndrome", "Myoclonus", "Lupus erythematosus", "Anemia", "Black piedra",
			"Demyelinating neuropathies", "Cold agglutinin disease", "Typhoid fever" };
	private static String[] firstNamePool = { "Barrett", "Jayden", "Gustavo", "Cortez", "Jakob", "Nicole", "Alivia",
			"Reagan", "Abbie", "Siena" };
	private static String[] lastNamePool = { "Peck", "Flynn", "Ramirez", "Hatfield", "Bowers", "Sanford", "Mccormick",
			"Forbes", "Moses", "Fisher" };
	private static String[] addressPool = { "11 Inverness Ave. Westwood, NJ 07675",
			"7053 Glenwood Ave. North Wales, PA 19454", "7581 Newport Court Dearborn Heights, MI 48127",
			"8201 Homestead Street De Pere, WI 54115", "720 E. Nichols St. Palm Beach Gardens, FL 33410",
			"807 North Gartner Street Glastonbury, CT 06033", "79 Bridge Road lymouth, MA 02360",
			"41 Lexington St. Lady Lake, FL 32159", "9364 Goldfield Dr. Downingtown, PA 19335",
			"746 Green Drive Rahway, NJ 07065" };

	public Patient generatePatient() {
		return new Patient(generateIdentificationNumber(), generateMedicalCardNumber(), generateFirstName(),
				generateLastName(), generateAddress(), generatePhoneNumber(), generateDiagnosis());
	}

	public int generateIdentificationNumber() {
		return random.nextInt(Integer.MAX_VALUE);
	}

	public int generateMedicalCardNumber() {
		return random.nextInt(Integer.MAX_VALUE);
	}

	public String generateDiagnosis() {
		return diagnosisPool[random.nextInt(diagnosisPool.length)];
	}

	public String generateFirstName() {
		return firstNamePool[random.nextInt(firstNamePool.length)];
	}

	public String generateLastName() {
		return lastNamePool[random.nextInt(lastNamePool.length)];
	}

	public String generateAddress() {
		return addressPool[random.nextInt(addressPool.length)];
	}

	public String generatePhoneNumber() {
		return String.format("%010d", random.nextInt(Integer.MAX_VALUE));
	}
}
