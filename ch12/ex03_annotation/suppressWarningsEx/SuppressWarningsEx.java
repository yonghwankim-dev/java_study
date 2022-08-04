package ch12.ex03_annotation.suppressWarningsEx;

import java.util.ArrayList;

class NewClass{
    int newField;
    @Deprecated
    int oldField;

    public int getNewField() {
        return newField;
    }

    @Deprecated
    public int getOldField() {
        return oldField;
    }
}

public class SuppressWarningsEx {
    @SuppressWarnings("deprecation") // deprecation 관련 경고를 억제
    public static void main(String[] args) {
        NewClass newClass = new NewClass();

        newClass.oldField = 10;                     // @Deprecated가 붙은 대상을 사용
        System.out.println(newClass.getOldField()); // @Deprecated가 붙은 대상을 사용

        @SuppressWarnings("unchecked") // 지네릭스 관련 경고를 억제
        ArrayList<NewClass> list = new ArrayList(); // 타입을 지정하지 않음
        list.add(newClass);
    }
}
