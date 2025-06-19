public class PlayerScore implements Comparable<PlayerScore>{
    private final String name;
    private final int score;

    PlayerScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(PlayerScore other) {
        return Integer.compare(other.score, this.score);
    }
    @Override
    public String toString() {
        return name + ": " + score;
    }
}
