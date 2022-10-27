package bo;

import model.Task;
import utils.InputUtils;

public class TaskInputter {
    private Task task;

    public TaskInputter() {
        task = new Task();
    }

    public Task inputTask(){
        task = new Task();
        task.setId(InputUtils.getInt("Enter ID of the task: ", "Input number only!", "Input must be in range from 1 to " + Integer.MAX_VALUE, 1, Integer.MAX_VALUE));
        task.setTaskTypeId(InputUtils.getInt("Enter ID of the task: ", "Input number only!", "Input must be in range from 1 to 4!", 1, 4));
        task.setRequirementName(InputUtils.getNonEmptyString("Enter requirement of the task: "));
        task.setDate(InputUtils.inputDate("Enter date of the task: "));
        task.setPlanFrom(InputUtils.getFloat("Enter time of plan from: ", "Input must be float type", "Input out of range", 8F, 15.5f));
        task.setPlanTo();
        return task;
    }
}
