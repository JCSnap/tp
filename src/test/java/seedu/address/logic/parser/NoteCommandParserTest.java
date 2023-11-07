package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.NoteCommand;
import seedu.address.model.task.Note;

public class NoteCommandParserTest {

    private NoteCommandParser parser = new NoteCommandParser();

    @Test
    public void parse_validArgs_returnsNoteCommand() {
        assertParseSuccess(parser, "1 n/Valid Note", new NoteCommand(INDEX_FIRST_TASK, new Note("Valid Note")));
    }

    @Test
    public void parse_invalidArgs_throwsInvalidFormatException() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                NoteCommand.COMMAND_WORD) + "\nUsage: " + NoteCommand.MESSAGE_USAGE;

        // invalid index
        assertParseFailure(parser, "a n/Valid Note", expectedMessage);

        // without note prefix
        assertParseFailure(parser, "1 Valid Note", expectedMessage);

        // no arguments
        assertParseFailure(parser, "", expectedMessage);
    }
}
