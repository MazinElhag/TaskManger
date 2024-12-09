package ToDoList;

class Task {
    private int id;
    private String title;
    private String description;
    private String status;
    private String date;

    public Task(int id, String title, String description, String status, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task ID: " + id +
                "\nTitle: " + title +
                "\nDescription: " + description +
                "\nStatus: " + status +
                "\nDate: " + date;
    }
}