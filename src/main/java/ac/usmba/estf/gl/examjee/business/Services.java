package ac.usmba.estf.gl.examjee.business;

import ac.usmba.estf.gl.examjee.models.Task;

import java.util.List;

public interface Services {
    List<Task> listTasks();
    List<Task> listTasksSortedByPriority();
    Task searchTaskById(int id);
    Task addTask(Task task);
    Task deleteTast(Task task);
    void upOrderTask(Task task);
    void downOrderTask(Task task);
}
