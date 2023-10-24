package seedu.address.model.tag;

/**
 * An enum class that contains the priority levels LOW, MEDIUM, HIGH and NONE for no priority of a task.
 */
public enum Priority {
    /**
     * 3 levels for priority, and 1 level for no priority.
     */
    LOW, MEDIUM, HIGH, NONE;

    public static final String MESSAGE_CONSTRAINTS =
            "Priority should only be LOW, MEDIUM or HIGH, and it should not be blank";

    
    public static Priority of(String priority) throws IllegalArgumentException {
        switch (priority) {
        case "l":
        case "lo":
        case "lw":
        case "low":
            return Priority.LOW;
        case "m":
        case "me":
        case "med":
        case "mediu":
        case "medium":
            return Priority.MEDIUM;
        case "h":
        case "hi":
        case "hig":
        case "high":
            return Priority.HIGH;
        default:
            throw new IllegalArgumentException("Invalid Priority Value");
        }
    }
}
