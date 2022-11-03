package model;

public class StudentReport {
    private int id;
    private String name;
    private String course;
    private int count;

    public StudentReport(int id, String name, String course, int count) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return this.name + " | " + this.course + " | " + this.count + "\n";
    }
}
