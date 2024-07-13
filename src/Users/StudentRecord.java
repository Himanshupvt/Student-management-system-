package Users;

import java.util.*;

public interface StudentRecord {
	void addStudent(Student student);

	void removeStudent(int studentId);

	void updateStudent(int studentId, String name, String College, String Branch, String grades);

	void saveStudent();

	List<Student> sortStudent(String filter);

	void ViewStudent();

	Student getStudent(int studentId);
}
