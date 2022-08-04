package ch12.ex03_annotation.makeAnnotationEx;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111") // 유효하지 않은 애노테이션은 무시된다
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
public class AnnotationEx {
    public static void main(String[] args) {
        // AnnotationEx의 클래스 객체를 얻는다.
        Class<AnnotationEx> cls = AnnotationEx.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testedBy().hhmmss() = " + anno.testDate().hhmmss());

        for(String tool : anno.testTools()){
            System.out.println("testTools = " + tool);
        }
        System.out.println();

        // AnnotationEx 클래스에 적용된 모든 애노테이션을 가져ㅗㅁ
        Annotation[] annoArr = cls.getAnnotations();

        for(Annotation a : annoArr){
            System.out.println(a);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface TestInfo{
    int count() default 1;
    String testedBy();
    String[] testTools() default "JUnit";
    TestType testType() default TestType.FIRST;
    DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME) // 실행시에 사용가능하도록 지정
@interface DateTime{
    String yymmdd();
    String hhmmss();
}
enum TestType {FIRST, FINAL}