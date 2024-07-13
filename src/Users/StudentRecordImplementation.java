package Users;

import java.io.*;
import java.util.*;

public class StudentRecordImplementation implements StudentRecord {

	private static final String FILE_NAME = "/home/himanshu/SirionTraining/Student.txt";
	private Map<Integer, Student> studentMap = new HashMap<>();
	private static StudentRecordImplementation instance;

	private  StudentRecordImplementation() {
		super();
		this.studentMap = new HashMap<>();
		loadStudents();

	}

	public static StudentRecordImplementation getInstance() {
		if (instance == null) {
			instance = new StudentRecordImplementation();

		}
		return instance;
	}

	@Override
	public void addStudent(Student student) {
		studentMap.put(student.getId(), student);
	}

	@Override
	public void removeStudent(int studentId) {
		if (studentMap.containsKey(studentId)) {
			studentMap.remove(studentId);
			System.out.println("Student with ID " + studentId + " removed successfully.");
		} else {
			System.out.println("Student with ID " + studentId + " not found.");
		}
	}

	@Override
	public void updateStudent(int studentId, String name, String College, String branch, String grades) {
		Student student = studentMap.get(studentId);
		if (student != null) {
			student.setName(name);
			student.setGrades(grades);
			System.out.println("Student with ID " + studentId + " updated successfully.");
		} else {
			System.out.println("Student with ID " + studentId + " not found.");
		}
	}

	@Override
	public Student getStudent(int studentId) {
		if (studentMap.containsKey(studentId)) {
			Student student = studentMap.get(studentId);
			System.out.println("Student with ID " + studentId + " fetched successfully.");

			System.out.println();
			System.out.println();
			System.out.print("Name of student is ");
			System.out.println(student.getName());
			System.out.print("Branch of student is ");
			System.out.println(student.getBranch());
			System.out.print("Grades of student is ");
			System.out.println(student.getGrades());
			System.out.print("College of student is ");
			System.out.println(student.getCollege());
			System.out.print("Id of student is ");
			System.out.println(student.getId());
			System.out.println();
			System.out.println();

			return student;
		} else {
			System.out.println("Student with ID " + studentId + " not found.");
			return null;
		}
	}

	@Override
	public void saveStudent() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
			oos.writeObject(new ArrayList<>(studentMap.values()));
			System.out.println("Student records saved successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while saving student records: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void loadStudents() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
			List<Student> students = (List<Student>) ois.readObject();
			for (Student student : students) {
				studentMap.put(student.getId(), student);
			}
			System.out.println("Student records loaded successfully.");
		} catch (FileNotFoundException e) {
			System.out.println("Student records file not found, starting with an empty record.");
		} catch (IOException e) {
			System.out.println("An error occurred while loading student records: " + e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found while loading student records: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> sortStudent(String filter) {
		List<Student> students = new ArrayList<>(studentMap.values());
		Comparator<Student> comparator;

		switch (filter.toLowerCase()) {
		case "name":
			comparator = Comparator.comparing(student -> student.getName(), Comparator.nullsLast(String::compareTo));
			break;
		case "id":
			comparator = Comparator.comparingInt(Student::getId);
			break;
		case "grades":
			comparator = Comparator.comparing(student -> student.getGrades());
			break;
		default:
			throw new IllegalArgumentException("Invalid filter: " + filter);
		}

		students.sort(comparator);
		for (Student student : students) {

			System.out.println();
			System.out.println();
			System.out.print("Name of student is ");
			System.out.println(student.getName());
			System.out.print("Branch of student is ");
			System.out.println(student.getBranch());
			System.out.print("Grades of student is ");
			System.out.println(student.getGrades());
			System.out.print("College of student is ");
			System.out.println(student.getCollege());
			System.out.print("Id of student is ");
			System.out.println(student.getId());
			System.out.println();
			System.out.println();
		}
		return students;
	}

	@Override
	public void ViewStudent() {
		if (studentMap.isEmpty()) {
			System.out.println("No student records available.");
		} else {
			for (Student student : studentMap.values()) {
				System.out.println();
				System.out.println();
				System.out.print("Name of student is ");
				System.out.println(student.getName());
				System.out.print("Branch of student is ");
				System.out.println(student.getBranch());
				System.out.print("Grades of student is ");
				System.out.println(student.getGrades());
				System.out.print("College of student is ");
				System.out.println(student.getCollege());
				System.out.print("Id of student is ");
				System.out.println(student.getId());
				System.out.println();
				System.out.println();
			}
		}
	}

}
