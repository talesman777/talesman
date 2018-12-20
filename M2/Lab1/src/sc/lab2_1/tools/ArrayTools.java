package sc.lab2_1.tools;

import java.util.Arrays;
import sc.lab2_1.Patient;

public class ArrayTools {
	/*
	 * Assign patient to element at index, expand and return the expanded array if
	 * index exceeds boundaries
	 */
	public static Patient[] addElement(Patient[] array, int index, Patient patient) {
		Patient[] result = array;

		if (index >= result.length) {
			result = Arrays.copyOf(array, (int) (array.length * 1.5));
		}

		result[index] = patient;

		return result;
	}

	// Check if array is null or contains no initialised elements
	public static boolean empty(Patient[] arr) {
		if (arr == null || arr.length == 0) {
			return true;
		}

		for (Patient patient : arr) {
			if (patient != null) {
				return false;
			}
		}

		return true;
	}

}
