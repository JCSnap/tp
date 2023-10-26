package seedu.address.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the note of the task.
 * Guarantees: details are present and not null, immutable.
 */
public class Note {
    public static final String MESSAGE_CONSTRAINTS =
            "Notes should only contain alphanumeric characters and spaces, and it should not be blank";

    /**
     * Regular expression string for validating input strings.
     * This regular expression matches any string composed of alphanumeric characters and/or spaces,
     * including an empty string. It ensures the input string does not start with a whitespace,
     * but allows for an empty string as a valid input.
     * <p>
     * Example of valid inputs: "", "Hello", "Hello World", "12345"
     * Example of invalid inputs: " Hello", "Hello!", "123!"
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum} ]*";

    public final String fullNote;

    /**
     * Constructs a {@code Note}.
     *
     * @param note A valid note.
     */
    public Note(String note) {
        requireNonNull(note);
        checkArgument(isValidNote(note), MESSAGE_CONSTRAINTS);
        fullNote = note;
    }

    /**
     * Returns true if a given string is a valid note.
     */
    public static boolean isValidNote(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return fullNote;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Note)) {
            return false;
        }

        Note otherNote = (Note) other;
        return fullNote.equals(otherNote.fullNote);
    }
}
