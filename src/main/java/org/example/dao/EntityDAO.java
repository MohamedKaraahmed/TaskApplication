package org.example.dao;


import java.sql.SQLException;
import java.util.List;

public interface EntityDAO<Task> {


    boolean addTask(org.example.model.Task task) throws SQLException;

    Task getByTitle(String title) throws SQLException;

    boolean editTask(org.example.model.Task taskToEdit, org.example.model.Task newTask) throws SQLException;

    boolean removeTask(org.example.model.Task task) throws SQLException;

    List<Task> showActiveTasks() throws SQLException;

    List<Task> showDeletedTasks() throws SQLException;

}
