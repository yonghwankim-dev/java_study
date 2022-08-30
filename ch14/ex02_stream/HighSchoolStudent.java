package ch14.ex02_stream;

class HighSchoolStudent {
    private String name;        // 이름
    private boolean isMale;     // 성별, true : 남자, false : 여자
    private int hak;            // 학년
    private int ban;            // 반
    private int score;          // 점수

    enum LEVEL{
        HIGH, MID, LOW
    }

    public HighSchoolStudent(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]", name, isMale ? "남" : "여", hak, ban, score);
    }
}
