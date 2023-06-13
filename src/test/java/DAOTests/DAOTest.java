package DAOTests;

import org.example.dao.EntityDAOImpl;
import org.example.model.DatabaseConnection;
import org.example.model.Task;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class DAOTest {
    private EntityDAOImpl<Task> entityDAO;
    private Connection connection;
    private static Task task;

    @Before
    public void setUp() throws SQLException {
        connection = DatabaseConnection.getConnection();
        entityDAO = new EntityDAOImpl<>(connection);
        task = new Task("Acer", "Aspire");
    }

    @Test
    public void testAddShouldAddTaskProperly() throws SQLException {
        entityDAO.addTask(task);
        String title = task.getTitle();
        Task task1 = entityDAO.getByTitle(title);
        Assert.assertNotNull(task1);

    }

    @Test
    public void testAddShouldNotAddBecauseOfExistingTaskWithSameTitle() throws SQLException {
        entityDAO.addTask(task);
        Assert.assertFalse(entityDAO.addTask(task));
    }

    @Test
    public void testGetByTitleShouldReturnExistingTask() throws SQLException {
        String title = task.getTitle();
        entityDAO.addTask(task);
        Task task1 = entityDAO.getByTitle(title);
        String titleFromMethod = task1.getTitle();
        String descriptionFromMethod = task1.getDescription();
        Assert.assertEquals(title, titleFromMethod);
        Assert.assertEquals(task.getDescription(), descriptionFromMethod);
        Assert.assertNotNull(task1);
    }

    @Test
    public void testGetByTitleShouldNotReturnBecauseOfNotExistingTask() throws SQLException {
        Task task1 = new Task("test", "test");
        entityDAO.addTask(task1);
        entityDAO.removeTask(task1);
        Task task2 = entityDAO.getByTitle(task1.getTitle());
        Assert.assertNull(task2);
    }

    @Test
    public void testEditShouldEditProperly() throws SQLException {
        String newTitle = "test";
        String newDescription = "test";
        Task newTask = new Task(newTitle, newDescription);
        entityDAO.addTask(task);
        Assert.assertTrue(entityDAO.editTask(task, newTask));
        Task editedTask = entityDAO.getByTitle(newTitle);
        Assert.assertEquals(newTitle, editedTask.getTitle());
        Assert.assertEquals(newDescription, editedTask.getDescription());

    }

    @Test
    public void testEditShouldNotEditBecauseOfNotExistingTask() throws SQLException {
        String newTitle = "test";
        String newDescription = "test";
        Task newTask = new Task(newTitle, newDescription);
        entityDAO.addTask(task);
        entityDAO.removeTask(task);
        Assert.assertFalse(entityDAO.editTask(task, newTask));

    }

    @Test
    public void testDeleteShouldDeleteProperly() throws SQLException {
        entityDAO.addTask(task);
        Assert.assertTrue(entityDAO.removeTask(task));
    }

    @Test
    public void testDeleteShouldFailWhenTryToDeleteNotExistingTask() throws SQLException {
        Task task1 = new Task("taskToDelete", "taskToDelete");
        Assert.assertFalse(entityDAO.removeTask(task1));
    }

    @Test
    public void testShowActiveTaskShouldReturnAllActiveTasks() throws SQLException {
        entityDAO.addTask(task);
        entityDAO.addTask(new Task("test", "test"));
        entityDAO.addTask(new Task("test1", "test1"));
        Assert.assertEquals(3, entityDAO.showActiveTasks().size());
    }

    @Test
    public void testShowDeletedTaskShouldReturnAllDeletedTasks() throws SQLException {


        String sql = "SELECT COUNT(is_deleted) as `count` FROM TASKS WHERE is_deleted = true;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int expectedNumberDeletedTasks = rs.getInt("count");
        Assert.assertEquals(expectedNumberDeletedTasks, entityDAO.showDeletedTasks().size());
    }


}
