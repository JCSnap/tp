package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.task.Task;
import seedu.address.ui.MainWindow;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final TaskWise taskWise;
    private final UserPrefs userPrefs;

    private final FilteredList<Task> filteredTasks;
    private MainWindow mainWindow;

    /**
     * Initializes a ModelManager with the given taskWise and userPrefs.
     */
    public ModelManager(ReadOnlyTaskWise taskWise, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(taskWise, userPrefs);

        logger.fine("Initializing with task wise: " + taskWise + " and user prefs " + userPrefs);

        this.taskWise = new TaskWise(taskWise);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredTasks = new FilteredList<>(this.taskWise.getTaskList());
        this.mainWindow = null;
    }

    public ModelManager() {
        this(new TaskWise(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getTaskWiseFilePath() {
        return userPrefs.getTaskWiseFilePath();
    }

    @Override
    public void setTaskWiseFilePath(Path taskWiseFilePath) {
        requireNonNull(taskWiseFilePath);
        userPrefs.setTaskWiseFilePath(taskWiseFilePath);
    }

    //=========== TaskWise ================================================================================

    @Override
    public void setTaskWise(ReadOnlyTaskWise taskWise) {
        this.taskWise.resetData(taskWise);
    }

    @Override
    public ReadOnlyTaskWise getTaskWise() {
        return taskWise;
    }

    @Override
    public boolean hasTask(Task task) {
        requireNonNull(task);
        return taskWise.hasTask(task);
    }

    @Override
    public void deleteTask(Task target) {
        taskWise.removeTask(target);
    }

    @Override
    public void addTask(Task task) {
        taskWise.addTask(task);
        updateFilteredTaskList(PREDICATE_SHOW_ALL_TASKS);
    }

    @Override
    public void setTask(Task target, Task editedTask) {
        requireAllNonNull(target, editedTask);

        taskWise.setTask(target, editedTask);
    }

    @Override
    public void setAllTasks(java.util.List<seedu.address.model.task.Task> tasks) {
        if (!tasks.stream().allMatch(java.util.Objects::nonNull)) {
            throw new AssertionError("Task List cannot contain null");
        }

        taskWise.setTasks(tasks);
    }

    //=========== Filtered Task List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Task} backed by the internal list of
     * {@code versionedTaskWise}
     */
    @Override
    public ObservableList<Task> getFilteredTaskList() {
        return filteredTasks;
    }

    @Override
    public void updateFilteredTaskList(Predicate<Task> predicate) {
        requireNonNull(predicate);
        filteredTasks.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ModelManager)) {
            return false;
        }

        ModelManager otherModelManager = (ModelManager) other;
        return taskWise.equals(otherModelManager.taskWise)
                && userPrefs.equals(otherModelManager.userPrefs)
                && filteredTasks.equals(otherModelManager.filteredTasks);
    }

    @Override
    public MainWindow getMainWindow() {
        return mainWindow;
    }

    @Override
    public void setMainWindow(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

}
