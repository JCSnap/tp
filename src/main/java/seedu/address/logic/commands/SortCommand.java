package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT_ORDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT_TYPE;

import java.util.Objects;
import java.util.stream.Stream;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.exceptions.IllegalCommandException;
import seedu.address.logic.sort.SortUtil;
import seedu.address.logic.sort.enums.SortOrderEnum;
import seedu.address.logic.sort.enums.SortTypeEnum;
import seedu.address.model.Model;
import seedu.address.model.task.Task;


/**
 * Sorts the task list.
 */
public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = SortCommand.COMMAND_WORD + ": Sorts the task in the task list. "
            + "\nParameters: "
            + PREFIX_SORT_ORDER + "SORT ORDER "
            + PREFIX_SORT_TYPE + "SORT TYPE \n"
            + "Example: " + SortCommand.COMMAND_WORD + " "
            + PREFIX_SORT_ORDER + "a " + PREFIX_SORT_TYPE + "dl";
    public static final String MESSAGE_SUCCESS = "Tasks sorted successfully!";

    private final SortOrderEnum sortOrderEnum;
    private final SortTypeEnum sortTypeEnum;

    /**
     * Creates a {@code SortCommand} object
     *
     * @param sortingOrder The order to sort by
     * @param sortingType The field to sort the Tasks by
     */
    public SortCommand(SortOrderEnum sortingOrder, SortTypeEnum sortingType) {
        if (Stream.of(sortingOrder, sortingType).anyMatch(Objects::isNull)) {
            throw new AssertionError("This should not happen!");
        }

        this.sortOrderEnum = sortingOrder;
        this.sortTypeEnum = sortingType;
    }

    /**
     * Executes the Command.
     *
     * @param model {@code Model} which the command should operate on.
     * @return {@code CommandResult} which encapsulate the results of the execution
     * @throws CommandException if there is any errors when executing this command
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        ObservableList<Task> taskList = model.getTaskWise().getTaskList();

        switch (sortTypeEnum) {
        case TASK_NAME:
            model.setAllTasks(taskList.sorted(SortUtil.ofTaskName(this.sortOrderEnum)));
            break;
        case PRIORITY:
            model.setAllTasks(taskList.sorted(SortUtil.ofPriority(this.sortOrderEnum)));
            break;
        case DEADLINE:
            model.setAllTasks(taskList.sorted(SortUtil.ofDeadline(this.sortOrderEnum)));
            break;
        case STATUS:
            model.setAllTasks(taskList.sorted(SortUtil.ofStatus(this.sortOrderEnum)));
            break;
        default:
            throw new IllegalCommandException("Oh no! I don't seem to understand the command!");
        }

        return new CommandResult(
                SortCommand.MESSAGE_SUCCESS
                + "\nYour Tasks are now sorted according to the "
                + this.sortTypeEnum
                + " and in "
                + this.sortOrderEnum
                + " order!"
        );
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other instanceof SortCommand) {
            SortCommand otherSortCommand = (SortCommand) other;
            return this.sortOrderEnum.equals(otherSortCommand.sortOrderEnum)
                    && this.sortTypeEnum.equals(otherSortCommand.sortTypeEnum);
        }

        return false;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("order", this.sortOrderEnum)
                .add("type", this.sortTypeEnum)
                .toString();
    }
}
