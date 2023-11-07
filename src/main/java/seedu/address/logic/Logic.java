package seedu.address.logic;

import java.nio.file.Path;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyTaskWise;
import seedu.address.model.task.Task;
import seedu.address.storage.exceptions.StorageException;
import seedu.address.ui.MainWindow;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     * @throws StorageException If an error occurs with the storage of data during command execution.
     * @throws ParseException If an error occurs during parsing.
     */
    CommandResult execute(String commandText) throws CommandException, StorageException, ParseException;

    /**
     * Returns the TaskWise.
     *
     * @see seedu.address.model.Model#getTaskWise()
     */
    ReadOnlyTaskWise getTaskWise();

    /** Returns an unmodifiable view of the filtered list of tasks */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Returns the user prefs' task wise file path.
     */
    Path getTaskWiseFilePath();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Set the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Set main window.
     * @param mainWindow
     */
    void setMainWindow(MainWindow mainWindow);
}
