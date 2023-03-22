package ac.usmba.estf.gl.examjee.business;

import ac.usmba.estf.gl.examjee.dao.TaskDao;
import ac.usmba.estf.gl.examjee.dao.TaskMemoryDao;
import ac.usmba.estf.gl.examjee.models.Task;

import java.util.Collections;
import java.util.List;

public class DefaultServices implements Services {
    private static Services instance;
    public static Services getInstance() {
        if (instance == null) {
            instance = new DefaultServices(new TaskMemoryDao());
        }

        return instance;
    }
    private TaskDao taskDao;
    private DefaultServices(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    @Override
    public List<Task> listTasks() {
        return taskDao.getAll();
    }
    @Override
    public List<Task> listTasksSortedByPriority() {
        List<Task> tasks = taskDao.getAll();
        Collections.sort(tasks);

        return tasks;
    }
    @Override
    public Task searchTaskById(int id) {
        return taskDao.getById(id);
    }

    @Override
    public Task addTask(Task task) {
        return taskDao.save(task);
    }
    public Task deleteTast(Task task) {
        return taskDao.delete(task);
    }

    @Override
    public void upOrderTask(Task task) {
        List<Task> tasks = taskDao.getAll();
        for (int i = 1; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == task.getId()) {
                Task task1 = tasks.get(i - 1);
                int temp = task.getPriority();
                task.setPriority(task1.getPriority());
                task1.setPriority(temp);

                taskDao.save(task);
                taskDao.save(task1);
            }
        }
    }

    @Override
    public void downOrderTask(Task task) {
        List<Task> tasks = taskDao.getAll();
        for (int i = 0; i < tasks.size() - 1; i++) {
            if (tasks.get(i).getId() == task.getId()) {
                Task task1 = tasks.get(i + 1);
                int temp = task.getPriority();
                task.setPriority(task1.getPriority());
                task1.setPriority(temp);

                taskDao.save(task);
                taskDao.save(task1);
            }
        }
    }
}
