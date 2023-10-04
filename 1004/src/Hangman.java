import java.util.HashSet;
import java.util.Set;

class Hangman {

    private static final String[] WORDS = {
                "abjure", "future", "picnic", "agonistic", "garland", "protect", "airline", "gigantic", "publish", "bandit", "goofy", "quadrangle", "banquet", "government", "recount",
                "binoculars", "grandnieces", "redoubtable", "biologist", "handbook", "reflection", "blackboard", "himself", "reporter", "board", "indulge", "ring",
                "bookworm", "inflatable", "salesclerk", "butterscotch", "inimical", "snapshot", "camera", "interim", "shellfish", "campus", "invest", "ship", "catfish", "jackpot", "significance",
                "carsick", "kitchenette", "sometimes", "celebrate", "law", "sublime", "celery", "life", "tabletop", "citizen", "lifeline", "teamwork", "coloring", "love", "tennis",
                "compact", "magnificent", "timesaving", "dark", "malevolence", "tree", "damage", "man", "termination", "dangerous", "mascot", "underestimate", "decorum", "marshmallow", "vineyard",
                "endorse", "mine", "war", "engender", "moonwalk", "way", "erratic", "near", "wealth", "envelope", "nephogram", "wednesday", "etymology", "newborn", "world", "eyewitness", "noisome", "xerox",
                "eulogy", "owl", "you", "fish", "parenthesis", "zestful", "food", "perpetrator", "foreclose", "phone"};

    private static final int MAX_GUESSES = 7;

    /**
     * Starts the Hangman game.
     */
    static void playGame() {
        int numGuesses = MAX_GUESSES;
        String word = "";                     // Get random word.
        String board = initializeBoard(word); // Initialize the board.
        boolean hasGuessed = false;
        Set<Character> currentGuesses = new HashSet<>();
        do {
            // Print the current board.
            System.out.printf("%s\n", board);
            // Read the guess.
            char guess = readChar();
            // Determine if it's valid, and, if so, add it to the set of guesses.
            // Also update the board to contain the new guess.
            // If not, decrement guesses.
            if (isValidGuess(word, guess, currentGuesses)) {
                currentGuesses.add(guess);
                board = updateBoard(board, word, guess);
            } else {
                numGuesses--;
            }
            hasGuessed = hasGuessedWord(board);
        } while (numGuesses > 0);
    }

    /**
     * Returns a string containing only underscores, representing the board
     * for the given word.
     *
     * @param word - W
     * @return String containing |W| underscores.
     */
    private static String initializeBoard(String word) {
        // TODO.
        return null;
    }

    /**
     * Returns a random word from an array of words.
     *
     * @param words - array of words.
     * @return random word.
     */
    private static String chooseRandomWord(String[] words) {
        // TODO.
        return null;
    }

    /**
     * Reads a character from standard input; we read the value as a string,
     * then retrieve the first character.
     *
     * @return first char of input string.
     */
    private static char readChar() {
        // TODO.
        return '\0';
    }

    /**
     * Determines if a given character is a valid guess. A guess is valid if the letter
     * exists in the word and it hasn't been used yet.
     *
     * @param word - secret word.
     * @param guess - guessed character.
     * @param guesses - characters that we have guessed so far.
     * @return true if it's a valid guess and false otherwise.
     */
    private static boolean isValidGuess(String word, char guess, Set<Character> guesses) {
        // TODO.
        return false;
    }

    /**
     * Returns a new board containing the underscores substituted for
     * the guesses.
     *
     * @param oldBoard - old board.
     * @param word - secret word.
     * @param guess - current correct guess.
     * @return new string board.
     */
    private static String updateBoard(String oldBoard, String word, char guess) {
        // TODO.
        return null;
    }

    /**
     * Determines if we have fully guessed the word or not.
     *
     * @param board - String containing '_' and letters.
     * @return true if the board contains no '_' chars and false otherwise.
     */
    public static boolean hasGuessedWord(String board) {
        // TODO.
        return false;
    }

    public static void main(String[] args) {
        playGame();
    }
}
