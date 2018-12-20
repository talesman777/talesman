package sc.lab2_1.tools;

import java.util.Scanner;

import sc.lab2_1.enums.InvalidCommandException;

public class InputTools {
	public static final Scanner scanner = new Scanner(System.in);

	// Accept an integer from user
	public static int getInteger(String promptMessage) {
		int number = 0;

		while (true) {
			System.out.print(promptMessage);
			try {
				number = Integer.parseInt(scanner.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage() + "\nInvalid input, try again.");
			}
		}

		return number;
	}

	// Accept a non-negative integer from user
	public static int getPositiveInteger(String promptMessage) {
		int number = 0;
		while (true) {
			try {
				number = getInteger(promptMessage);
				if (number < 0) {
					throw new IllegalArgumentException(String.valueOf(number));
				}
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage() + " - number should be greater than 0, try again.");
			}
		}
		return number;
	}

	// Accept a trimmed line
	public static String getString(String promptMessage) {
		System.out.print(promptMessage);
		return scanner.nextLine().trim();
	}

	// Get a member of the specified by enumerationMember enumeration from user
	public static <E extends Enum<E>> E getEnum(E enumerationMember, String promptMessage) {
		E result;

		while (true) {
			try {
				result = getEnumWithOrdinal(enumerationMember, getInteger(promptMessage));
				break;
			} catch (InvalidCommandException e) {
				System.out.println(e.getMessage());
			}
		}

		return result;
	}

	// Get a member of the specified by enumerationMember enumeration based on its
	// ordinal
	private static <E extends Enum<E>> E getEnumWithOrdinal(E enumerationMember, int ordinal)
			throws InvalidCommandException {
		E action = null;

		for (E enumMember : enumerationMember.getDeclaringClass().getEnumConstants()) {
			if (enumMember.ordinal() == ordinal) {
				action = enumMember;
				break;
			}
		}

		if (action == null) {
			throw new InvalidCommandException(String.format("%d - is not a valid option, try again.\n", ordinal));
		}

		return action;
	}

	// Get an instance of the Range class (used by
	// PatientTools.findByMedCardInRange)
	public static Range getRange() {
		int n1, n2;
		n1 = n2 = 0;

		while (true) {
			String string = getString("Enter range (like \"from-to\") : ");
			String[] strings = string.split("-");

			try {
				n1 = Integer.valueOf(strings[0].trim());
				n2 = Integer.valueOf(strings[1].trim());
				break;
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage() + "\nEnter a valid range, try again.");
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Enter two values separated by \"-\", try again.");
			}
		}

		return new Range(n1, n2);
	}

	// Wrap two integers in a class to represent range
	static class Range {
		public final int from;
		public final int to;

		Range(int from, int to) {
			if (from < to) {
				this.from = from;
				this.to = to;
			} else {
				this.from = to;
				this.to = from;
			}
		}
	}
}
