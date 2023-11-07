package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskWise;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.task.Task;
import seedu.address.testutil.TaskBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private AddCommand.AddTaskDescriptor desc = new AddCommand.AddTaskDescriptor();
    private Model model;

    private void setUpDesc(Task validTask) {
        desc.setDescription(validTask.getDescription());
        desc.setDeadline(validTask.getDeadline());
        desc.setPriority(validTask.getPriority());
        desc.setMembers(validTask.getMembers());
    }

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalTaskWise(), new UserPrefs());
    }

    @Test
    public void execute_newTask_success() {
        Task validTask = new TaskBuilder().build();

        setUpDesc(validTask);

        Model expectedModel = new ModelManager(model.getTaskWise(), new UserPrefs());
        expectedModel.addTask(validTask);

        assertCommandSuccess(new AddCommand(desc), model,
                String.format(AddCommand.MESSAGE_SUCCESS, Messages.format(validTask)),
                expectedModel);
    }

    @Test
    public void execute_duplicateTask_throwsCommandException() {
        Task taskInList = model.getTaskWise().getTaskList().get(0);

        setUpDesc(taskInList);

        assertCommandFailure(new AddCommand(desc), model,
                AddCommand.MESSAGE_DUPLICATE_TASK);
    }

    @AfterEach
    public void reset() {
        desc = new AddCommand.AddTaskDescriptor();
    }

}
