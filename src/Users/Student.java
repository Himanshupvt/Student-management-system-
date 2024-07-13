package Users;

import java.io.Serializable;

public class Student implements Serializable {
	private int id;
	private String name;
	private String Branch;
	private String College;
	private String grades;
	private StringBuilder Research;

	public String getGrades() {
		return grades;
	}

	public void setGrades(String grades) {
		this.grades = grades;
	}

	public Student(int id, String name, String branch, StringBuilder research, String college,String grades) {
		super();
		this.id = id;
		this.name = name;
		Branch = branch;
		Research = research;
		College = college;
		this.grades=grades;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public StringBuilder getResearch() {
		return Research;
	}

	public void setResearch(StringBuilder research) {
		Research = research;
	}

	public String getCollege() {
		return College;
	}

	public void setCollege(String college) {
		College = college;
	}

}
