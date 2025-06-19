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



}
