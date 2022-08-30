package ch14.ex02_stream;

class HighSchoolStudent {
    private String name;        // �̸�
    private boolean isMale;     // ����, true : ����, false : ����
    private int hak;            // �г�
    private int ban;            // ��
    private int score;          // ����

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
        return String.format("[%s, %s, %d�г� %d��, %3d��]", name, isMale ? "��" : "��", hak, ban, score);
    }
}
