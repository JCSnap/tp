package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.sort.enums.SortOrderEnum;
import seedu.address.logic.sort.enums.SortTypeEnum;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyTaskWise;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.tag.Member;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Description;
import seedu.address.model.task.Note;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Status;
import seedu.address.model.task.Task;
import seedu.address.model.task.UniqueTaskList;
import seedu.address.ui.MainWindow;


public class SortCommandTest {
    private static final Description FIRST_DESCRIPTION = new Description("oh no");
    private static final Description SECOND_DESCRIPTION = new Description("an apple");
    private static final Description THIRD_DESCRIPTION = new Description("xylophone");
    private static final Status DEFAULT_STATUS = new Status();
    private static final Status COMPLETE_STATUS = new Status(true);
    private static final Status INCOMPLETE_STATUS = new Status(false);
    private static final Note DEFAULT_NOTE = new Note("");
    private static final Deadline FIRST_DEADLINE = Deadline.of(LocalDateTime.of(2023, 1, 1, 18, 0));
    private static final Deadline SECOND_DEADLINE = Deadline.of(LocalDateTime.of(2023, 1, 1, 22, 0));
    private static final Priority DEFAULT_PRIORITY = Priority.NONE;
    private static final Priority FIRST_PRIORITY = Priority.HIGH;
    private static final Priority SECOND_PRIORITY = Priority.LOW;
    private static final Set<Member> DEFAULT_MEMBERS = new HashSet<>(List.of(new Member("John")));
    private static final SortCommand validTaskNameAsc = new SortCommand(SortOrderEnum.ASCENDING,
            SortTypeEnum.TASK_DESCRIPTION);
    private static final SortCommand validTaskNameDes = new SortCommand(SortOrderEnum.DESCENDING,
            SortTypeEnum.TASK_DESCRIPTION);
    private static final SortCommand validPriorityAsc = new SortCommand(SortOrderEnum.ASCENDING,
            SortTypeEnum.PRIORITY);
    private static final SortCommand validPriorityDes = new SortCommand(SortOrderEnum.DESCENDING,
            SortTypeEnum.PRIORITY);
    private static final SortCommand validDeadlineAsc = new SortCommand(SortOrderEnum.ASCENDING,
            SortTypeEnum.DEADLINE);
    private static final SortCommand validDeadlineDes = new SortCommand(SortOrderEnum.DESCENDING,
            SortTypeEnum.DEADLINE);
    private static final SortCommand validStatusAsc = new SortCommand(SortOrderEnum.ASCENDING,
            SortTypeEnum.STATUS);
    private static final SortCommand validStatusDes = new SortCommand(SortOrderEnum.DESCENDING,
            SortTypeEnum.STATUS);

    @Test
    public void constructor_nullTasks_throwsAssertionError() {
        assertThrows(AssertionError.class, () -> new SortCommand(null, null));
    }

