package ModelTests;

import org.example.model.Task;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

public class ModelTest {
    private static Task task;

    @Before
    public void setUp() {
        task = new Task("Acer", "Aspire");

    }

    @Test
    public void testCreationShouldHaveTasksWithSameTitles() {
        Task task1 = new Task("Acer", "Aspire");
        String taskTitle = task.getTitle();
        String task1Title = task1.getTitle();
        Assert.assertEquals(taskTitle, task1Title);
    }

    @Test
    public void testCreationShouldHaveTasksWithSameDescriptions() {
        Task task1 = new Task("Acer", "Aspire");
        String taskDescription = task.getDescription();
        String task1Description = task1.getDescription();
        Assert.assertEquals(taskDescription, task1Description);
    }

    @Test
    public void testCreationShouldHaveTasksWithDifferentTitles() {
        Task task1 = new Task("Samsung", "Aspire");
        String taskTitle = task.getTitle();
        String task1Title = task1.getTitle();
        Assert.assertNotEquals(taskTitle, task1Title);
    }

    @Test
    public void testCreationShouldHaveTasksWithDifferentDescriptions() {
        Task task1 = new Task("Acer", "Samsung");
        String taskDescription = task.getDescription();
        String task1Description = task1.getDescription();
        Assert.assertNotEquals(taskDescription, task1Description);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationShouldThrowWithBlankOrNullTitle() {
        task = new Task("", "test");
        Task task1 = new Task(null, "test");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationShouldThrowWithBlankOrNullDescription() {
        task = new Task("test", "");
        Task task1 = new Task("test", null);
    }

}
