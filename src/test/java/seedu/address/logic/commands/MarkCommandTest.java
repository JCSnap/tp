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

public class MarkCommandTest {
    private Model model = new ModelManager(getTypicalTaskWise(), new UserPrefs());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());
        Task markedTask = new Task(taskToMark.getDescription(), taskToMark.getStatus().updateStatus(),
                taskToMark.getNote(), taskToMark.getDeadline(), taskToMark.getPriority(), taskToMark.getMembers());

        MarkCommand markCommand = new MarkCommand(INDEX_FIRST_TASK);

        String expectedMessage = String.format(MarkCommand.MESSAGE_MARK_TASK_SUCCESS,
                Messages.format(taskToMark));

        ModelManager expectedModel = new ModelManager(model.getTaskWise(), new UserPrefs());
        expectedModel.setTask(model.getFilteredTaskList().get(0), markedTask);

        assertCommandSuccess(markCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_markMarkedTask_throwsCommandException() {
        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());
        Task markedTask = new Task(taskToMark.getDescription(), taskToMark.getStatus().updateStatus(),
                taskToMark.getNote(), taskToMark.getDeadline(), taskToMark.getPriority(), taskToMark.getMembers());
        model.setTask(taskToMark, markedTask);

        MarkCommand markCommand = new MarkCommand(INDEX_FIRST_TASK);

        assertCommandFailure(markCommand, model, MarkCommand.MESSAGE_MARK_MARKED_TASK);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTaskList().size() + 1);
        MarkCommand markCommand = new MarkCommand(outOfBoundIndex);

        assertCommandFailure(markCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showTaskAtIndex(model, INDEX_FIRST_TASK);

        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());
        Task markedTask = new Task(taskToMark.getDescription(), taskToMark.getStatus().updateStatus(),
                taskToMark.getNote(), taskToMark.getDeadline(), taskToMark.getPriority(), taskToMark.getMembers());
        MarkCommand markCommand = new MarkCommand(INDEX_FIRST_TASK);

        String expectedMessage = String.format(MarkCommand.MESSAGE_MARK_TASK_SUCCESS,
                Messages.format(taskToMark));

        Model expectedModel = new ModelManager(model.getTaskWise(), new UserPrefs());
        expectedModel.setTask(model.getFilteredTaskList().get(0), markedTask);
        showTaskAtIndex(expectedModel, INDEX_FIRST_TASK);

        assertCommandSuccess(markCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showTaskAtIndex(model, INDEX_FIRST_TASK);

        Index outOfBoundIndex = INDEX_SECOND_TASK;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getTaskWise().getTaskList().size());

        MarkCommand markCommand = new MarkCommand(outOfBoundIndex);

        assertCommandFailure(markCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        MarkCommand markFirstCommand = new MarkCommand(INDEX_FIRST_TASK);
        MarkCommand markSecondCommand = new MarkCommand(INDEX_SECOND_TASK);

        // same object -> returns true
        assertTrue(markFirstCommand.equals(markFirstCommand));

        // same values -> returns true
        MarkCommand markFirstCommandCopy = new MarkCommand(INDEX_FIRST_TASK);
        assertTrue(markFirstCommand.equals(markFirstCommand));

        // different types -> returns false
        assertFalse(markFirstCommand.equals(1));

        // null -> returns false
        assertFalse(markFirstCommand.equals(null));

        // different task -> returns false
        assertFalse(markFirstCommand.equals(markSecondCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        MarkCommand markCommand = new MarkCommand(targetIndex);
        String expected = MarkCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, markCommand.toString());
    }

}
