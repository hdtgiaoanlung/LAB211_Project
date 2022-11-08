package model;

public class Student {

    public static String FORMAT_OUTPUT = "%-15s | %-15s | %-15s | %-10s ";
    public static String HEADER_OUTPUT = String.format(FORMAT_OUTPUT, "Id", "Student Name", "Semester", "Course Name");
    private int id;
    private String studentName;
    private int semester;

    private CourseName courseName;

    public Student() {

    }

    public int getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getSemester() {
        return semester;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public CourseName getCourseName() {
        return courseName;
    }

    public void setCourseName(CourseName courseName) {
        this.courseName = courseName;
    }

    public String getDisplayStudentInfo() {
        return String.format(FORMAT_OUTPUT, id, studentName, semester, courseName);
    }
}
