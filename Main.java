package ToDoList;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("1- Create task.");
            System.out.println("2- Show task.");
            System.out.println("3- Update task.");
            System.out.println("4- Delete task.");
            System.out.println("5- Tasks list.");
            System.out.println("6- Latest tasks.");
            System.out.println("7- Done tasks.");
            System.out.println("8- In progress tasks.");
            System.out.println("9- Canceled tasks.");
            System.out.println("0- Exit.");
            System.out.println("--------------------------------------------------");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    taskManager.addTask();
                    break;
                case 2:
                    taskManager.showTask();
                    break;
                case 3:
                    taskManager.updateTask();
                    break;
                case 4:
                    taskManager.deleteTask();
                    break;
                case 5:
                    taskManager.showAllTasks();
                    break;
                case 6:

                    break;
                case 7:
                    taskManager.showDoneTasks();
                    break;
                case 8:
                    taskManager.showInProgressTasks();
                    break;
                case 9:
                    taskManager.showCanceledTasks();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}