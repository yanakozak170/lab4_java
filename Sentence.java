import java.util.*;
/**
 * Represents a sentence composed of words and punctuation marks.
 */
class Sentence {
    private List<Object> elements; // Word or Punctuation

    /**
     * Constructor for a sentence.
     *
     * @param sentence the string representation of the sentence
     */
    public Sentence(String sentence) {
        elements = new ArrayList<>();
        String[] parts = sentence.split("(?<=[.,!?])|(?=[.,!?])|\s+");
        for (String part : parts) {
            if (part.matches("[,!?\\.]") && part.length() == 1) {
                elements.add(new Punctuation(part.charAt(0)));
            } else if (!part.trim().isEmpty()) {
                elements.add(new Word(part.trim()));
            }
        }
    }

    /**
     * Gets the list of elements (words and punctuation) in the sentence.
     *
     * @return the list of elements
     */
    public List<Object> getElements() {
        return elements;
    }

    /**
     * Gets the list of words in the sentence.
     *
     * @return the list of words
     */
    public List<Word> getWords() {
        List<Word> words = new ArrayList<>();
        for (Object element : elements) {
            if (element instanceof Word) {
                words.add((Word) element);
            }
        }
        return words;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Object element : elements) {
            if (element instanceof Punctuation) {
                sb.append(element);
            } else {
                sb.append(" ").append(element);
            }
        }
        return sb.toString().trim();
    }

    /**
     * Finds the maximum number of sentences containing common words.
     *
     * @param text the text object to analyze
     * @return the maximum number of sentences with common words
     */
    public static int findMaxSentencesWithCommonWords(Text text) {
        if (text == null || text.getSentences().isEmpty()) {
            throw new IllegalArgumentException("Текст не може бути порожнім або не містити речень.");
        }

        Map<String, Set<Integer>> wordToSentenceMap = new HashMap<>();

        List<Sentence> sentences = text.getSentences();

        for (int i = 0; i < sentences.size(); i++) {
            Sentence sentence = sentences.get(i);
            for (Word word : sentence.getWords()) {
                String lowerCaseWord = word.getWordStringBuffer().toString().toLowerCase().replaceAll("[^a-zA-Zа-яА-Яіїєґ0-9]", "");
                if (!lowerCaseWord.isEmpty()) {
                    wordToSentenceMap.computeIfAbsent(lowerCaseWord, k -> new HashSet<>()).add(i);
                }
            }
        }

        int maxSentencesWithCommonWords = 0;

        for (Set<Integer> sentenceIndices : wordToSentenceMap.values()) {
            if (sentenceIndices.size() > 1) { // Враховувати лише, якщо слово зустрічається більше ніж в одному реченні
                maxSentencesWithCommonWords = Math.max(maxSentencesWithCommonWords, sentenceIndices.size());
            }
        }

        return maxSentencesWithCommonWords;
    }
}