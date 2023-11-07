package seedu.address.logic.sort.enums;

/**
 * Enum to represent the sorting order (ascending or descending) of the sort.
 */
public enum SortOrderEnum {
    ASCENDING("ascending"),
    DESCENDING("descending");

    public static final String MESSAGE_CONSTRAINTS = "Oh no! I cannot understand the sort order: ";
    private final String representation;

    SortOrderEnum(String representation) {
        this.representation = representation;
    }

    /**
     * Returns the relevant {@code SortOrderEnum} based on the String input.
     *
     * @param sortOrder String input to parse
     * @return {@code SortOrderEnum} object
     * @throws IllegalArgumentException if the input String is not a valid input String value
     */
    public static SortOrderEnum of(String sortOrder) {
        String strippedSortOrder = sortOrder.strip();

        switch (strippedSortOrder) {
        case "a":
        case "asc":
        case "ascending":
            return SortOrderEnum.ASCENDING;
        case "d":
        case "desc":
        case "descending":
            return SortOrderEnum.DESCENDING;
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
