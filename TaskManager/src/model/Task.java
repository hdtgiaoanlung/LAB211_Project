package model;

import java.util.Date;

public class Task {

    public static String FORMAT_OUTPUT = "%-5s | %-5s | %-20s | %-10s | %-5s | %-5s | %-10s | %-10s \n";
    public static String HEADER_OUTPUT = String.format(FORMAT_OUTPUT, "id", "Task Type ID", "Requirement Name", "Date", "Plan From", "Plan To", "Assignee", "Reviewer");
    private int id;
    private int taskTypeId;
    private String requirementName;
    private Date date;
    private float planFrom;
    private float planTo;
    private String assignee;
    private String reviewer;

    public Task(){

    }

    public int getId() {
        return id;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public Date getDate() {
        return date;
    }

    public float getPlanFrom() {
        return planFrom;
    }

    public float getPlanTo() {
        return planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPlanFrom(float planFrom) {
        this.planFrom = planFrom;
    }

    public void setPlanTo(float planTo) {
        this.planTo = planTo;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return String.format(FORMAT_OUTPUT, id, taskTypeId, requirementName, date, planFrom, planTo, assignee, reviewer);
    }
}
