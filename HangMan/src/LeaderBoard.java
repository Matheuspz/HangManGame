import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderBoard {
    private final List<PlayerScore> scores = new ArrayList<>();

    public void addScore(String name, int score) {
        scores.add(new PlayerScore(name,score));
        Collections.sort(scores);
    }
    public void showLeaderboard(int topN) {
        System.out.println("\n== Leaderboard ==");
        for(int i = 0; i < Math.min(topN, scores.size()); i++) {
            System.out.println((i+1) + ". " + scores.get(i));
        }
    }

}

