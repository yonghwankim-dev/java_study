package other.enum_practice.lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int countOfMath;
    private final int winningMoney;

    Rank(int countOfMath, int winningMoney) {
        this.countOfMath = countOfMath;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMath() {
        return countOfMath;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMath, boolean matchBonus) {
        for (Rank rank : values()) {
            if (countOfMath == SECOND.countOfMath) {
                return matchBonus ? SECOND : THIRD;
            }

            if (rank.countOfMath == countOfMath) {
                return rank;
            }
        }
        return null;
    }
}
