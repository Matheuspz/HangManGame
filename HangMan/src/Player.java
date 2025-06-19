import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private final String wordToGuess;
    private final int lives;
    private final Set<Character> correctGuess = new HashSet<>();
    private final Set<Character> incorrectGuess = new HashSet<>();

    public Player(int lives, String wordToGuess) {
        this.lives = lives;
        this.wordToGuess = wordToGuess.toLowerCase();
    }

    public boolean guessLetter(Character guess) {
        if (correctGuess.contains(guess) || incorrectGuess.contains(guess)) {
            System.out.println("Letter already guessed");
            return true;
        }

        if (wordToGuess.indexOf(guess) >= 0) {
            correctGuess.add(guess);
            return true;
        }
        incorrectGuess.add(guess);
        return false;
    }

    public String getMaskedWord() {
        StringBuilder masked = new StringBuilder();
        for (char c : wordToGuess.toCharArray()) {
            masked.append(correctGuess.contains(c) ? c : '_').append(' ');
        }
        return masked.toString().trim();
    }

    public Set<Character> getWrongGuesses() {
        return Collections.unmodifiableSet(incorrectGuess);
    }

    public int getRemainingLives() {
        return lives - incorrectGuess.size();
    }

    public boolean isWordGuessed() {
        for(char c : wordToGuess.toCharArray()) {
            if(!correctGuess.contains(c)) return false;
        }
        return true;
    }

    public boolean isGameOver() {
        return isWordGuessed() || getRemainingLives() < 0;
    }


}
