package jar;

public class Rule {
    private final boolean[] isNeg;
    private final String[] words;

    public Rule(boolean[] isNeg, String[] words) {
        this.isNeg = isNeg;
        this.words = words;
    }

    public boolean[] isNeg() {
        return isNeg;
    }

    public String[] getWords() {
        return words;
    }
}
