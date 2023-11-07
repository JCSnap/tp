package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showTaskAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_TASK;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskWise;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.task.Task;

public class UnmarkCommandTest {
    private Model model = new ModelManager(getTypicalTaskWise(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Task taskToUnmark = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());
        Task markedTask = new Task(taskToUnmark.getDescription(), taskToUnmark.getStatus().updateStatus(),
                taskToUnmark.getNote(), taskToUnmark.getDeadline(),
                taskToUnmark.getPriority(), taskToUnmark.getMembers());
        model.setTask(taskToUnmark, markedTask);
        Task unmarkedTask = new Task(markedTask.getDescription(), markedTask.getStatus().updateStatus(),
                markedTask.getNote(), markedTask.getDeadline(),
                taskToUnmark.getPriority(), taskToUnmark.getMembers());

        UnmarkCommand unmarkCommand = new UnmarkCommand(INDEX_FIRST_TASK);

        String expectedMessage = String.format(UnmarkCommand.MESSAGE_UNMARK_TASK_SUCCESS,
                Messages.format(taskToUnmark));

        ModelManager expectedModel = new ModelManager(model.getTaskWise(), new UserPrefs());
        expectedModel.setTask(model.getFilteredTaskList().get(0), unmarkedTask);

        assertCommandSuccess(unmarkCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_unmarkUnmarkedTask_throwsCommandException() {
        Task taskToUnmark = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());

        UnmarkCommand unmarkCommand = new UnmarkCommand(INDEX_FIRST_TASK);

        assertCommandFailure(unmarkCommand, model, UnmarkCommand.MESSAGE_UNMARK_UNMARKED_TASK);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTaskList().size() + 1);
        UnmarkCommand unmarkCommand = new UnmarkCommand(outOfBoundIndex);

        assertCommandFailure(unmarkCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showTaskAtIndex(model, INDEX_FIRST_TASK);

        Task taskToUnmark = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());
        Task markedTask = new Task(taskToUnmark.getDescription(), taskToUnmark.getStatus().updateStatus(),
                taskToUnmark.getNote(), taskToUnmark.getDeadline(),
                taskToUnmark.getPriority(), taskToUnmark.getMembers());
        model.setTask(taskToUnmark, markedTask);
        Task unmarkedTask = new Task(markedTask.getDescription(), markedTask.getStatus().updateStatus(),
                markedTask.getNote(), markedTask.getDeadline(),
                taskToUnmark.getPriority(), markedTask.getMembers());

        UnmarkCommand unmarkCommand = new UnmarkCommand(INDEX_FIRST_TASK);

        String expectedMessage = String.format(UnmarkCommand.MESSAGE_UNMARK_TASK_SUCCESS,
                Messages.format(taskToUnmark));

        Model expectedModel = new ModelManager(model.getTaskWise(), new UserPrefs());
        expectedModel.setTask(model.getFilteredTaskList().get(0), unmarkedTask);
        showTaskAtIndex(expectedModel, INDEX_FIRST_TASK);

        assertCommandSuccess(unmarkCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showTaskAtIndex(model, INDEX_FIRST_TASK);

        Index outOfBoundIndex = INDEX_SECOND_TASK;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getTaskWise().getTaskList().size());

        UnmarkCommand unmarkCommand = new UnmarkCommand(outOfBoundIndex);

        assertCommandFailure(unmarkCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        UnmarkCommand unmarkFirstCommand = new UnmarkCommand(INDEX_FIRST_TASK);
        UnmarkCommand unmarkSecondCommand = new UnmarkCommand(INDEX_SECOND_TASK);

        // same object -> returns true
        assertTrue(unmarkFirstCommand.equals(unmarkFirstCommand));

        // same values -> returns true
        UnmarkCommand unmarkFirstCommandCopy = new UnmarkCommand(INDEX_FIRST_TASK);
        assertTrue(unmarkFirstCommand.equals(unmarkFirstCommandCopy));

        // different types -> returns false
        assertFalse(unmarkFirstCommand.equals(1));

        // null -> returns false
        assertFalse(unmarkFirstCommand.equals(null));

        // different task -> returns false
        assertFalse(unmarkFirstCommand.equals(unmarkSecondCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        UnmarkCommand unmarkCommand = new UnmarkCommand(targetIndex);
        String expected = UnmarkCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, unmarkCommand.toString());
    }

}
