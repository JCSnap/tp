package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.tag.Member;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Description;
import seedu.address.model.task.Note;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Status;
import seedu.address.model.task.Task;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Task objects.
 */
public class TaskBuilder {
    // TODO: Change task builder's default fields
    public static final String DEFAULT_DESCRIPTION = "Do task";
    public static final String DEFAULT_NOTE = "";
    public static final boolean DEFAULT_STATUS = false;
    public static final Priority DEFAULT_PRIORITY = Priority.NONE;
    public static final Set<Member> DEFAULT_MEMBERS = new HashSet<>();
    private Description description;
    private Status status;
    private Note note;
    private Deadline deadline;
    private Priority priority;
    private Set<Member> members;

    /**
     * Creates a {@code TaskBuilder} with the default details.
     */
    public TaskBuilder() {
        description = new Description(DEFAULT_DESCRIPTION);
        status = new Status(DEFAULT_STATUS);
        note = new Note(DEFAULT_NOTE);
        deadline = null;
        priority = DEFAULT_PRIORITY;
        members = DEFAULT_MEMBERS;
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(Task taskToCopy) {
        description = taskToCopy.getDescription();
        status = taskToCopy.getStatus();
        note = taskToCopy.getNote();
        deadline = taskToCopy.getDeadline();
        priority = taskToCopy.getPriority();
        members = taskToCopy.getMembers();
    }

    /**
     * Sets the {@code Description} of the {@code Task} that we are building.
     */
    public TaskBuilder withDescription(String description) {
        this.description = new Description(description);
        return this;
    }

    /**
     * Sets the {@code Status} of the {@code Task} that we are building.
     */
    public TaskBuilder withStatus(boolean status) {
        this.status = new Status(status);
        return this;
    }

    /**
     * Sets the {@code Note} of the {@code Task} that we are building.
     */
    public TaskBuilder withNote(String note) {
        this.note = new Note(note);
        return this;
    }

    /**
     * Sets the {@code Priority} of the {@code Task} that we are building.
     */
    public TaskBuilder withPriority(Priority priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Task} that we are building.
     */
    public TaskBuilder withMembers(String... members) {
        this.members = SampleDataUtil.getMemberSet(members);
        return this;
    }

    public Task build() {
        return new Task(description, status, note, deadline, priority, members);
    }

}
