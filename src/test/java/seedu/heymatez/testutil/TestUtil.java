package seedu.heymatez.testutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import seedu.heymatez.commons.core.index.Index;
import seedu.heymatez.model.Model;
import seedu.heymatez.model.person.Person;
import seedu.heymatez.model.task.Task;

/**
 * A utility class for test cases.
 */
public class TestUtil {

    /**
     * Folder used for temp files created during testing. Ignored by Git.
     */
    private static final Path SANDBOX_FOLDER = Paths.get("src", "test", "data", "sandbox");

    /**
     * Appends {@code fileName} to the sandbox folder path and returns the resulting path.
     * Creates the sandbox folder if it doesn't exist.
     */
    public static Path getFilePathInSandboxFolder(String fileName) {
        try {
            Files.createDirectories(SANDBOX_FOLDER);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return SANDBOX_FOLDER.resolve(fileName);
    }

    /**
     * Returns the middle index of the person in the {@code model}'s person list.
     */
    public static Index getMidIndex(Model model) {
        return Index.fromOneBased(model.getFilteredPersonList().size() / 2);
    }

    /**
     * Returns the last index of the person in the {@code model}'s person list.
     */
    public static Index getLastIndex(Model model) {
        return Index.fromOneBased(model.getFilteredPersonList().size());
    }

    /**
     * Returns the person in the {@code model}'s person list at {@code index}.
     */
    public static Person getPerson(Model model, Index index) {
        return model.getFilteredPersonList().get(index.getZeroBased());
    }

    /**
     * Returns the middle index of the task in the {@code model}'s task list.
     */
    public static Index getTaskMidIndex(Model model) {
        return Index.fromOneBased(model.getFilteredTaskList().size() / 2);
    }

    /**
     * Returns the last index of the task in the {@code model}'s task list.
     */
    public static Index getTaskLastIndex(Model model) {
        return Index.fromOneBased(model.getFilteredTaskList().size());
    }

    /**
     * Returns the task in the {@code model}'s task list at {@code index}.
     */
    public static Task getTask(Model model, Index index) {
        return model.getFilteredTaskList().get(index.getZeroBased());
    }
}