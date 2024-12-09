package ToDoList;

import java.util.*;

public class TaskManager {
    private ArrayList<Task> tasks;
    private static int id = 1;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.print("Enter task title: ");
        String title = input.nextLine();

        System.out.print("Enter task description: ");
        String description = input.nextLine();

        System.out.print("Enter task status (done, in progress, canceled): ");
        String status = input.nextLine().toLowerCase();

        while (!status.equals("done") && !status.equals("in progress") && !status.equals("canceled")) {
            System.out.print("Enter task status (done, in progress, canceled) be sure: ");
            status = input.nextLine().toLowerCase();
        }

        System.out.print("Enter task date: ");
        String date = input.nextLine();

        Task newTask = new Task(id, title, description, status, date);
        tasks.add(newTask);
        id++;
        System.out.println("--------------------------------------------------");
        System.out.println("Task created successfully!");
        System.out.println("--------------------------------------------------");
    }

    public void showTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.print("Enter task ID to show: ");
        int taskId = input.nextInt();

        boolean found = false;
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == taskId) {
                System.out.println("--------------------------------------------------");
                System.out.println(task);
                System.out.println("--------------------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("--------------------------------------------------");
            System.out.println("Task not found with ID: " + taskId);
            System.out.println("--------------------------------------------------");
        }
    }

    public void updateTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.print("Enter task ID to update: ");
        int taskId = input.nextInt();

        boolean found = false;
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == taskId) {
                found = true;
                input.nextLine();
                System.out.print("Enter new title (leave empty to keep current): ");
                String title = input.nextLine();
                if (!title.isEmpty()) {
                    task.setTitle(title);
                }

                System.out.print("Enter new description (leave empty to keep current): ");
                String description = input.nextLine();
                if (!description.isEmpty()) {
                    task.setDescription(description);
                }

                System.out.print("Enter new status (done, in progress, canceled): ");
                String status = input.nextLine().toLowerCase();
                while (!status.equals("done") && !status.equals("in progress") && !status.equals("canceled")) {
                    System.out.print("Enter valid task status (done, in progress, canceled): ");
                    status = input.nextLine().toLowerCase();
                }
                task.setStatus(status);

                System.out.println("--------------------------------------------------");
                System.out.println("Task updated successfully!");
                System.out.println("--------------------------------------------------");
                break;
            }
        }

        if (!found) {
            System.out.println("--------------------------------------------------");
            System.out.println("Task not found with ID: " + taskId);
            System.out.println("--------------------------------------------------");
        }
    }

    public void deleteTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.print("Enter task ID to delete: ");
        int taskId = input.nextInt();

        boolean taskFound = false;
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == taskId) {
                iterator.remove();
                taskFound = true;
                break;
            }
        }

        if (taskFound) {
            System.out.println("--------------------------------------------------");
            System.out.println("Task deleted successfully!");
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("Task not found with ID: " + taskId);
            System.out.println("--------------------------------------------------");
        }
    }

    public void showAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("--------------------------------------------------");
            System.out.println("No tasks available.");
            System.out.println("--------------------------------------------------");
        } else {
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                System.out.println("--------------------------------------------------");
                System.out.println(iterator.next());
                System.out.println("--------------------------------------------------");
            }
        }
    }

    public void showTasksByStatus(String status) {
        boolean found = false;
        System.out.println("--------------------------------------------------");
        System.out.println(status + " Tasks:");

        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getStatus().equalsIgnoreCase(status)) {
                System.out.println(task);
                found = true;
            }
        }

        if (!found) {
            System.out.println("--------------------------------------------------");
            System.out.println("No tasks found with status: " + status);
            System.out.println("--------------------------------------------------");
        }
    }

    public void showDoneTasks() {
        showTasksByStatus("done");
    }

    public void showInProgressTasks() {
        showTasksByStatus("in progress");
    }

    public void showCanceledTasks() {
        showTasksByStatus("canceled");
    }
}
