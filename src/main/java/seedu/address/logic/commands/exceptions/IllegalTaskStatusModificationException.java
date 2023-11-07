package seedu.address.logic.commands.exceptions;

/**
 * Represents an error that arises when the user tries to mark or unmark a task that is already completed
 * or not completed.
 */
public class IllegalTaskStatusModificationException extends IllegalCommandException {
    public IllegalTaskStatusModificationException(String message) {
        super(message);
    }
}
