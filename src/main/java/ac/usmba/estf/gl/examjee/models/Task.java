package ac.usmba.estf.gl.examjee.models;

public class Task implements Comparable<Task> {
    private int id;
    private String content;
    private int priority;

    public Task(int id, String content, int priority) {
        this.id = id;
        this.content = content;
        this.priority = priority;
    }

    public Task(String content) {
        this.content = content;
    }

    public Task() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Task task) {
        return this.priority - task.getPriority();
    }
}
