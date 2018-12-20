package sc.lab2_2.tools;

import java.io.File;
import java.util.Scanner;

public class InputTools {
	public static final Scanner scanner = new Scanner(System.in);
	public static final String sTrue = "y";
	public static final String sFalse = "n";

	public static boolean getBoolean(String promptMessage, String sTrue, String sFalse) {
		String string;
		while (true) {
			string = getString(promptMessage);

			if (string.equals(sTrue)) {
				return true;
			} else if (string.equals(sFalse)) {
				return false;
			}
		}
	}

	// Accept a trimmed line
	public static String getString(String promptMessage) {
		System.out.print(promptMessage);
		return scanner.nextLine().trim();
	}

	public static File getFile(String promptMessage, boolean mustExist) {
		File file = null;

		while (true) {
			try {
				file = new File(getString(promptMessage));

				if (file.exists() || !mustExist) {
					break;
				}
				System.out.println("File must exist, try again.");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return file;
	}
}
