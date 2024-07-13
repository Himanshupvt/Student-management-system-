package Handlers;

import java.util.InputMismatchException;
import java.util.Scanner;

import Admin.MenuoptionHandler;
import Users.StudentRecord;

public class DeleteStudentHandler implements MenuoptionHandler {

	@Override
	public void handleOption(StudentRecord studentRecord, Scanner scanner) {
		// TODO Auto-generated method stub
		 try {
	            System.out.print("Enter student ID to remove: ");
	            int studentId = scanner.nextInt();
	            studentRecord.removeStudent(studentId);
	            scanner.nextLine(); // Consume newline
	            System.out.println("Student removed successfully.");
	        } catch (InputMismatchException e) {
	            System.out.println("Invalid input. Please enter a valid student ID.");
	            scanner.nextLine(); // Clear the invalid input
	        } catch (Exception e) {
	            System.out.println("An unexpected error occurred: " + e.getMessage());
	            e.printStackTrace();
	        }
	}

}
