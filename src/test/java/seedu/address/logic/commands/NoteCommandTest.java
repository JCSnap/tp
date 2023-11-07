package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskWise;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.task.Note;
import seedu.address.model.task.Task;

public class NoteCommandTest {
    private Model model = new ModelManager(getTypicalTaskWise(), new UserPrefs());

    @Test
    public void execute_validIndexAndNoteUnfilteredList_success() {
        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());
        Note validNote = new Note("Remember to clarify with the tutor first");
        Task notedTask = new Task(taskToMark.getDescription(), taskToMark.getStatus(),
                validNote, taskToMark.getDeadline(), taskToMark.getPriority(), taskToMark.getMembers());

        NoteCommand noteCommand = new NoteCommand(INDEX_FIRST_TASK, validNote);

        String expectedMessage = String.format(NoteCommand.MESSAGE_NOTE_TASK_SUCCESS,
                Messages.format(taskToMark));

        ModelManager expectedModel = new ModelManager(model.getTaskWise(), new UserPrefs());
        expectedModel.setTask(model.getFilteredTaskList().get(0), notedTask);

        assertCommandSuccess(noteCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTaskList().size() + 1);
        NoteCommand noteCommand = new NoteCommand(outOfBoundIndex, new Note(
                "Remember to clarify with the tutor first"));

        assertCommandFailure(noteCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }
}
