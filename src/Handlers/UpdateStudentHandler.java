package Handlers;

import java.util.InputMismatchException;
import java.util.Scanner;

import Admin.MenuoptionHandler;
import Users.StudentRecord;

public class UpdateStudentHandler implements MenuoptionHandler {

	@Override
	public void handleOption(StudentRecord studentRecord, Scanner scanner) {
		// TODO Auto-generated method stub
		try {
			System.out.print("Enter student ID: ");
			int id = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			System.out.print("Enter student name: ");
			String name = scanner.nextLine();

			System.out.print("Enter student branch: ");
			String branch = scanner.nextLine();

			System.out.print("Enter student college: ");
			String college = scanner.nextLine();

			System.out.print("Enter student grades: ");
			String grades = scanner.nextLine();

			studentRecord.updateStudent(id, name, college, branch, grades);
			System.out.println("Student updated successfully.");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter the correct data.");
			scanner.nextLine(); // Clear the invalid input
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
