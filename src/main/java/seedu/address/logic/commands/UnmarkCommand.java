package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.exceptions.IllegalTaskIndexException;
import seedu.address.logic.commands.exceptions.IllegalTaskStatusModificationException;
import seedu.address.model.Model;
import seedu.address.model.task.Status;
import seedu.address.model.task.Task;

/**
 * Marks a task as incomplete.
 */
public class UnmarkCommand extends Command {
    public static final String COMMAND_WORD = "unmark";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Marks the task identified by the index number used in the displayed task list as incomplete.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_UNMARK_TASK_SUCCESS = "Task marked as incomplete: %1$s";
    public static final String MESSAGE_UNMARK_UNMARKED_TASK = "The task is already marked as incomplete";

    private final Index targetIndex;

    public UnmarkCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownList = model.getFilteredTaskList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new IllegalTaskIndexException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        Task taskToUnmark = lastShownList.get(targetIndex.getZeroBased());

        Status status = taskToUnmark.getStatus();
        if (!status.isCompleted()) {
            throw new IllegalTaskStatusModificationException(MESSAGE_UNMARK_UNMARKED_TASK);
        }

        Task markedTask = new Task(taskToUnmark.getDescription(), status.updateStatus(), taskToUnmark.getNote(),
                    taskToUnmark.getDeadline(), taskToUnmark.getPriority(), taskToUnmark.getMembers());
        model.setTask(taskToUnmark, markedTask);


        return new CommandResult(String.format(MESSAGE_UNMARK_TASK_SUCCESS, Messages.format(taskToUnmark)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UnmarkCommand)) {
            return false;
        }

        UnmarkCommand otherUnmarkCommand = (UnmarkCommand) other;
        return targetIndex.equals(otherUnmarkCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
