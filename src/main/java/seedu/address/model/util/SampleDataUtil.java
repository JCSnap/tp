package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.ReadOnlyTaskWise;
import seedu.address.model.TaskWise;
import seedu.address.model.tag.Member;
import seedu.address.model.task.Description;
import seedu.address.model.task.Task;

/**
 * Contains utility methods for populating {@code TaskWise} with sample data.
 */
public class SampleDataUtil {
    public static Task[] getSampleTasks() {
        return new Task[] {
            new Task(new Description("Project meeting")),
            new Task(new Description("User guide")),
            new Task(new Description("Developer guide"))
        };
    }

    public static ReadOnlyTaskWise getSampleTaskWise() {
        TaskWise sampleAb = new TaskWise();
        for (Task sampleTask : getSampleTasks()) {
            sampleAb.addTask(sampleTask);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Member> getMemberSet(String... strings) {
        return Arrays.stream(strings)
                .map(Member::new)
                .collect(Collectors.toSet());
    }

}
