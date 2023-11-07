package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEMBER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRIORITY;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.InvalidFormatException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.tag.Member;
import seedu.address.model.task.Description;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DESCRIPTION, PREFIX_PRIORITY, PREFIX_DEADLINE, PREFIX_MEMBER);


        // Only description is the compulsory field to be parsed
        if (!arePrefixesPresent(argMultimap, PREFIX_DESCRIPTION)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new InvalidFormatException(
                    MESSAGE_INVALID_COMMAND_FORMAT,
                    AddCommand.COMMAND_WORD,
                    AddCommand.MESSAGE_USAGE);
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_DESCRIPTION, PREFIX_DEADLINE);
        Description description = ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get());

        AddCommand.AddTaskDescriptor addTaskDescriptor = new AddCommand.AddTaskDescriptor();

        addTaskDescriptor.setDescription(description);
        if (argMultimap.getValue(PREFIX_DEADLINE).isPresent()) {
            addTaskDescriptor.setDeadline(ParserUtil.parseDeadline(argMultimap
                    .getValue(PREFIX_DEADLINE).get()));
        }
        if (argMultimap.getValue(PREFIX_PRIORITY).isPresent()) {
            addTaskDescriptor.setPriority(ParserUtil.parsePriority(argMultimap
                    .getValue(PREFIX_PRIORITY).get()));
        }
        if (argMultimap.getValue(PREFIX_MEMBER).isPresent()) {
            addTaskDescriptor.setMembers(ParserUtil.parseMembers(argMultimap
                    .getAllValues(PREFIX_MEMBER)));
        }

        parseMembersForEdit(argMultimap.getAllValues(PREFIX_MEMBER)).ifPresent(addTaskDescriptor::setMembers);

        return new AddCommand(addTaskDescriptor);
    }

    /**
     * Parses {@code Collection<String> members} into a {@code Set<Member>} if {@code members} is non-empty.
     * If {@code members} contain only one element which is an empty string, it will be parsed into a
     * {@code Set<Member>} containing zero Members.
     */
    private Optional<Set<Member>> parseMembersForEdit(Collection<String> members) throws ParseException {
        requireNonNull(members);

        if (members.isEmpty()) {
            return Optional.empty();
        }

        Collection<String> memberSet = members.size() == 1 && members.contains("") ? Collections.emptySet() : members;
        return Optional.of(ParserUtil.parseMembers(memberSet));
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
