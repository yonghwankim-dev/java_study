package ch12.ex03_annotation.overrideEx;

import java.lang.annotation.AnnotationTypeMismatchException;

import static org.assertj.core.api.Assertions.assertThat;

public class OverrideEx {
    static class Parent{
        void parentMethod(){}
    }
    static class Child extends Parent{
        // Parent Ŭ������ parentMethod �޼��带 �������̵��ϰ��� �ϴµ� ��Ÿ�� �߻���
        //@Override // �̻��¿��� @Override �ֳ����̼��� �����ϸ� ������ ������ �߻���
        void parentmethod(){}
    }
}
