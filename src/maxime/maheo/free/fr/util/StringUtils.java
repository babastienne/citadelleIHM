package maxime.maheo.free.fr.util;

/**
 * Interface to generate random numbers.
 */
public final class StringUtils {

    /**
     * Constructor.
     */
    private StringUtils() {
        //do nothing
    }

    /**
     * Check if the string is numeric.
     *
     * @param string the string to test
     * @return if the string is numeric
     */
    public static boolean isNumeric(final String string) {
        return string.matches("[0-9]+");
    }

    /**
     * Check if the string is alphabet.
     *
     * @param string the string to test
     * @return if the string is alphabet
     */
    public static boolean isAlphabet(final String string) {
        return string.matches("[a-z-A-Z]+");
    }

}
