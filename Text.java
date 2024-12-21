import java.util.*;
/**
 * Represents a text composed of sentences.
 */
class Text {
    private List<Sentence> sentences;

    /**
     * Constructor for a text.
     *
     * @param text the string representation of the text
     */
    public Text(String text) {
        sentences = new ArrayList<>();
        String[] rawSentences = text.split("\\.");
        for (String rawSentence : rawSentences) {
            if (!rawSentence.trim().isEmpty()) {
                sentences.add(new Sentence(rawSentence.trim()));
            }
        }
    }

    /**
     * Gets the list of sentences in the text.
     *
     * @return the list of sentences
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Sentence sentence : sentences) {
            sb.append(sentence).append(". ");
        }
        return sb.toString().trim();
    }
}