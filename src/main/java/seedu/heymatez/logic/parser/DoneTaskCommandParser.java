package seedu.heymatez.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.heymatez.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.heymatez.commons.core.Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX;
import static seedu.heymatez.logic.parser.ParserUtil.MESSAGE_NON_POSITIVE_INDEX;

import seedu.heymatez.commons.core.index.Index;
import seedu.heymatez.logic.commands.DoneTaskCommand;
import seedu.heymatez.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DoneTaskCommand object
 */
public class DoneTaskCommandParser implements Parser<DoneTaskCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DoneTaskCommand
     * and returns an DoneTaskCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DoneTaskCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            if (pe.getMessage().equals(MESSAGE_NON_POSITIVE_INDEX)) {
                throw new ParseException(MESSAGE_INVALID_TASK_DISPLAYED_INDEX, pe);
            }
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    DoneTaskCommand.MESSAGE_USAGE), pe);
        }

        return new DoneTaskCommand(index);
    }


}
