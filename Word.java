import java.util.*;
/**
 * Represents a word composed of letters.
 */
class Word {
    private List<Letter> letters;

    /**
     * Constructor for a word.
     *
     * @param word the string representation of the word
     */
    public Word(String word) {
        letters = new ArrayList<>();
        for (char ch : word.toCharArray()) {
            letters.add(new Letter(ch));
        }
    }

    /**
     * Gets the list of letters that make up the word.
     *
     * @return the list of letters
     */
    public List<Letter> getLetters() {
        return letters;
    }

    /**
     * Converts the word into a StringBuffer representation.
     *
     * @return the StringBuffer representation of the word
     */
    public StringBuffer getWordStringBuffer() {
        StringBuffer sb = new StringBuffer();
        for (Letter letter : letters) {
            sb.append(letter.getValue());
        }
        return sb;
    }

    @Override
    public String toString() {
        return getWordStringBuffer().toString();
    }
}