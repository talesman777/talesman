package sc.lab3;

public class Patient {
	private int identificationNumber;
	private int medicalCardNumber;
	private String diagnosis;
	private String firstName;
	private String middleName;
	private String lastName;
	private String address;
	private String phoneNumber;

	/* Constructors */

	public Patient() {
	}

	public Patient(int ididentificationNumber, int medicalCardNumber, String firstName, String middleName,
			String lastName, String address, String phoneNumber, String diagnosis) {
		this.identificationNumber = ididentificationNumber;
		this.medicalCardNumber = medicalCardNumber;
		this.diagnosis = diagnosis;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	/* Accessor and mutator methods */

	public int getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(int number) {
		identificationNumber = number;
	}

	public int getMedicalCardNumber() {
		return medicalCardNumber;
	}

	public void setMedicalCardNumber(int number) {
		medicalCardNumber = number;
	}

	public String getDiagnosis() {
		return diagnosis.toLowerCase().trim();
	}

	public void setDiagnosis(String d) {
		diagnosis = d;
	}

	public String getFirstName() {
		return firstName.toLowerCase().trim();
	}

	public void setFirstName(String f) {
		firstName = f;
	}

	public String getMiddleName() {
		return middleName.toLowerCase().trim();
	}

	public void setMiddleName(String m) {
		middleName = m;
	}

	public String getLastName() {
		return lastName.toLowerCase().trim();
	}

	public void setLastName(String l) {
		lastName = l;
	}

	public String getAddress() {
		return address.toLowerCase().trim();
	}

	public void setAddress(String a) {
		address = a;
	}

	public String getPhoneNumber() {
		return phoneNumber.toLowerCase().trim();
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/* Transform all data to String for convenient output */

	@Override
	public String toString() {
		return String.format("%-15s%-15s%-30s%-15s%-15s%-15s%-50s%s", identificationNumber, medicalCardNumber,
				diagnosis, firstName, middleName, lastName, address, phoneNumber);
	}
}
