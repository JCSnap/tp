package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.logic.parser.ParserUtil.parseDeadline;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.IllegalArgumentException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Deadline;
import seedu.address.model.task.Description;
import seedu.address.model.task.Note;
import seedu.address.model.task.Priority;

public class ParserUtilTest {
    private static final String INVALID_DESCRIPTION = "Do Use/r Guide.";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_DESCRIPTION = "Do User Guide";
    private static final String VALID_NOTE = "This is a valid note";
    private static final String INVALID_NOTE = "Do TaskWise v1/2"; // contains "/"
    private static final String VALID_TAG_1 = "friend";
    private static final String VALID_TAG_2 = "neighbour";

    private static final String WHITESPACE = " \t\r\n";
    private static final String VALID_DEADLINE_WITH_TIME = "25-10-2023 16:00";
    private static final String VALID_DEADLINE_WITHOUT_TIME = "25-10-2023";
    private static final String INVALID_DAY_INPUT = "9-10-2023 16:00";
    private static final String INVALID_MONTH_INPUT = "19-9-2023 16:00";
    private static final String INVALID_DAY_DEADLINE = "32-10-2023 16:00";
    private static final String INVALID_MONTH_DEADLINE = "25-13-2023 16:00";
    private static final String INVALID_YEAR_DEADLINE = "32-10-10000 16:00";

