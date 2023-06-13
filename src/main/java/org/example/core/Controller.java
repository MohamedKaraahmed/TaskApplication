package org.example.core;

import org.example.dao.EntityDAO;
import org.example.dao.EntityDAOImpl;
import org.example.model.DatabaseConnection;
import org.example.model.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.example.Main.scanner;
import static org.example.common.ExceptionMessages.*;
import static org.example.common.OutputMessages.*;

public class Controller implements Runnable {


    public Controller() {

    }

    @Override
    public void run() {
        welcome();
        extractedLogic();
    }

    private static void extractedLogic() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            EntityDAO<Task> entityDAO = new EntityDAOImpl<>(connection);
            String input;
            String title;
            String description;

            do {
                showMenu();
                System.out.println("Choose your option and enter a digit!");
                input = scanner.nextLine();
                Task task;
                switch (input) {
                    case "1":
                        try {
                            System.out.println("Please, enter title for the task: ");
                            title = scanner.nextLine();
                            System.out.println("Please, enter description for the task:");
                            description = scanner.nextLine();

                            task = new Task(title, description);
                            if (entityDAO.addTask(task)) {
                                System.out.println("-".repeat(101));
                                System.out.printf((SUCCESSFULLY_ADDED_TASK) + "%n", title);
                            } else {
                                System.out.println("-".repeat(101));
                                System.out.printf((CANT_ADD_TASK_WITH_EXISTING_TITLE) + "%n", title);
                                System.out.println("Choose another title and try to add it again!");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());

                        }

                        break;
                    case "2":
                        System.out.println("Please, enter an existing title of task in you list, which you want to edit:");
                        title = scanner.nextLine();
                        String oldTitle = title;
                        try {


                            task = entityDAO.getByTitle(title);
                            if (task == null) {
                                System.out.println("-".repeat(101));
                                System.out.printf((CANT_EDIT_NOT_EXISTING_TASK) + "%n", title);
                            } else {
                                System.out.println("Please, enter the new title:");
                                title = scanner.nextLine();
                                System.out.println("Please, enter the new description:");
                                description = scanner.nextLine();
                                Task newTask = new Task(title, description);
                                entityDAO.editTask(task, newTask);
                                System.out.println("-".repeat(101));
                                System.out.printf((SUCCESSFULLY_EDITED_TASK) + "%n", oldTitle);
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Try again!");
                        }
                        break;
                    case "3":
                        System.out.println("Please, enter the title of the task, which you want to remove:");
                        title = scanner.nextLine();
                        try {


                            task = entityDAO.getByTitle(title);
                            if (task == null) {
                                System.out.println("-".repeat(101));
                                System.out.printf((CANT_REMOVE_NOT_EXISTING_TASK) + "%n", title);

                            } else {
                                entityDAO.removeTask(task);
                                System.out.println("-".repeat(101));
                                System.out.printf((SUCCESSFULLY_REMOVED_TASK) + "%n", title);
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Try again!");
                        }
                        break;
                    case "4":
                        List<Task> activeTasks = entityDAO.showActiveTasks();
                        if (activeTasks.isEmpty()) {
                            System.out.println("There are no Active tasks!");
                        } else {
                            System.out.println("-".repeat(101));
                            System.out.printf((ACTIVE_TASKS) + "%n");
                            activeTasks.forEach(e -> System.out.printf("Title: %s  Description: %s%n",
                                    e.getTitle(),
                                    e.getDescription()));
                            System.out.println("-".repeat(101));
                        }
                        break;
                    case "5":
                        List<Task> deletedTasks = entityDAO.showDeletedTasks();
                        if (deletedTasks.isEmpty()) {
                            System.out.println("There are no Deleted tasks!");
                        } else {
                            System.out.println("-".repeat(101));
                            System.out.printf((DELETED_TASKS) + "%n");
                            deletedTasks.forEach(e -> System.out.printf("Title: %s  Description: %s%n",
                                    e.getTitle(),
                                    e.getDescription()));
                            System.out.println("-".repeat(101));
                        }
                        break;
                    case "6":
                        //extract active tasks to a file
                        BufferedWriter fis = new BufferedWriter(new FileWriter("activeTasks.txt"));
                        PrintWriter printWriter = new PrintWriter(fis);

                        List<Task> activeTasksToExtract = entityDAO.showActiveTasks();
                        extractTasksToFile(printWriter, activeTasksToExtract, ACTIVE_TASKS);
                        printWriter.close();
                        fis.close();
                        System.out.println("Extracting...Done");
                        break;
                    case "7":
                        //extract deleted tasks to a file
                        BufferedWriter fis1 = new BufferedWriter(new FileWriter("deletedTasks.txt"));
                        PrintWriter printWriter2 = new PrintWriter(fis1);

                        List<Task> deletedTasksToExtract = entityDAO.showDeletedTasks();
                        extractTasksToFile(printWriter2, deletedTasksToExtract, DELETED_TASKS);
                        printWriter2.close();
                        fis1.close();
                        System.out.println("Extracting...Done");
                        break;
                    case "8":
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("-".repeat(101));
                        System.out.println("Please, enter a digit between 1 and 8 ");
                        break;


                }


            } while (!input.equals("8"));
            {
                connection.close();
            }

        } catch (IllegalArgumentException | SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void extractTasksToFile(PrintWriter printWriter2, List<Task> deletedTasksToExtract, String deletedTasks2) {
        if (deletedTasksToExtract.isEmpty()) {
            printWriter2.print("There are no Active tasks!");
        } else {
            printWriter2.print("-".repeat(101));
            printWriter2.println();
            printWriter2.println(String.format(deletedTasks2));
            deletedTasksToExtract.forEach(e -> printWriter2.printf("%nTitle: %s  Description: %s%n",
                    e.getTitle(),
                    e.getDescription()));
            printWriter2.print("-".repeat(101));
        }
    }

    private static void showMenu() {
        StringBuilder menu = new StringBuilder();
        menu.append("-".repeat(101)).append(System.lineSeparator());
        menu.append("Menu:").append(System.lineSeparator());
        menu.append("1. AddTask.").append(System.lineSeparator());
        menu.append("2. EditTask.").append(System.lineSeparator());
        menu.append("3. RemoveTask.").append(System.lineSeparator());
        menu.append("4. ShowActiveTasks.").append(System.lineSeparator());
        menu.append("5. ShowDeletedTasks.").append(System.lineSeparator());
        menu.append("6. Extract activeTasks to a file.").append(System.lineSeparator());
        menu.append("7. Extract deletedTasks to a file.").append(System.lineSeparator());
        menu.append("8. Exit the application.").append(System.lineSeparator());
        menu.append("-".repeat(101)).append(System.lineSeparator());
        System.out.print(menu.toString());
    }

    private static void welcome() {
        StringBuilder welcome = new StringBuilder();
        welcome.append("-".repeat(101)).append(System.lineSeparator());
        welcome.append("Welcome, to our Task application!").append(System.lineSeparator());
        welcome.append("There are a few functionalities, which our application supports for now.").append(System.lineSeparator());
        welcome.append("To use any of our functionalities, please choose the digit, which is in front of every functionality!").append(System.lineSeparator());
        welcome.append("-".repeat(101)).append(System.lineSeparator());
        System.out.println(welcome.toString());

    }
}
