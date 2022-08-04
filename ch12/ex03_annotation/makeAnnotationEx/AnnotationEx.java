package ch12.ex03_annotation.makeAnnotationEx;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111") // ��ȿ���� ���� �ֳ����̼��� ���õȴ�
@TestInfo(testedBy = "aaa", testDate = @DateTime(yymmdd = "160101", hhmmss = "235959"))
public class AnnotationEx {
    public static void main(String[] args) {
        // AnnotationEx�� Ŭ���� ��ü�� ��´�.
        Class<AnnotationEx> cls = AnnotationEx.class;

        TestInfo anno = cls.getAnnotation(TestInfo.class);
        System.out.println("anno.testedBy() = " + anno.testedBy());
        System.out.println("anno.testDate().yymmdd() = " + anno.testDate().yymmdd());
        System.out.println("anno.testedBy().hhmmss() = " + anno.testDate().hhmmss());

        for(String tool : anno.testTools()){
            System.out.println("testTools = " + tool);
        }
        System.out.println();

        // AnnotationEx Ŭ������ ����� ��� �ֳ����̼��� �����Ǥ�
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

@Retention(RetentionPolicy.RUNTIME) // ����ÿ� ��밡���ϵ��� ����
@interface DateTime{
    String yymmdd();
    String hhmmss();
}
enum TestType {FIRST, FINAL}