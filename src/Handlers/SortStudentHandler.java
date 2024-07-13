package Handlers;

import java.util.InputMismatchException;
import java.util.Scanner;

import Admin.MenuoptionHandler;
import Users.StudentRecord;

public class SortStudentHandler implements MenuoptionHandler {

	@Override
	public void handleOption(StudentRecord studentRecord, Scanner scanner) {
		// TODO Auto-generated method stub
		try {
			System.out.print("Enter your sorting criteria: ");
			System.out.println("1. Name");
			System.out.println("2. ID");
			System.out.println("3. Grades");

			int criteria = scanner.nextInt();

			switch (criteria) {
			case 1:
				studentRecord.sortStudent("name");
				break;
			case 2:
				studentRecord.sortStudent("id");
				break;
			case 3:
				studentRecord.sortStudent("grades");
				break;
			default:
				System.out.println("Invalid choice.");
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
