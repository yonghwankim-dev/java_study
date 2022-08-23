package ch14.ex02_stream;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String name;
    private int ban;
    private int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]",name,ban,totalScore);
    }

    // 총점 내림차순을 기본정렬로 함
    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