    @Test
    public void execute_allTasksSetInModel_success() {
        ModelStubWithTaskAccess modelStub = new ModelStubWithTaskAccess();
        assertTrue(modelStub.isSorted(
                List.of(new Task(FIRST_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(SECOND_DESCRIPTION, INCOMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(THIRD_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS))
        ));
    }

    @Test
    public void execute_sortByTaskNameAscending_success() {
        SortCommandTest.ModelStubWithTaskAccess modelStub = new ModelStubWithTaskAccess();
        assertDoesNotThrow(() -> SortCommandTest.validTaskNameAsc.execute(modelStub));
        assertTrue(modelStub.isSorted(
                List.of(new Task(SECOND_DESCRIPTION, INCOMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(FIRST_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(THIRD_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS))
        ));
    }

    @Test
    public void execute_sortByTaskNameDescending_success() {
        SortCommandTest.ModelStubWithTaskAccess modelStub = new ModelStubWithTaskAccess();
        assertDoesNotThrow(() -> SortCommandTest.validTaskNameDes.execute(modelStub));
        assertTrue(modelStub.isSorted(
                List.of(new Task(THIRD_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(FIRST_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(SECOND_DESCRIPTION, INCOMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS))
        ));
    }

    @Test
    public void execute_sortByPriorityAscending_success() {

    }

    @Test
    public void execute_sortByPriorityDescending_success() {

    }

    @Test
    public void execute_sortByDeadlineAscending_success() {

    }

    @Test
    public void execute_sortByDeadlineDescending_success() {

    }

    @Test
    public void execute_sortByStatusAscending_success() {
        SortCommandTest.ModelStubWithTaskAccess modelStub = new ModelStubWithTaskAccess();
        assertDoesNotThrow(() -> SortCommandTest.validStatusAsc.execute(modelStub));

        assertTrue(modelStub.isSorted(
                List.of(new Task(SECOND_DESCRIPTION, INCOMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(FIRST_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(THIRD_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS))
        ));
    }

    @Test
    public void execute_sortByStatusDescending_success() {
        SortCommandTest.ModelStubWithTaskAccess modelStub = new ModelStubWithTaskAccess();
        assertDoesNotThrow(() -> SortCommandTest.validStatusDes.execute(modelStub));
        assertTrue(modelStub.isSorted(
                List.of(new Task(FIRST_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(THIRD_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS),
                        new Task(SECOND_DESCRIPTION, INCOMPLETE_STATUS, DEFAULT_NOTE,
                                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS))
        ));
    }

    @Test
    public void equals() {
        // same object -> returns true
        assertTrue(validTaskNameAsc.equals(validTaskNameAsc));

        // same values -> returns true
        assertTrue(validTaskNameAsc.equals(new SortCommand(SortOrderEnum.ASCENDING, SortTypeEnum.TASK_DESCRIPTION)));

        // different types -> returns false
        assertFalse(validTaskNameAsc.equals(true));

        // null -> returns false
        assertFalse(validTaskNameAsc.equals(null));

        // different task -> returns false
        assertFalse(validDeadlineDes.equals(validPriorityDes));
    }

    @Test
    public void toString_convertToString_success() {
        String expected = SortCommand.class.getCanonicalName() + "{order=" + SortOrderEnum.ASCENDING + ", "
                + "type=" + SortTypeEnum.DEADLINE + "}";
        assertEquals(expected, SortCommandTest.validDeadlineAsc.toString());
    }

    /**
     * A default model stub that have all the methods failing.
     */
    private static class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getTaskWiseFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTaskWiseFilePath(Path taskWiseFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTaskWise(ReadOnlyTaskWise newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyTaskWise getTaskWise() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasTask(Task task) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTask(Task target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setTask(Task target, Task editedTask) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAllTasks(List<Task> tasks) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Task> getFilteredTaskList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredTaskList(Predicate<Task> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public MainWindow getMainWindow() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setMainWindow(MainWindow mainWindow) {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single task.
     */
    private static class ModelStubWithTaskAccess extends SortCommandTest.ModelStub {
        private static final Task t1 = new Task(FIRST_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        private static final Task t2 = new Task(SECOND_DESCRIPTION, INCOMPLETE_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        private static final Task t3 = new Task(THIRD_DESCRIPTION, COMPLETE_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        private final List<Task> innerList = new LinkedList<>();

        ModelStubWithTaskAccess() {
            this.innerList.add(t1);
            this.innerList.add(t2);
            this.innerList.add(t3);
        }

        @Override
        public void addTask(Task task) {
            this.innerList.add(task);
        }

        @Override
        public void setAllTasks(List<Task> tasks) {
            this.innerList.clear();
            this.innerList.addAll(tasks);
        }

        @Override
        public ReadOnlyTaskWise getTaskWise() {
            return new ReadOnlyTaskWise() {
                private final UniqueTaskList uniqueTaskList = new UniqueTaskList();

                @Override
                public ObservableList<Task> getTaskList() {
                    this.uniqueTaskList.add(t1);
                    this.uniqueTaskList.add(t2);
                    this.uniqueTaskList.add(t3);

                    return this.uniqueTaskList.asUnmodifiableObservableList();
                }
            };
        }

        @Override
        public ObservableList<Task> getFilteredTaskList() {
            UniqueTaskList tl = new UniqueTaskList();
            tl.setTasks(this.innerList);
            return tl.asUnmodifiableObservableList();
        }

        public boolean isSorted(List<Task> expected) {
            return this.innerList.equals(expected);
        }
    }

}
