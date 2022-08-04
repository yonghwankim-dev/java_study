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
    @SuppressWarnings("deprecation") // deprecation ���� ��� ����
    public static void main(String[] args) {
        NewClass newClass = new NewClass();

        newClass.oldField = 10;                     // @Deprecated�� ���� ����� ���
        System.out.println(newClass.getOldField()); // @Deprecated�� ���� ����� ���

        @SuppressWarnings("unchecked") // ���׸��� ���� ��� ����
        ArrayList<NewClass> list = new ArrayList(); // Ÿ���� �������� ����
        list.add(newClass);
    }
}
