package seedu.heymatez.commons.util;

import static java.util.Objects.requireNonNull;
import static seedu.heymatez.commons.util.AppUtil.checkArgument;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * Helper functions for handling strings.
 */
public class StringUtil {

    public static final int VALID_INTEGER = 1;

    public static final int INVALID_INTEGER = 2;

    public static final int INVALID_INPUT = 3;

    /**
     * Returns true if the {@code sentence} contains the {@code word}.
     *   Ignores case, but a full word match is required.
     *   <br>examples:<pre>
     *       containsWordIgnoreCase("ABc def", "abc") == true
     *       containsWordIgnoreCase("ABc def", "DEF") == true
     *       containsWordIgnoreCase("ABc def", "AB") == false //not a full word match
     *       </pre>
     * @param sentence cannot be null
     * @param word cannot be null, cannot be empty, must be a single word
     */
    public static boolean containsWordIgnoreCase(String sentence, String word) {
        requireNonNull(sentence);
        requireNonNull(word);

        String preppedWord = word.trim();
        checkArgument(!preppedWord.isEmpty(), "Word parameter cannot be empty");
        checkArgument(preppedWord.split("\\s+").length == 1, "Word parameter should be a single word");

        String preppedSentence = sentence;
        String[] wordsInPreppedSentence = preppedSentence.split("\\s+");

        return Arrays.stream(wordsInPreppedSentence)
                .anyMatch(preppedWord::equalsIgnoreCase);
    }

    /**
     * Returns a detailed message of the t, including the stack trace.
     */
    public static String getDetails(Throwable t) {
        requireNonNull(t);
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return t.getMessage() + "\n" + sw.toString();
    }

    /**
     * Returns an integer (1) VALID if {@code s} represents a non-zero unsigned integer or
     * e.g. 1, 2, 3, ..., {@code Integer.MAX_VALUE} <br>
     * an integer (2) INVALID_INTEGER if {@code s} represents a non-positive integer.
     * e.g. 0, -1, -2, ..., {@code Integer.MIN_VALUE} <br>
     * Will return an integer (3) INVALID_INPUT for any other non-null string input
     * e.g. empty string, "-1", "0", "+1", and " 2 " (untrimmed), "3 0" (contains whitespace), "1 a" (contains letters)
     * @throws NullPointerException if {@code s} is null.
     */
    public static int checkIndexValidity(String s) {
        requireNonNull(s);

        try {
            int value = Integer.parseInt(s);
            if (value > 0 && !s.startsWith("+")) { // "+1" is successfully parsed by Integer#parseInt(String)
                return VALID_INTEGER;
            } else if (value <= 0) {
                return INVALID_INTEGER;
            }
            return INVALID_INPUT;
        } catch (NumberFormatException nfe) {
            return INVALID_INPUT;
        }
    }

}
