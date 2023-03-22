package ac.usmba.estf.gl.examjee.dao;

import ac.usmba.estf.gl.examjee.models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskMemoryDao implements TaskDao {
    private int i = 1;
    private List<Task> tasks = new ArrayList<>();

    @Override
    public List<Task> getAll() {
        return tasks;
    }

    @Override
    public Task getById(int id) {
        for (Task task: tasks) {
            if (id == task.getId()) return task;
        }
        return null;
    }

    @Override
    public Task save(Task task) {
        if (getById(task.getId()) != null) return null;

        task.setId(i++);
        task.setPriority(task.getId());
        tasks.add(task);

        return task;
    }

    @Override
    public Task update(Task task) {
        if (getById(task.getId()) == null) return null;

        Task updatedTask = getById(task.getId());
        updatedTask.setContent(task.getContent());

        return updatedTask;
    }

    @Override
    public Task delete(Task task) {
        Task existTask = getById(task.getId());
        tasks.remove(existTask);

        return existTask;
    }
}
