package seedu.address.model;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.task.Task;
import seedu.address.ui.MainWindow;

/**
 * The API of the Model component.
 */
public interface Model {
    /**
     * {@code Predicate} that always evaluate to true
     */
    Predicate<Task> PREDICATE_SHOW_ALL_TASKS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' task wise file path.
     */
    Path getTaskWiseFilePath();

    /**
     * Sets the user prefs' task wise file path.
     */
    void setTaskWiseFilePath(Path taskWiseFilePath);

    /**
     * Replaces task wise data with the data in {@code taskwise}.
     */
    void setTaskWise(ReadOnlyTaskWise taskWise);

    /**
     * Returns the TaskWise
     */
    ReadOnlyTaskWise getTaskWise();

    /**
     * Returns true if a task with the same description as {@code task} exists in task wise.
     */
    boolean hasTask(Task task);

    /**
     * Deletes the given task.
     * The task must exist in the address book.
     */
    void deleteTask(Task target);

    /**
     * Adds the given task.
     * {@code task} must not already exist in the address book.
     */
    void addTask(Task task);

    /**
     * Replaces the given task {@code target} with {@code editedTask}.
     * {@code target} must exist in the address book.
     * The task identity of {@code editedTask} must not be the same as another existing task in the address book.
     */
    void setTask(Task target, Task editedTask);

    /**
     * Replaces all tasks in the list with {@code Tasks} in task list
     * @param tasks {@code Task} to replace all tasks with
     */
    void setAllTasks(List<Task> tasks);

    /**
     * Returns an unmodifiable view of the filtered task list
     */
    ObservableList<Task> getFilteredTaskList();

    /**
     * Updates the filter of the filtered task list to filter by the given {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTaskList(Predicate<Task> predicate);

    /**
     * Returns the main window
     * @return
     */
    MainWindow getMainWindow();

    /**
     * Sets the main window
     * @param mainWindow
     */
    void setMainWindow(MainWindow mainWindow);
}
