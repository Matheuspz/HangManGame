import java.util.Scanner;

public class Game {
    private final WordBank wordBank = new WordBank();
    private final LeaderBoard leaderBoard = new LeaderBoard();
    private final Scanner scanner = new Scanner(System.in);

    public void gameStart() {

        System.out.println("== HangMan Game ==");

        while(true) {
            System.out.print("\nWrite player name (or exit to leave): ");
            String playerName = scanner.nextLine().trim();

            if(playerName.equalsIgnoreCase("exit")){
                System.out.println("Ending Game");
                break;
            }

            String wordToGuess = wordBank.getRandomWord();
            Player player = new Player(5, wordToGuess);

            while (!player.isGameOver()) {
                System.out.println("\nWord: " + player.getMaskedWord());
                System.out.println("Wrong Guesses: " + player.getWrongGuesses());
                System.out.println("Lives Remaining: " + player.getRemainingLives());

                System.out.print("Write your guess: ");
                String input = scanner.nextLine().toLowerCase();
                if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                    System.out.println("\nInvalid guess, the guess needs to be a Single Letter");
                    continue;
                }

                char guess = input.charAt(0);
                if (player.guessLetter(guess)) {
                    System.out.println("\nGuess correct.");
                } else {
                    System.out.println("\nGuess Incorrect");
                }
            }

            if (player.isWordGuessed()) {
                System.out.println(playerName + " you won! The word was: " + wordToGuess);
            } else { System.out.println("Game End! The word was: " + wordToGuess); }

            int score = player.getRemainingLives();
            leaderBoard.addScore(playerName, score);
        }
        leaderBoard.showLeaderboard(10);

    }
}
