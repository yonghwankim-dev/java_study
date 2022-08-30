package ch14.ex02_stream;

import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

public class CollectGroupingByTest {

    private static HighSchoolStudent[] students;

    @BeforeClass
    public static void setup(){
            students = new HighSchoolStudent[]{
                    new HighSchoolStudent("나자바", true, 1, 1, 300),
                    new HighSchoolStudent("김지미", false, 1, 1, 250),
                    new HighSchoolStudent("김자바", true, 1, 1, 200),
                    new HighSchoolStudent("이지미", false, 1, 2, 150),
                    new HighSchoolStudent("남자바", true, 1, 2, 100),
                    new HighSchoolStudent("안지미", false, 1, 2, 50),
                    new HighSchoolStudent("황지미", true, 1, 3, 100),
                    new HighSchoolStudent("강지미", false, 1, 3, 150),
                    new HighSchoolStudent("이자바", true, 1, 3, 200),

                    new HighSchoolStudent("나자바", true, 2, 1, 300),
                    new HighSchoolStudent("김지미", false, 2, 1, 250),
                    new HighSchoolStudent("김자바", true, 2, 1, 200),
                    new HighSchoolStudent("이지미", false, 2, 2, 150),
                    new HighSchoolStudent("남자바", true, 2, 2, 100),
                    new HighSchoolStudent("안지미", false, 2, 2, 50),
                    new HighSchoolStudent("황지미", true, 2, 3, 100),
                    new HighSchoolStudent("강지미", false, 2, 3, 150),
                    new HighSchoolStudent("이자바", true, 2, 3, 200),
            };
    }

    // 학생들을 성별을 기준으로 나누는 테스트
    @Test
    public void partitioningBy() throws Exception{
        //given

        //when
        Map<Boolean, List<HighSchoolStudent>> stuBySex = Arrays.stream(students)
                                                               .collect(Collectors.partitioningBy(HighSchoolStudent::isMale));

        List<HighSchoolStudent> maleStudent = stuBySex.get(true);    // Map에서 남학생 목록을 얻는다.
        List<HighSchoolStudent> femaleStudent = stuBySex.get(false); // Map에서 여학생 목록을 얻는다.

        Map<Boolean, Long> stuNumBySex = Arrays.stream(students)
                                               .collect(Collectors.partitioningBy(HighSchoolStudent::isMale,
                                                                                  counting()));
        long maleNum = stuNumBySex.get(true);
        long femaleNum = stuNumBySex.get(false);
        //then
        assertThat(maleStudent.size()).isEqualTo(10);
        assertThat(femaleStudent.size()).isEqualTo(8);
        assertThat(maleNum).isEqualTo(10);
        assertThat(femaleNum).isEqualTo(8);
    }

    // 남학생 1등과 여학생 1등을 구하는 테스트
    @Test
    public void partitioningBy_max() throws Exception{
        //given

        //when
        Map<Boolean, Optional<HighSchoolStudent>> topScoreBySex = Arrays.stream(students)
                .collect(Collectors.partitioningBy(HighSchoolStudent::isMale,
                                                   maxBy(Comparator.comparingInt(HighSchoolStudent::getScore))));
        Optional<HighSchoolStudent> topMaleStudent = topScoreBySex.get(true);
        Optional<HighSchoolStudent> topFemaleStudent = topScoreBySex.get(false);

        Map<Boolean, HighSchoolStudent> topScore2BySex = Arrays.stream(students)
                .collect(Collectors.partitioningBy(HighSchoolStudent::isMale,
                        collectingAndThen(maxBy(Comparator.comparingInt(HighSchoolStudent::getScore)),
                                                     Optional::get)));

        HighSchoolStudent topMaleStudent2   = topScore2BySex.get(true);
        HighSchoolStudent topFemaleStudent2 = topScore2BySex.get(false);
        //then
        assertThat(topMaleStudent.get().toString()).isEqualTo("[나자바, 남, 1학년 1반, 300점]");
        assertThat(topFemaleStudent.get().toString()).isEqualTo("[김지미, 여, 1학년 1반, 250점]");
        assertThat(topMaleStudent2.toString()).isEqualTo("[나자바, 남, 1학년 1반, 300점]");
        assertThat(topFemaleStudent2.toString()).isEqualTo("[김지미, 여, 1학년 1반, 250점]");
    }
    
    // 남녀를 구분하고 점수가 150점 미만인 사람들 테스트
    @Test
    public void partitioningBy_score() throws Exception{
        //given
        
        //when
        Map<Boolean, Map<Boolean, List<HighSchoolStudent>>> failedStuBySex = Arrays.stream(students)
                .collect(Collectors.partitioningBy(HighSchoolStudent::isMale,
                        Collectors.partitioningBy(s->s.getScore() < 150)));

        List<HighSchoolStudent> failedMaleStu   = failedStuBySex.get(true).get(true);
        List<HighSchoolStudent> failedFemaleStu = failedStuBySex.get(false).get(false);

        //then
        assertThat(failedMaleStu.size()).isEqualTo(4);
        assertThat(failedFemaleStu.size()).isEqualTo(6);
    }

