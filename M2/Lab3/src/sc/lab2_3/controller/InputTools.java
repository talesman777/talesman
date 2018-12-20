package sc.lab2_3.controller;

import java.util.Scanner;

import org.apache.logging.log4j.Level;
import static sc.lab2_3.controller.Lab2_3Controller.LOGGER;

class InputTools {
	static Scanner scanner = new Scanner(System.in);

	// Accept an integer from user
	static int getInteger(String promptMessage) {
		LOGGER.traceEntry("Entered getInteger");
		int number = 0;

		while (true) {
			System.out.print(promptMessage);
			try {
				LOGGER.debug("Accepting input as integer...");
				number = Integer.parseInt(scanner.nextLine());
				LOGGER.debug(String.format("Integer accepted - %d", number));
				break;
			} catch (NumberFormatException e) {
				LOGGER.catching(Level.ERROR, e);
				System.out.println(e.getMessage() + "\nInvalid input, try again.");
			}
			LOGGER.debug("Trying again...");
		}
		LOGGER.traceExit(String.format("Returning integer - \"%d\"", number));
		return number;
	}

	// Accept a non-negative integer from user
	static int getPositiveInteger(String promptMessage) {
		LOGGER.traceEntry("Entered getPositiveInteger");
		int number = 0;
		while (true) {
			try {
				LOGGER.trace("Calling getInteger for input");
				number = getInteger(promptMessage);
				if (number < 0) {
					LOGGER.debug("Input is less than 0, throwing exception");
					throw new IllegalArgumentException(String.valueOf(number));
				}
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.catching(Level.ERROR, e);
				System.out.println(e.getMessage() + " - number should be greater than 0, try again.");
			}
			LOGGER.debug("Trying again...");
		}
		LOGGER.traceExit(String.format("Returning positive integer - \"%d\"", number));
		return number;
	}

	// Accept a trimmed line
	static String getString(String promptMessage) {
		LOGGER.traceEntry("Entered getString");
		System.out.print(promptMessage);
		LOGGER.debug("Accepting input as string...");
		String string = scanner.nextLine().trim();
		LOGGER.debug(String.format("Accepted string - \"%s\"", string));
		LOGGER.traceExit(String.format("Returning string - \"%s\"", string));
		return string;
	}

	// Get a member of the specified by enumerationMember enumeration from user
	static <E extends Enum<E>> E getEnum(E enumerationMember, String promptMessage) {
		LOGGER.traceEntry("Entered getEnum");
		E result;

		while (true) {
			try {
				LOGGER.debug("Calling getEnumWithOrdinal");
				result = getEnumWithOrdinal(enumerationMember, getInteger(promptMessage));
				break;
			} catch (InvalidCommandException e) {
				LOGGER.catching(Level.ERROR, e);
				System.out.println(e.getMessage());
			}
		}
		LOGGER.traceExit(String.format("Returning enum member - \"%s\"", result));
		return result;
	}

	// Get a member of the specified by enumerationMember enumeration based on its
	// ordinal
	static <E extends Enum<E>> E getEnumWithOrdinal(E enumerationMember, int ordinal) throws InvalidCommandException {
		LOGGER.traceEntry("Entered getEnumWithOrdinal");
		E action = null;

		for (E enumMember : enumerationMember.getDeclaringClass().getEnumConstants()) {
			if (enumMember.ordinal() == ordinal) {
				action = enumMember;
				break;
			}
		}

		if (action == null) {
			LOGGER.debug(String.format("Enum member of %s with ordinal %d not found, throwing exception",
					enumerationMember.getDeclaringClass().getSimpleName(), ordinal));
			throw new InvalidCommandException(String.format("%d - is not a valid option, try again.\n", ordinal));
		}

		LOGGER.traceExit(String.format("Returning enum member - \"%s\"", action));
		return action;
	}

	// Get an instance of the Range class (used by
	// PatientTools.findByMedCardInRange)
	static Range getRange() {
		LOGGER.traceEntry("Entered getRange");
		int n1, n2;
		n1 = n2 = 0;

		while (true) {
			LOGGER.debug("Calling getString for input");
			String string = getString("Enter range (like \"from-to\") : ");
			String[] strings = string.split("-");

			try {
				n1 = Integer.valueOf(strings[0].trim());
				n2 = Integer.valueOf(strings[1].trim());
				break;
			} catch (NumberFormatException e) {
				LOGGER.catching(Level.ERROR, e);
				System.out.println(e.getMessage() + "\nEnter a valid range, try again.");
			} catch (IndexOutOfBoundsException e) {
				LOGGER.catching(Level.ERROR, e);
				System.out.println("Enter two values separated by \"-\", try again.");
			}
			LOGGER.debug("Trying again...");
		}

		LOGGER.traceExit(String.format("Returning range %d-%d", n1, n2));
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
