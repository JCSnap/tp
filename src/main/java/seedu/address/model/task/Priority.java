package seedu.address.model.task;

/**
 * An enum class that contains the priority levels LOW, MEDIUM, HIGH and NONE for no priority of a task.
 * Note that the enum does not need to implement the {@code Comparable<T>} interface, as enums are naturally
 * ordered in the order of declaration.
 */
public enum Priority {
    /**
     * 3 levels for priority, and 1 level for no priority.
     */
    NONE,
    LOW,
    MEDIUM,
    HIGH;

    public static final String MESSAGE_CONSTRAINTS =
            "Priority should only be LOW, MEDIUM or HIGH, and it should not be blank";

    /**
     * Returns the relevant {@code Priority} based on String input.
     * @param priority String input to parse
     * @return {@code Priority} object
     * @throws IllegalArgumentException if the String input is not a valid {@code Priority} value
     */
    public static Priority of(String priority) throws IllegalArgumentException {
        switch (priority.strip().toLowerCase()) {
        case "low":
            return Priority.LOW;
        case "medium":
            return Priority.MEDIUM;
        case "high":
            return Priority.HIGH;
        case "none":
            return Priority.NONE;
        default:
            throw new IllegalArgumentException("Invalid Priority Value: ");
        }
    }

    /**
     * Returns true if a given string is a valid priority.
     * @param priority String input to parse
     * @return boolean
     */
    public static boolean isValidPriority(String priority) {
        switch (priority.strip().toLowerCase()) {
        case "low":
        case "medium":
        case "high":
        case "none":
            return true;
        default:
            return false;
        }
    }
}
