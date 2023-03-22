package ac.usmba.estf.gl.examjee.dao;

import ac.usmba.estf.gl.examjee.models.Task;

import java.util.List;

public interface TaskDao {
    List<Task> getAll();
    Task getById(int id);
    Task save(Task task);
    Task update(Task task);
    Task delete(Task task);
}
