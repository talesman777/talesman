package sc.lab1;

import java.util.Random;

public class Lab1 {
	public static void main(String[] args) {
		int size = 0;
		java.util.Scanner scanner = new java.util.Scanner(System.in);

		do {
			System.out.print("Enter size : ");
			try {
				size = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				size = 0;
			}

			if (size < 1) {
				System.out.println("Incorrect size.");
			}
		} while (size < 1);

		scanner.close();

		double[][] arr = new double[size][size];

		Random random = new Random();

		for (int i = 0; i < size; i++) // Fill matrix with values
			for (int j = 0; j < size; j++)
				arr[i][j] = random.nextDouble() - 0.5;

		boolean inside = false; // if true - calculate every elements until a negative element is reached
		double sum = 0;

		exit: {
			for (int i = 0; i < size; i++)
				for (int j = 0; j < size; j++) {
					if (arr[i][j] < 0 && !inside) { // Find first negative element
						inside = true;
						continue;
					} else if (arr[i][j] < 0) {
						break exit;
					}

					if (inside) {
						sum += arr[i][j]; // Calculate sum of elements between first and second negative numbers
					}
				}
		}

		System.out.println("Mykola Demianko\n");

		for (int i = 0; i < size; i++) // Display the matrix
			for (int j = 0; j < size; j++) {
				System.out.format("%+f ", arr[i][j]);
				if (j == size - 1) {
					System.out.println();
				}
			}

		System.out.format("\nSum : %f", sum);
	}
}
