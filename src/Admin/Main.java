package Admin;

import java.util.*;

import Users.StudentRecord;
import Users.StudentRecordImplementation;

public class Main {

	public static void runMenu(StudentRecord studentRecord, Scanner scanner) {
		Menu menu = new StrategyMenu(studentRecord, scanner);
		boolean exit = false;

		while (!exit) {
			try {
				menu.displayMenu();
				int choice = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				if (choice == 8) {
					exit = true;
				} else {
					menu.handleOption(choice);
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine(); // Clear the invalid input
			} catch (Exception e) {
				System.out.println("An unexpected error occurred: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Student Management System");
		AdminInterface adminLogin = new AdminLoginImpl();
		StudentRecord studentRecord = StudentRecordImplementation.getInstance();

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter admin username:");
			String username = scanner.nextLine();
			System.out.println("Enter admin password:");
			String password = scanner.nextLine();

			if (adminLogin.login(username, password)) {
				System.out.println("Login successful!");
				runMenu(studentRecord, scanner);

			} else {
				System.out.println("Login failed. Exiting...");
				System.out.println();
				System.out.println("Enter 1 for Try again  ");
				System.out.println("Enter 2 for Exit  ");

				int a = scanner.nextInt();
				if (a == 1) {
					main(args);
				}
				System.out.println("Exiting .........");

			}
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
