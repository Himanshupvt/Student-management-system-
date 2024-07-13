package Handlers;

import java.util.Scanner;

import Admin.MenuoptionHandler;
import Users.StudentRecord;

public class ViewStudentHandler implements MenuoptionHandler {

	@Override
	public void handleOption(StudentRecord studentRecord, Scanner scanner) {
		// TODO Auto-generated method stub
		try {
			studentRecord.ViewStudent();
		} catch (Exception e) {
			System.out.println("An unexpected error occurred while viewing student records: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
