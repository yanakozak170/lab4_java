import java.util.*;

/**
 * Represents a single letter.
 */
class Letter {
    private char value;

    /**
     * Constructor for a letter.
     *
     * @param value the character value of the letter
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Gets the character value of the letter.
     *
     * @return the character value
     */
    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}