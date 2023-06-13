package org.example.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EntityDAOImpl<Task> implements EntityDAO<org.example.model.Task> {
    private Connection connection;

    public EntityDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean addTask(org.example.model.Task task) throws SQLException {
        String sql = "INSERT INTO TASKS (`title`,`description`,`is_active`) VALUES (?,?,true);";

        if (!checkIfTaskExist(task)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.setString(2, task.getDescription());
            preparedStatement.execute();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public org.example.model.Task getByTitle(String title) throws SQLException {
        org.example.model.Task task = new org.example.model.Task(title, "old description");
        if (!checkIfTaskExist(task)) {
            return null;
        } else {
            String sql = "SELECT * FROM TASKS WHERE `title` = ? LIMIT 1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String description = resultSet.getString("description");
            return task = new org.example.model.Task(title, description);
        }
    }


    @Override
    public boolean editTask(org.example.model.Task taskToEdit, org.example.model.Task newTask) throws SQLException {
        if (!checkIfTaskExist(taskToEdit)) {
            return false;
        } else {
            String sql = "UPDATE TASKS SET title = ?, description = ? WHERE title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newTask.getTitle());
            preparedStatement.setString(2, newTask.getDescription());
            preparedStatement.setString(3, taskToEdit.getTitle());
            preparedStatement.execute();
            return true;
        }
    }


    @Override
    public boolean removeTask(org.example.model.Task task) throws SQLException {
        if (!checkIfTaskExist(task)) {
            return false;
        } else {
            String sql = "UPDATE TASKS SET is_active = false, is_deleted = true WHERE title = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, task.getTitle());
            preparedStatement.execute();
            return true;
        }
    }


    @Override
    public List<org.example.model.Task> showActiveTasks() throws SQLException {
        String sql = "SELECT title, description FROM TASKS WHERE is_active = true and is_deleted = false";
        return getTasks(sql);
    }

    public List<org.example.model.Task> showDeletedTasks() throws SQLException {
        String sql = "SELECT title, description FROM TASKS WHERE is_active = false and is_deleted = true";
        return getTasks(sql);
    }

    private List<org.example.model.Task> getTasks(String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<org.example.model.Task> activeTasks = new ArrayList<>();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            org.example.model.Task task = new org.example.model.Task(title, description);

            activeTasks.add(task);
        }
        return Collections.unmodifiableList(activeTasks);
    }

    private boolean checkIfTaskExist(org.example.model.Task task) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TASKS WHERE `title` = ? AND is_deleted = false");
        preparedStatement.setString(1, task.getTitle());
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();

    }
}
