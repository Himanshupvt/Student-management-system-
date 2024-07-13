package Handlers;

import java.util.InputMismatchException;
import java.util.Scanner;

import Users.Student;
import Users.StudentRecord;

public class AddStudentHandler implements Admin.MenuoptionHandler {

	@Override
	public void handleOption(StudentRecord studentRecord, Scanner scanner) {
		// TODO Auto-generated method stub
		try {
			Student student = readStudentDetails(scanner);
			studentRecord.addStudent(student);
			System.out.println("Student added successfully: " + student);
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter the correct data.");
			scanner.nextLine(); // Clear the invalid input
		} catch (Exception e) {
			System.out.println("An unexpected error occurred: " + e.getMessage());
			e.printStackTrace();
		}

	}
	 private Student readStudentDetails(Scanner scanner) {
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

	        System.out.print("Enter student research: ");
	        StringBuilder research = new StringBuilder();
	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            if (line.isEmpty()) {
	                break; // Stop reading when an empty line is encountered
	            }
	            research.append(line).append("\n");
	        }

	        return new Student(id, name, branch, research, college, grades);
	    }
}
