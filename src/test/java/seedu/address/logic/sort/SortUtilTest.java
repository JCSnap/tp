package seedu.address.logic.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.sort.enums.SortOrderEnum;
import seedu.address.model.tag.Member;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Description;
import seedu.address.model.task.Note;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Status;
import seedu.address.model.task.Task;

public class SortUtilTest {
    private static final Description FIRST_DESCRIPTION = new Description("A");
    private static final Description SECOND_DESCRIPTION = new Description("B");
    private static final Status DEFAULT_STATUS = new Status();
    private static final Note DEFAULT_NOTE = new Note("");
    private static final Deadline FIRST_DEADLINE = Deadline.of(LocalDateTime.of(2023, 1, 1, 18, 0));
    private static final Deadline SECOND_DEADLINE = Deadline.of(LocalDateTime.of(2023, 1, 1, 22, 0));
    private static final Priority DEFAULT_PRIORITY = Priority.NONE;
    private static final Priority FIRST_PRIORITY = Priority.HIGH;
    private static final Priority SECOND_PRIORITY = Priority.LOW;
    private static final Set<Member> DEFAULT_MEMBERS = new HashSet<>(List.of(new Member("John")));
    private final Comparator<Task> taskComparatorAscending = SortUtil.ofTaskName(SortOrderEnum.ASCENDING);
    private final Comparator<Task> taskComparatorDescending = SortUtil.ofTaskName(SortOrderEnum.DESCENDING);
    private final Comparator<Task> priorityComparatorAscending = SortUtil.ofPriority(SortOrderEnum.ASCENDING);
    private final Comparator<Task> priorityComparatorDescending = SortUtil.ofPriority(SortOrderEnum.DESCENDING);
    private final Comparator<Task> deadlineComparatorAscending = SortUtil.ofDeadline(SortOrderEnum.ASCENDING);
    private final Comparator<Task> deadlineComparatorDescending = SortUtil.ofDeadline(SortOrderEnum.DESCENDING);

    @Test
    public void ofTaskName_ascendingLessThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION);
        Task t2 = new Task(SECOND_DESCRIPTION);
        assertEquals(taskComparatorAscending.compare(t1, t2), -1);
    }

    @Test
    public void ofTaskName_ascendingEqual_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION);
        Task t2 = new Task(FIRST_DESCRIPTION);
        assertEquals(taskComparatorAscending.compare(t1, t2), 0);
    }

    @Test
    public void ofTaskName_ascendingMoreThan_valid() {
        Task t1 = new Task(SECOND_DESCRIPTION);
        Task t2 = new Task(FIRST_DESCRIPTION);
        assertEquals(taskComparatorAscending.compare(t1, t2), 1);
    }

    @Test
    public void ofTaskName_ascending_invalid() {
        assertThrows(AssertionError.class, () -> taskComparatorAscending.compare(null, null));
    }

    @Test
    public void ofTaskName_descendingLessThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION);
        Task t2 = new Task(SECOND_DESCRIPTION);
        assertEquals(taskComparatorDescending.compare(t1, t2), 1);
    }

    @Test
    public void ofTaskName_descendingEqual_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION);
        Task t2 = new Task(FIRST_DESCRIPTION);
        assertEquals(taskComparatorDescending.compare(t1, t2), 0);
    }

    @Test
    public void ofTaskName_descendingMoreThan_valid() {
        Task t1 = new Task(SECOND_DESCRIPTION);
        Task t2 = new Task(FIRST_DESCRIPTION);
        assertEquals(taskComparatorDescending.compare(t1, t2), -1);
    }

    @Test
    public void ofTaskName_descending_invalid() {
        assertThrows(AssertionError.class, () -> taskComparatorDescending.compare(null, null));
    }

    @Test
    public void ofPriority_ascendingLessThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.LOW, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.HIGH, DEFAULT_MEMBERS);
        assertEquals(priorityComparatorAscending.compare(t1, t2), -2);
    }

    @Test
    public void ofPriority_ascendingEqual_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.LOW, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.LOW, DEFAULT_MEMBERS);
        assertEquals(priorityComparatorAscending.compare(t1, t2), 0);
    }

    @Test
    public void ofPriority_ascendingMoreThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.HIGH, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.LOW, DEFAULT_MEMBERS);
        assertEquals(priorityComparatorAscending.compare(t1, t2), 2);
    }

    @Test
    public void ofPriority_ascending_invalid() {
        assertThrows(AssertionError.class, () -> priorityComparatorAscending.compare(null, null));
    }

    @Test
    public void ofPriority_descendingLessThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.LOW, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.HIGH, DEFAULT_MEMBERS);
        assertEquals(priorityComparatorDescending.compare(t1, t2), 2);
    }

    @Test
    public void ofPriority_descendingEqual_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.LOW, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.LOW, DEFAULT_MEMBERS);
        assertEquals(priorityComparatorDescending.compare(t1, t2), 0);
    }

    @Test
    public void ofPriority_descendingMoreThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.HIGH, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, Priority.LOW, DEFAULT_MEMBERS);
        assertEquals(priorityComparatorDescending.compare(t1, t2), -2);
    }

    @Test
    public void ofPriority_descending_invalid() {
        assertThrows(AssertionError.class, () -> priorityComparatorDescending.compare(null, null));
    }

    @Test
    public void ofDeadline_ascendingLessThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                SECOND_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        assertEquals(deadlineComparatorAscending.compare(t1, t2), -1);
    }

    @Test
    public void ofDeadline_ascendingEqual_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        assertEquals(deadlineComparatorAscending.compare(t1, t2), 0);
    }

    @Test
    public void ofDeadline_ascendingMoreThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                SECOND_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        assertEquals(deadlineComparatorAscending.compare(t1, t2), 1);
    }

    @Test
    public void ofDeadline_ascending_invalid() {
        assertThrows(AssertionError.class, () -> deadlineComparatorAscending.compare(null, null));
    }

    @Test
    public void ofDeadline_descendingLessThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                SECOND_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        assertEquals(deadlineComparatorDescending.compare(t1, t2), 1);
    }

    @Test
    public void ofDeadline_descendingEqual_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        assertEquals(deadlineComparatorDescending.compare(t1, t2), 0);
    }

    @Test
    public void ofDeadline_descendingMoreThan_valid() {
        Task t1 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                SECOND_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        Task t2 = new Task(FIRST_DESCRIPTION, DEFAULT_STATUS, DEFAULT_NOTE,
                FIRST_DEADLINE, DEFAULT_PRIORITY, DEFAULT_MEMBERS);
        assertEquals(deadlineComparatorDescending.compare(t1, t2), -1);
    }

    @Test
    public void ofDeadline_descending_invalid() {
        assertThrows(AssertionError.class, () -> deadlineComparatorDescending.compare(null, null));
    }
}
