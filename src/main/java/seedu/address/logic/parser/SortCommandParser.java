package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT_ORDER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SORT_TYPE;

import java.util.stream.Stream;

import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.parser.exceptions.InvalidFormatException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.sort.enums.SortOrderEnum;
import seedu.address.logic.sort.enums.SortTypeEnum;

/**
 * Parses input arguments and creates a new SortCommand object
 */
public class SortCommandParser implements Parser<SortCommand> {

    //@@author asdfghjkxd-reused
    // Reused with slight modification from AddCommandParser
    @Override
    public SortCommand parse(String userInput) throws ParseException {
        ArgumentMultimap argumentMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_SORT_ORDER, PREFIX_SORT_TYPE);

        if (!SortCommandParser.allPrefixPresent(argumentMultimap, PREFIX_SORT_ORDER, PREFIX_SORT_TYPE)
                || !argumentMultimap.getPreamble().isEmpty()) {
            throw new InvalidFormatException(
                    MESSAGE_INVALID_COMMAND_FORMAT,
                    SortCommand.COMMAND_WORD,
                    SortCommand.MESSAGE_USAGE
            );
        }

        argumentMultimap.verifyNoDuplicatePrefixesFor(PREFIX_SORT_ORDER, PREFIX_SORT_TYPE);
        SortOrderEnum sortOrder = ParserUtil.parseSortOrder(argumentMultimap.getValue(PREFIX_SORT_ORDER)
                .orElse(""));

        SortTypeEnum sortType = ParserUtil.parseSortType(argumentMultimap.getValue(PREFIX_SORT_TYPE)
                .orElse(""));

        return new SortCommand(sortOrder, sortType);
    }

    private static boolean allPrefixPresent(ArgumentMultimap argMap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(x -> argMap.getValue(x).isPresent());
    }
    //@@author
}
