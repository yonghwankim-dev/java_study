package ch12.ex03_annotation.overrideEx;

import java.lang.annotation.AnnotationTypeMismatchException;

import static org.assertj.core.api.Assertions.assertThat;

public class OverrideEx {
    static class Parent{
        void parentMethod(){}
    }
    static class Child extends Parent{
        // Parent 클래스의 parentMethod 메서드를 오버라이드하고자 하는데 오타가 발생함
        //@Override // 이상태에서 @Override 애노테이션을 적용하면 컴파일 오류가 발생함
        void parentmethod(){}
    }
}
