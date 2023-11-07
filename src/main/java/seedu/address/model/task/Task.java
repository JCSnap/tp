package seedu.address.model.task;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Member;
import seedu.address.model.tag.Tag;

/**
 * Represents a Task in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    // Identity fields
    private final Description description;
    private final Status status;
    private final Note note;
    private final Deadline deadline;
    private final Priority priority;
    private final Set<Tag> tags = new HashSet<>();
    private final Set<Member> members = new HashSet<>();
    /**
     * Only description is required.
     *
     * @param description
     */
    public Task(Description description) {
        requireAllNonNull(description);
        this.description = description;
        this.status = new Status();
        this.note = new Note("");
        this.deadline = Deadline.ofNull();
        this.priority = Priority.NONE;
        this.tags.addAll(Collections.emptySet());
        this.members.addAll(Collections.emptySet());
    }

    /**
     * Constructor for a task with a description, status, note, deadline and priority.
     *
     * @param description
     * @param status
     * @param note
     * @param deadline
     * @param priority
     * @param members
     */
    public Task(Description description, Status status, Note note,
                Deadline deadline, Priority priority, Set<Member> members) {
        requireAllNonNull(description);
        this.description = description;
        this.status = status;
        this.note = note;
        this.deadline = deadline;
        this.priority = priority;
        this.tags.addAll(Collections.emptySet());
        this.members.addAll(members);
    }
    public Description getDescription() {
        return description;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public Status getStatus() {
        return status;
    }

    public Note getNote() {
        return note;
    }
    public Deadline getDeadline() {
        return deadline;
    }

    /**
     * Returns the priority level of the task.
     * @return priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Returns an immutable member set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Member> getMembers() {
        return Collections.unmodifiableSet(members);
    }

    /**
     * Returns true if both tasks have the same name.
     * This defines a weaker notion of equality between two tasks.
     */
    public boolean isSameTask(Task otherTask) {
        if (otherTask == this) {
            return true;
        }

        return otherTask != null
                && otherTask.getDescription().equals(getDescription());
    }

    /**
     * Returns true if both tasks have the same identity and data fields.
     * This defines a stronger notion of equality between two tasks.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return description.equals(otherTask.description)
                && tags.equals(otherTask.tags)
                && status.equals(otherTask.status)
                && priority.equals(otherTask.priority)
                && members.equals(otherTask.members);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(description, tags, status, note, deadline, priority, members);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", description)
                .add("tags", tags)
                .add("status", status)
                .add("note", note)
                .add("deadline", deadline)
                .add("priority", priority)
                .add("members", members)
                .toString();
    }
}
