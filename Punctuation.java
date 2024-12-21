/**
 * Represents a punctuation mark.
 */
class Punctuation {
    private char symbol;

    /**
     * Constructor for a punctuation mark.
     *
     * @param symbol the punctuation character
     */
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets the punctuation character.
     *
     * @return the punctuation character
     */
    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
