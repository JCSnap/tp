package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOTE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.NoteCommand;
import seedu.address.logic.parser.exceptions.IllegalArgumentException;
import seedu.address.logic.parser.exceptions.InvalidFormatException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.task.Note;


/**
 * Parses input arguments and creates a new NoteCommand object
 */
public class NoteCommandParser implements Parser<NoteCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public NoteCommand parse(String args) throws ParseException {
        try {
            ArgumentMultimap argMultimap =
                    ArgumentTokenizer.tokenize(args, PREFIX_NOTE);
            if (!argMultimap.getValue(PREFIX_NOTE).isPresent()) {
                throw new InvalidFormatException(
                        MESSAGE_INVALID_COMMAND_FORMAT,
                        NoteCommand.COMMAND_WORD,
                        NoteCommand.MESSAGE_USAGE);
            }
            argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NOTE);

            Note note = ParserUtil.parseNote(
                    argMultimap.getValue(PREFIX_NOTE).get());
            Index index = ParserUtil.parseIndex(argMultimap.getPreamble());
            return new NoteCommand(index, note);
        } catch (IllegalArgumentException pe) {
            throw new InvalidFormatException(
                    MESSAGE_INVALID_COMMAND_FORMAT,
                    NoteCommand.COMMAND_WORD,
                    NoteCommand.MESSAGE_USAGE,
                    pe);
        }
    }

}