    // 반별로 그룹핑
    @Test
    public void groupingBy_ban_hak() throws Exception{
        //given

        //when
        Map<Integer, List<HighSchoolStudent>> stuByBan1 = Arrays.stream(students)
                .collect(groupingBy(HighSchoolStudent::getBan)); // 기본적으로 toList()화함
        Map<Integer, List<HighSchoolStudent>> stuByBan2 = Arrays.stream(students)
                .collect(groupingBy(HighSchoolStudent::getBan, toList()));
        Map<Integer, HashSet<HighSchoolStudent>> stuByHak = Arrays.stream(students)
                .collect(groupingBy(HighSchoolStudent::getHak, toCollection(HashSet::new)));
        //then
        assertThat(stuByBan1.get(1).size()).isEqualTo(6);
        assertThat(stuByBan1.get(2).size()).isEqualTo(6);
        assertThat(stuByBan1.get(3).size()).isEqualTo(6);
        assertThat(stuByBan2.get(1).size()).isEqualTo(6);
        assertThat(stuByBan2.get(2).size()).isEqualTo(6);
        assertThat(stuByBan2.get(3).size()).isEqualTo(6);
        assertThat(stuByHak.get(1).size()).isEqualTo(9);
        assertThat(stuByHak.get(2).size()).isEqualTo(9);
    }

    // 성적의 등급별로 그룹핑
    @Test
    public void groupingByScore() throws Exception{
        //given

        //when
        Map<HighSchoolStudent.LEVEL, Long> stuByLevel = Arrays.stream(students)
                .collect(groupingBy(s->{
                    if(s.getScore() >= 200){
                        return HighSchoolStudent.LEVEL.HIGH;
                    }else if(s.getScore() >= 100){
                        return HighSchoolStudent.LEVEL.MID;
                    }else{
                        return HighSchoolStudent.LEVEL.LOW;
                    }
                }, counting()));

        Long HighStuNum = stuByLevel.get(HighSchoolStudent.LEVEL.HIGH);
        Long MidStuNum = stuByLevel.get(HighSchoolStudent.LEVEL.MID);
        Long LowStuNum = stuByLevel.get(HighSchoolStudent.LEVEL.LOW);
        //then
        assertThat(HighStuNum).isEqualTo(8);
        assertThat(MidStuNum).isEqualTo(8);
        assertThat(LowStuNum).isEqualTo(2);
    }

    // 학년별로 그룹화 한후에 다시 반별로 그룹핑
    @Test
    public void groupingByHakThanBan() throws Exception{
        //given

        //when
        Map<Integer, Map<Integer, List<HighSchoolStudent>>> stuByHakAndBan = Arrays.stream(students)
                .collect(groupingBy(HighSchoolStudent::getHak, groupingBy(HighSchoolStudent::getBan)));

        //then
        assertThat(stuByHakAndBan.get(1).get(1)).isEqualTo(3);
    }

    // 학년별로 그룹화 한후에 다시 반별로 그룹화, 그리고 각 반의 1등을 구함
    @Test
    public void groupingByHakThanBan_maxByScore() throws Exception{
        //given

        //when
        Map<Integer, Map<Integer, HighSchoolStudent>> stuByHakAndBan = Arrays.stream(students)
                .collect(groupingBy(HighSchoolStudent::getHak,
                         groupingBy(HighSchoolStudent::getBan,
                                 collectingAndThen(
                                         maxBy(Comparator.comparingInt(HighSchoolStudent::getScore)),
                                         Optional::get
                                 )
                         )
                ));
        //then
        assertThat(stuByHakAndBan.get(1).get(1).getName()).isEqualTo("나자바");
    }

    // 학년별/반별로 그룹화 한다음에 성적그룹으로 변환
    @Test
    public void groupingByHakThenBanToSetLevel() throws Exception{
        //given

        //when
        Map<Integer, Map<Integer, Set<HighSchoolStudent.LEVEL>>> stuByHakAndBan = Arrays.stream(students)
                .collect(groupingBy(HighSchoolStudent::getHak,
                        groupingBy(HighSchoolStudent::getBan,
                                mapping(s->{
                                    if(s.getScore() >= 200){
                                        return HighSchoolStudent.LEVEL.HIGH;
                                    }else if(s.getScore() >= 100){
                                        return HighSchoolStudent.LEVEL.MID;
                                    }else{
                                        return HighSchoolStudent.LEVEL.LOW;
                                    }
                                }, toSet()))));
        //then
        assertThat(stuByHakAndBan.get(1).get(1).toString()).isEqualTo("[HIGH]");
        assertThat(stuByHakAndBan.get(2).get(1).toString()).isEqualTo("[HIGH]");
        assertThat(stuByHakAndBan.get(1).get(2).toString()).isEqualTo("[LOW, MID]");
        assertThat(stuByHakAndBan.get(2).get(2).toString()).isEqualTo("[LOW, MID]");
        assertThat(stuByHakAndBan.get(1).get(3).toString()).isEqualTo("[HIGH, MID]");
        assertThat(stuByHakAndBan.get(2).get(3).toString()).isEqualTo("[HIGH, MID]");
    }
}
