package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.TaskWise;
import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {
    // TODO: Change test cases
    // TODO: Change test cases
    public static final Task ALICE = new TaskBuilder()
            .withDescription("Fix bug").withStatus(false).withNote("").build();
    public static final Task BENSON = new TaskBuilder()
            .withDescription("Do OP2 report").withStatus(false).withNote("").build();
    public static final Task CARL = new TaskBuilder()
            .withDescription("Do OP2 presentation").withStatus(false).withNote("").build();
    public static final Task DANIEL = new TaskBuilder()
            .withDescription("Do user guide").withStatus(false).withNote("").build();
    public static final Task ELLE = new TaskBuilder()
            .withDescription("Do developer guide").withStatus(false).withNote("").build();
    public static final Task FIONA = new TaskBuilder()
            .withDescription("Meeting to discuss OP2").withStatus(false).withNote("").build();
    public static final Task GEORGE = new TaskBuilder()
            .withDescription("Rehearse OP2 presentation").withStatus(false).withNote("").build();


    // Manually added
    public static final Task HOON = new TaskBuilder().withDescription("task one").build();
    public static final Task IDA = new TaskBuilder().withDescription("task two").build();

    // Manually added - Task's details found in {@code CommandTestUtil}
    // TODO: Add other fields required for test case ie. Deadline, Priority.
    public static final Task AMY = new TaskBuilder()
            .withDescription(VALID_NAME_AMY).withStatus(false).withNote("").build();
    public static final Task BOB = new TaskBuilder()
            .withDescription(VALID_NAME_BOB).withStatus(false).withNote("").build();

    public static final String KEYWORD_MATCHING_MEIER = "OP2"; // A keyword that matches MEIER

    private TypicalTasks() {
    } // prevents instantiation

    /**
     * Returns an {@code TaskWise} with all the typical tasks.
     */
    public static TaskWise getTypicalTaskWise() {
        TaskWise tw = new TaskWise();
        for (Task task : getTypicalTasks()) {
            tw.addTask(task);
        }
        return tw;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
