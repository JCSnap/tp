package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEMBER;

import java.util.Set;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditTaskDescriptor;
import seedu.address.model.tag.Member;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Task;

/**
 * A utility class for Task.
 */
public class TaskUtil {

    /**
     * Returns an add command string for adding the {@code task}.
     */
    public static String getAddCommand(Task task) {
        return AddCommand.COMMAND_WORD + " " + getTaskDetails(task);
    }

    /**
     * Returns the part of command string for the given {@code task}'s details.
     */
    public static String getTaskDetails(Task task) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_DESCRIPTION + task.getDescription().fullDescription + " ");
        task.getTags().stream().forEach(
            s -> sb.append(PREFIX_MEMBER + s.tagName + " ")
        );
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditTaskDescriptor}'s details.
     */
    public static String getEditTaskDescriptorDetails(EditTaskDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getDescription().ifPresent(name -> sb.append(PREFIX_DESCRIPTION)
                .append(name.fullDescription).append(" "));
        if (descriptor.getTags().isPresent()) {
            Set<Tag> tags = descriptor.getTags().get();
            if (tags.isEmpty()) {
                sb.append(PREFIX_MEMBER);
            } else {
                tags.forEach(s -> sb.append(PREFIX_MEMBER).append(s.tagName).append(" "));
            }
        }

        if (descriptor.getMembers().isPresent()) {
            Set<Member> members = descriptor.getMembers().get();
            if (members.isEmpty()) {
                sb.append(PREFIX_MEMBER);
            } else {
                members.forEach(s -> sb.append(PREFIX_MEMBER).append(s.memberName).append(" "));
            }
        }
        return sb.toString();
    }
}
