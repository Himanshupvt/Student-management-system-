package Handlers;

import java.util.InputMismatchException;
import java.util.Scanner;

import Admin.MenuoptionHandler;
import Users.Student;
import Users.StudentRecord;

public class GetStudentHandler implements MenuoptionHandler {

	@Override
	public void handleOption(StudentRecord studentRecord, Scanner scanner) {
		// TODO Auto-generated method stub
		try {
            System.out.print("Enter student ID to get: ");
            int studentId = scanner.nextInt();
            Student student = studentRecord.getStudent(studentId);
            if (student != null) {
                System.out.println("Student: " + student);
            } else {
                System.out.println("Student not found.");
            }
            scanner.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid student ID.");
            scanner.nextLine(); // Clear the invalid input
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
	}

}
