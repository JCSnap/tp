package seedu.address.logic.sort.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class SortOrderEnumTest {
    @Test
    public void of_validAscending_success() {
        assertEquals(SortOrderEnum.of("a"), SortOrderEnum.ASCENDING);
        assertEquals(SortOrderEnum.of("asc"), SortOrderEnum.ASCENDING);
        assertEquals(SortOrderEnum.of("ascending"), SortOrderEnum.ASCENDING);
    }

    @Test
    public void of_validDescending_success() {
        assertEquals(SortOrderEnum.of("d"), SortOrderEnum.DESCENDING);
        assertEquals(SortOrderEnum.of("desc"), SortOrderEnum.DESCENDING);
        assertEquals(SortOrderEnum.of("descending"), SortOrderEnum.DESCENDING);
    }

    @Test
    public void of_invalidAscending_failure() {
        assertThrows(IllegalArgumentException.class, () -> SortOrderEnum.of("ascendinggggggggg"));
    }

    @Test
    public void of_invalidDescending_failure() {
        assertThrows(IllegalArgumentException.class, () -> SortOrderEnum.of("descendingggggggg"));
    }

    @Test
    public void toString_ascending_success() {
        assertEquals(SortOrderEnum.ASCENDING.toString(), "ascending");
    }

    @Test
    public void toString_descending_success() {
        assertEquals(SortOrderEnum.DESCENDING.toString(), "descending");
    }
}
