package Handlers;

import java.util.Scanner;

import Admin.MenuoptionHandler;
import Users.StudentRecord;

public class SaveStudentHandler implements MenuoptionHandler {

	@Override
	public void handleOption(StudentRecord studentRecord, Scanner scanner) {
		// TODO Auto-generated method stub
		 try {
	            studentRecord.saveStudent();
	            System.out.println("Student records saved successfully.");
	        } catch (Exception e) {
	            System.out.println("An unexpected error occurred while saving student records: " + e.getMessage());
	            e.printStackTrace();
	        }
	}

}
