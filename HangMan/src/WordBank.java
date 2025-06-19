import java.util.*;

public class WordBank {
    private final Set<String> words = new HashSet<>();

    public WordBank() {
        words.add("Banana");
        words.add("Pineapple");
        words.add("Crab");
        words.add("House");
    };

    public void addWords(String... newWords) {
        words.addAll(Arrays.asList(newWords));
    };

    public String getRandomWord() {
        String[] arrayWords = words.toArray(new String[words.size()]);

        Random random = new Random();

        int randomNumber = random.nextInt(words.size());
        return arrayWords[randomNumber];
    }
}
