package seedu.address.testutil;

import seedu.address.model.TaskWise;
import seedu.address.model.task.Task;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 * {@code TaskWise ab = new TaskWiseBuilder().withTask("John", "Doe").build();}
 */
public class TaskWiseBuilder {

    private TaskWise taskWise;

    public TaskWiseBuilder() {
        taskWise = new TaskWise();
    }

    public TaskWiseBuilder(TaskWise taskWise) {
        this.taskWise = taskWise;
    }

    /**
     * Adds a new {@code Task} to the {@code TaskWise} that we are building.
     */
    public TaskWiseBuilder withTask(Task task) {
        taskWise.addTask(task);
        return this;
    }

    public TaskWise build() {
        return taskWise;
    }
}
