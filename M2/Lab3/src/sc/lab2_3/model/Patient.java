package sc.lab2_3.model;

public class Patient {
	private int identificationNumber;
	private int medicalCardNumber;
	private String diagnosis;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;

	/* Constructors */

	public Patient() {
	}

	public Patient(int identificationNumber, int medicalCardNumber, String firstName, String lastName, String address,
			String phoneNumber, String diagnosis) {
		this.identificationNumber = identificationNumber;
		this.medicalCardNumber = medicalCardNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.diagnosis = diagnosis;
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
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/* Transform all data to String for convenient output */

	@Override
	public String toString() {
		return String.format("%-15s%-15s%-31s%-15s%-15s%-50s%s", identificationNumber, medicalCardNumber, diagnosis,
				firstName, lastName, address, phoneNumber);
	}
}
