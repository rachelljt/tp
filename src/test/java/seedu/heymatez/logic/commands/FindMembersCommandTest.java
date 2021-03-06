package seedu.heymatez.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.heymatez.commons.core.Messages.MESSAGE_EMPTY_PERSON_LIST;
import static seedu.heymatez.commons.core.Messages.MESSAGE_PERSONS_LISTED_OVERVIEW;
import static seedu.heymatez.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.heymatez.testutil.TypicalPersons.BENSON;
import static seedu.heymatez.testutil.TypicalPersons.CARL;
import static seedu.heymatez.testutil.TypicalPersons.DANIEL;
import static seedu.heymatez.testutil.TypicalPersons.ELLE;
import static seedu.heymatez.testutil.TypicalPersons.FIONA;
import static seedu.heymatez.testutil.TypicalPersons.GEORGE;
import static seedu.heymatez.testutil.TypicalPersons.getTypicalHeyMatez;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.heymatez.model.Model;
import seedu.heymatez.model.ModelManager;
import seedu.heymatez.model.UserPrefs;
import seedu.heymatez.model.person.DetailsContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindMembersCommand}.
 */
public class FindMembersCommandTest {
    private Model model = new ModelManager(getTypicalHeyMatez(), new UserPrefs());
    private Model expectedModel = new ModelManager(getTypicalHeyMatez(), new UserPrefs());

    @Test
    public void equals() {
        DetailsContainsKeywordsPredicate firstPredicate =
                new DetailsContainsKeywordsPredicate(Collections.singletonList("first"));
        DetailsContainsKeywordsPredicate secondPredicate =
                new DetailsContainsKeywordsPredicate(Collections.singletonList("second"));

        FindMembersCommand findFirstCommand = new FindMembersCommand(firstPredicate);
        FindMembersCommand findSecondCommand = new FindMembersCommand(secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindMembersCommand findFirstCommandCopy = new FindMembersCommand(firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
        String expectedMessage = MESSAGE_EMPTY_PERSON_LIST;
        DetailsContainsKeywordsPredicate predicate = preparePredicate(" ");
        FindMembersCommand command = new FindMembersCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_PERSONS_LISTED_OVERVIEW, 6);
        DetailsContainsKeywordsPredicate predicate =
                preparePredicate("Kurz Elle Kunz 98765432 secretary anna@example.com");
        FindMembersCommand command = new FindMembersCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE), model.getFilteredPersonList());
    }

    @Test
    public void execute_multipleKeywords_noPersonsFound() {
        String expectedMessage = MESSAGE_EMPTY_PERSON_LIST;
        DetailsContainsKeywordsPredicate predicate =
                preparePredicate("Michelle Joelle Tim 98755432 vicePresident tim@example.com");
        FindMembersCommand command = new FindMembersCommand(predicate);
        expectedModel.updateFilteredPersonList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredPersonList());
    }

    /**
     * Parses {@code userInput} into a {@code DetailsContainsKeywordsPredicate}.
     */
    private DetailsContainsKeywordsPredicate preparePredicate(String userInput) {
        return new DetailsContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
