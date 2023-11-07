package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.exceptions.IllegalTaskIndexException;
import seedu.address.model.Model;
import seedu.address.model.task.Task;
import seedu.address.ui.MainWindow;


/**
 * Views a task identified using it's displayed index from the task list.
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE =
            COMMAND_WORD + ": Shows the full information about a task.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String SHOWING_VIEW_MESSAGE = "Viewing task: %1$s";
    private final Index targetIndex;

    public ViewCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        MainWindow mainWindow = model.getMainWindow();
        requireNonNull(model);
        requireNonNull(mainWindow);
        List<Task> lastShownList = model.getFilteredTaskList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new IllegalTaskIndexException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        seedu.address.model.task.Task taskToView = lastShownList.get(targetIndex.getZeroBased());
        mainWindow.setTaskToTaskListPanel(taskToView);

        return new CommandResult(String.format(SHOWING_VIEW_MESSAGE, Messages.format(taskToView)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ViewCommand)) {
            return false;
        }

        ViewCommand otherViewCommand = (ViewCommand) other;
        return targetIndex.equals(otherViewCommand.targetIndex);
    }

    @Override
    public String toString() {
        return new seedu.address.commons.util.ToStringBuilder(this)
                .add("targetIndex", targetIndex)
                .toString();
    }
}
