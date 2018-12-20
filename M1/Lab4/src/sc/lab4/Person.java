package sc.lab4;

public class Person {
	private String firstName;
	private String lastName;
	private String telNumber;

	public Person() {
		firstName = null;
		lastName = null;
		telNumber = null;
	}

	public Person(String firstName, String lastName, String telNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telNumber = telNumber;
	}

	// Accessor and mutator methods

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

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
}
