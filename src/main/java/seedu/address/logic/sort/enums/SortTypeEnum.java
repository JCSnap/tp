package seedu.address.logic.sort.enums;

/**
 * Enum to represent the field to sort by in the sort.
 */
public enum SortTypeEnum {
    TASK_DESCRIPTION("task description"),
    STATUS("status"),
    PRIORITY("priority"),
    DEADLINE("deadline");

    public static final String MESSAGE_CONSTRAINTS = "Oh no! I cannot understand the sort type: ";

    private final String representation;

    SortTypeEnum(String representation) {
        this.representation = representation;
    }

    /**
     * Returns the relevant {@code SortTypeEnum} based on the String input.
     *
     * @param sortType String input to parse
     * @return {@code SortTypeEnum} object
     * @throws IllegalArgumentException if the input String is not a valid input String value
     */
    public static SortTypeEnum of(String sortType) {
        String strippedSortType = sortType.strip();

        switch (strippedSortType) {
        case "t":
        case "td":
        case "task":
        case "tsk dsc":
        case "task description":
            return SortTypeEnum.TASK_DESCRIPTION;
        case "p":
        case "pr":
        case "pri":
        case "prior":
        case "priority":
            return SortTypeEnum.PRIORITY;
        case "d":
        case "dl":
        case "deadln":
        case "deadline":
            return SortTypeEnum.DEADLINE;
        case "s":
        case "st":
        case "stat":
        case "status":
            return SortTypeEnum.STATUS;
        default:
            throw new IllegalArgumentException("Invalid Enum value");
        }
    }

    /**
     * Converts the enum object to its String representation.
     *
     * @return String representation of Enum object
     */
    @Override
    public String toString() {
        return this.representation;
    }
}
