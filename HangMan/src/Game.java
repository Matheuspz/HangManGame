import java.util.Scanner;

public class Game {
    private final WordBank wordBank = new WordBank();
    private final LeaderBoard leaderBoard = new LeaderBoard();
    private final Scanner scanner = new Scanner(System.in);

    String wordToGuess = wordBank.getRandomWord();
    Player player = new Player(5,wordToGuess);



}
