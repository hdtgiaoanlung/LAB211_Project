package bo;

import model.Task;

public class TaskInputter {
    private Task task;

    public TaskInputter() {
        task = new Task();
    }

    public Task inputTask(){
        task.setTaskTypeId();
    }
}
