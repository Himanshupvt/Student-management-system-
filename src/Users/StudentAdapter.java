package Users;

public class StudentAdapter implements StudentInfo {
    private Student student;

    public StudentAdapter(Student student) {
        this.student = student;
    }

    @Override
    public int getId() {
        return student.getId();
    }

    @Override
    public String getName() {
        return student.getName();
    }

    @Override
    public String getBranch() {
        return student.getBranch();
    }

    @Override
    public String getCollege() {
        return student.getCollege();
    }

    @Override
    public String getGrades() {
        return student.getGrades();
    }

    @Override
    public String getResearch() {
        return student.getResearch().toString();
    }
}