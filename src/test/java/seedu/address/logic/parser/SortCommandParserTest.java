package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.PREAMBLE_WHITESPACE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.sort.enums.SortOrderEnum;
import seedu.address.logic.sort.enums.SortTypeEnum;

public class SortCommandParserTest {
    private final SortCommandParser parser = new SortCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {
        assertParseSuccess(parser,
                PREAMBLE_WHITESPACE + " o/a ty/dl",
                new SortCommand(SortOrderEnum.ASCENDING, SortTypeEnum.DEADLINE));
    }

    @Test
    public void parse_repeatedNonTagValue_failure() {
        assertParseFailure(parser,
                PREAMBLE_WHITESPACE + " o/a o/dl",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.COMMAND_WORD)
                        + "\nUsage: "
                        + SortCommand.MESSAGE_USAGE
        );
    }

    @Test
    public void parse_compulsoryFieldMissing_failure() {
        assertParseFailure(parser,
                PREAMBLE_WHITESPACE + " o/a",
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.COMMAND_WORD)
                        + "\nUsage: "
                        + SortCommand.MESSAGE_USAGE
        );
    }

    @Test
    public void parse_invalidOrderValue_failure() {
        assertParseFailure(parser,
                PREAMBLE_WHITESPACE + " o/odhasoludhasuiodhiuashdas ty/dl",
                SortOrderEnum.MESSAGE_CONSTRAINTS + "odhasoludhasuiodhiuashdas!");
    }

    @Test
    public void parse_invalidTypeValue_failure() {
        assertParseFailure(parser,
                PREAMBLE_WHITESPACE + " o/a ty/daioshdoiashdihasoidha",
                SortTypeEnum.MESSAGE_CONSTRAINTS + "daioshdoiashdihasoidha!"
        );
    }
}