    private static final String INVALID_DAY_INPUT_NO_TIME = "9-10-2023";
    private static final String INVALID_MONTH_INPUT_NO_TIME = "19-9-2023";
    private static final String INVALID_DAY_DEADLINE_NO_TIME = "32-10-2023";
    private static final String INVALID_MONTH_DEADLINE_NO_TIME = "25-13-2023";
    private static final String INVALID_YEAR_DEADLINE_NO_TIME = "32-10-10000";
    private static final String VALID_PRIORITY = "high";
    private static final String INVALID_PRIORITY = "hiiii";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
            -> ParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_outOfRangeNegativeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
                -> ParserUtil.parseIndex(Long.toString(Integer.MIN_VALUE)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_TASK, ParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_TASK, ParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseDescription((String) null));
    }

    @Test
    public void parseName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseDescription(INVALID_DESCRIPTION));
    }

    @Test
    public void parseName_normalValid_throwsParseException() throws Exception {
        Description expectedName = new Description("this is valid");
        assertEquals(ParserUtil.parseDescription("this is valid"), expectedName);
    }

    @Test
    public void parseName_validValueWithoutWhitespace_returnsName() throws Exception {
        Description expectedName = new Description(VALID_DESCRIPTION);
        assertEquals(expectedName, ParserUtil.parseDescription(VALID_DESCRIPTION));
    }

    @Test
    public void parseName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_DESCRIPTION + WHITESPACE;
        Description expectedName = new Description(VALID_DESCRIPTION);
        assertEquals(expectedName, ParserUtil.parseDescription(nameWithWhitespace));
    }

    @Test
    public void parseNote_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseNote(null));
    }

    @Test
    public void parseNote_invalidValue_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> ParserUtil.parseNote(INVALID_NOTE));
    }

    @Test
    public void parseNote_validValueWithoutWhitespace_returnsNote() throws Exception {
        Note expectedNote = new Note(VALID_NOTE);
        assertEquals(expectedNote, ParserUtil.parseNote(VALID_NOTE));
    }

    @Test
    public void parseNote_validValueWithWhitespace_returnsTrimmedNote() throws Exception {
        String noteWithWhitespace = WHITESPACE + VALID_NOTE + WHITESPACE;
        Note expectedNote = new Note(VALID_NOTE);
        assertEquals(expectedNote, ParserUtil.parseNote(noteWithWhitespace));
    }

    @Test
    public void parseTag_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTag(null));
    }

    @Test
    public void parseTag_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTag(INVALID_TAG));
    }

    @Test
    public void parseTag_validValueWithoutWhitespace_returnsTag() throws Exception {
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(VALID_TAG_1));
    }

    @Test
    public void parseTag_validValueWithWhitespace_returnsTrimmedTag() throws Exception {
        String tagWithWhitespace = WHITESPACE + VALID_TAG_1 + WHITESPACE;
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(tagWithWhitespace));
    }

    @Test
    public void parseTags_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTags(null));
    }

    @Test
    public void parseTags_collectionWithInvalidTags_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, INVALID_TAG)));
    }

    @Test
    public void parseTags_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parseTags(Collections.emptyList()).isEmpty());
    }

    @Test
    public void parseTags_collectionWithValidTags_returnsTagSet() throws Exception {
        Set<Tag> actualTagSet = ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, VALID_TAG_2));
        Set<Tag> expectedTagSet = new HashSet<Tag>(Arrays.asList(new Tag(VALID_TAG_1), new Tag(VALID_TAG_2)));

        assertEquals(expectedTagSet, actualTagSet);
    }

    @Test
    public void parseTags_collectionWithInvalidTags_returnsTagSet() {
        assertThrows(IllegalArgumentException.class, () -> ParserUtil.parseTags(
                Arrays.asList(INVALID_TAG, VALID_TAG_1)));
    }

    @Test
    public void parseTags_collectionwithMembersDuplicates_returnsTagSet() {
        assertDoesNotThrow(() -> ParserUtil.parseTags(
                Arrays.asList(VALID_TAG_1, VALID_TAG_1, VALID_TAG_1)));
    }

    @Test
    public void parseSortOrder_validSortOrder_valid() {
        assertDoesNotThrow(() -> ParserUtil.parseSortOrder("a"));
    }

    @Test
    public void parseSortOrder_invalidSortOrder_valid() {
        assertThrows(IllegalArgumentException.class, () -> ParserUtil.parseSortOrder("this is an error"));
    }

    @Test
    public void parseSortType_validSortOrder_valid() {
        assertDoesNotThrow(() -> ParserUtil.parseSortType("dl"));
    }

    @Test
    public void parseSortOrder_validSortOrders_valid() {
        assertThrows(IllegalArgumentException.class, () -> ParserUtil.parseSortType("this is an error"));
    }

    @Test
    public void parseDeadline_validValueWithTime_returnsDeadline() throws IllegalArgumentException {
        Deadline expectedDeadline = Deadline.of(LocalDateTime.of(2023, 10, 25, 16, 0));
        assertEquals(expectedDeadline, ParserUtil.parseDeadline(VALID_DEADLINE_WITH_TIME));
    }

    @Test
    public void parseDeadline_validValueWithoutTime_returnsDeadline() throws IllegalArgumentException {
        Deadline expectedDeadline = Deadline.of(LocalDateTime.of(2023, 10, 25, 0, 0));
        assertEquals(expectedDeadline, ParserUtil.parseDeadline(VALID_DEADLINE_WITHOUT_TIME));
    }

    @Test
    public void parseDeadline_invalidDay_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_DAY_DEADLINE));
    }

    @Test
    public void parseDeadline_invalidMonth_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_MONTH_DEADLINE));
    }

    @Test
    public void parseDeadline_invalidYear_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_YEAR_DEADLINE));
    }

    @Test
    public void parseDeadline_invalidDayInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_DAY_INPUT));
    }

    @Test
    public void parseDeadline_invalidMonthInput_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_MONTH_INPUT));
    }

    @Test
    public void parseDeadline_invalidDayNoTime_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_DAY_DEADLINE_NO_TIME));
    }

    @Test
    public void parseDeadline_invalidMonthNoTime_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_MONTH_DEADLINE_NO_TIME));
    }

    @Test
    public void parseDeadline_invalidYearNoTime_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_YEAR_DEADLINE_NO_TIME));
    }

    @Test
    public void parseDeadline_invalidDayInputNoTime_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_DAY_INPUT_NO_TIME));
    }
    @Test
    public void parseDeadline_invalidMonthInputNoTime_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> parseDeadline(INVALID_MONTH_INPUT_NO_TIME));
    }
    @Test
    public void parsePriority_validValue_success() throws Exception {
        assertEquals(Priority.HIGH, ParserUtil.parsePriority(VALID_PRIORITY));
    }
    @Test
    public void parsePriority_invalidValue_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> ParserUtil.parsePriority(INVALID_PRIORITY));
    }
}
