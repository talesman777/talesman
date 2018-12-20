package sc.lab4;

import java.util.Scanner;

public class Tools {
	private static Scanner scanner = new Scanner(System.in);

	// Get index of the first unassigned element in orders

	public static int getFreeElement(Object[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				return i;
			}
		}

		return -1;
	}
	
	// Accept integer number as input

	public static int acceptNumber(String promptMessage) {
		int number = 0;

		do {
			System.out.print(promptMessage);
			try {
				number = Integer.parseInt(scanner.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Incorrect input, try again");
				continue;
			}
		} while (true); // Ask again if input is incorrect

		return number;
	}

}
