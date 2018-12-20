package sc.lab2_3.controller;

public class InvalidCommandException extends IllegalArgumentException {

	public InvalidCommandException() {
	}

	public InvalidCommandException(String arg0) {
		super(arg0);
	}

	public InvalidCommandException(Throwable arg0) {
		super(arg0);
	}

	public InvalidCommandException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
