package Admin;

import Handlers.*;
import java.util.*;
import java.util.Scanner;

import Users.StudentRecord;

public class StrategyMenu implements Menu {

	protected StudentRecord studentRecord;
	protected Scanner scanner;
	private Map<Integer, MenuoptionHandler> handlers = new HashMap<>();

	public StrategyMenu(StudentRecord studentRecord, Scanner scanner) {
		this.studentRecord = studentRecord;
		this.scanner = scanner;
	}

	public void displayMenu() {
		System.out.println("Menu:");
		System.out.println("1. Add Student");
		System.out.println("2. Remove Student");
		System.out.println("3. Get Student");
		System.out.println("4. UpdateStudent");
		System.out.println("5. SaveStudent");
		System.out.println("6. ViewStudent");
		System.out.println("7. SortStudent");
		System.out.println("8. Exit");
		System.out.print("Choose an option: ");
	}

	private void initializeHandlers() {
		handlers.put(1, new AddStudentHandler());
		handlers.put(2, new DeleteStudentHandler());
		handlers.put(3, new GetStudentHandler());
		handlers.put(4, new UpdateStudentHandler());
		handlers.put(5, new SaveStudentHandler());
		handlers.put(6, new ViewStudentHandler());
		handlers.put(7, new SortStudentHandler());
		// Add more handlers for other options
	}

	@Override
	public void handleOption(int option) {
		MenuoptionHandler handler = handlers.get(option);
		if (handler != null) {
			handler.handleOption(studentRecord, scanner);
		} else {
			System.out.println("Invalid option. Please try again.");
		}
	}

}
