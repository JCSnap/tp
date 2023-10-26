package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.IllegalArgumentException;
import seedu.address.logic.sort.enums.SortOrderEnum;
import seedu.address.logic.sort.enums.SortTypeEnum;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Description;
import seedu.address.model.task.Note;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "The index you enter in should be a positive number "
            + "starting from 1!";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     *
     * @throws IllegalArgumentException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws IllegalArgumentException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new IllegalArgumentException(MESSAGE_INVALID_INDEX);
        }

        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String description} into a {@code Description}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalArgumentException if the given {@code description} is invalid.
     */
    public static Description parseDescription(String description) throws IllegalArgumentException {
        requireNonNull(description);
        String trimmedDescription = description.trim();
        if (!Description.isValidDescription(trimmedDescription)) {
            throw new IllegalArgumentException(Description.MESSAGE_CONSTRAINTS);
        }
        return new Description(trimmedDescription);
    }

    /**
     * Parses a {@code String note} into a {@code Note}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalArgumentException if the given {@code note} is invalid.
     */
    public static Note parseNote(String note) throws IllegalArgumentException {
        requireNonNull(note);
        String trimmedNote = note.trim();
        if (!seedu.address.model.task.Note.isValidNote(trimmedNote)) {
            throw new IllegalArgumentException(seedu.address.model.task.Note.MESSAGE_CONSTRAINTS);
        }
        return new Note(trimmedNote);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws IllegalArgumentException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws IllegalArgumentException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new IllegalArgumentException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws IllegalArgumentException {
        requireNonNull(tags);

        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }

        return tagSet;
    }

    /**
     * Parses {@code String} into a {@code SortOrderEnum}
     * @param enumValue String enum value to parse
     * @return Parsed {@code SortOrderEnum} value
     */
    public static SortOrderEnum parseSortOrder(String enumValue) throws IllegalArgumentException {
        try {
            return SortOrderEnum.of(enumValue);
        } catch (java.lang.IllegalArgumentException exception) {
            throw new IllegalArgumentException(SortOrderEnum.MESSAGE_CONSTRAINTS + enumValue + "!");
        }
    }

    /**
     * Parses {@code String} into a {@code SortTypeEnum}
     * @param enumValue String enum value to parse
     * @return Parsed {@code SortTypeEnum} value
     */
    public static SortTypeEnum parseSortType(String enumValue) throws IllegalArgumentException {
        try {
            return SortTypeEnum.of(enumValue);
        } catch (java.lang.IllegalArgumentException exception) {
            throw new IllegalArgumentException(SortTypeEnum.MESSAGE_CONSTRAINTS + enumValue + "!");
        }
    }
}
