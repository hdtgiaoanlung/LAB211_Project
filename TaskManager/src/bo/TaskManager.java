package bo;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import model.Task;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> taskList;
    private int lastTaskID;

    public TaskManager() {
        taskList = new ArrayList<>();
        lastTaskID = 0;
    }

    public int searchById(int id) {
        for(int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean addTask(Task t) throws Exception{
        if (t != null) {
            //return to boolean type
            ++lastTaskID;
            return taskList.add(t);
        }
        throw new Exception("Invalid task");
    }

    public Task deleteTask(int id) throws Exception{
        int index = searchById(id);
        if(index != -1) {
            return taskList.remove(index);
        }
        throw new Exception("Id not found!");
    }

    @Override
    public String toString() {
        String ret = "";
        for(Task t : taskList) {
            ret += t.toString() + "\n";
        }
        return ret;
    }
}
