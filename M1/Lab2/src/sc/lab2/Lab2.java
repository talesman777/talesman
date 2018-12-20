package sc.lab2;

import java.util.Scanner;

public class Lab2 {
	public static void main(String[] args) throws java.io.IOException {
//		String text = new String("Java is a general-purpose computer-programming language that is"
//				+ " concurrent, class-based, object-oriented, and specifically designed to have"
//				+ " as few implementation dependencies as possible. It is intended to let"
//				+ " application developers \"write once, run anywhere\" (WORA), meaning that"
//				+ " compiled Java code can run on all platforms that support Java without the need"
//				+ " for recompilation. Java applications are typically compiled to bytecode that"
//				+ " can run on any Java virtual machine (JVM) regardless of computer architecture."); // input literal
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String text, endSequence = "..";
		System.out.printf(("Enter text (end with \"%s\" to finish) : "), endSequence); // user input
		
		text = acceptInput(endSequence, scanner);
		
		System.out.println("Before : \n" + text);

		System.out.print("Character to delete : ");
		char ch = (char) System.in.read(); // character for deletion
		scanner.close();
		System.out.println();

		text = text.replaceAll("" + ch, "");
		System.out.println("After :\n" + text); // Display the result
	}
	
	static String acceptInput(String endSequence, Scanner scanner) {
		String result = "", temp;
		
		while (true) {
			temp = scanner.nextLine();
			
			if (!temp.equals(endSequence)) {
				if (!temp.endsWith(endSequence)) {
					result += temp + '\n';
				} else {
					result += temp.substring(0, temp.length() - 2);
					break;
				}
			}
		}
		
		return result;
	}
}
