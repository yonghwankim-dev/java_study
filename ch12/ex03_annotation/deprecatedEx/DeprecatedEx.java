package ch12.ex03_annotation.deprecatedEx;

import static org.assertj.core.api.Assertions.*;

public class DeprecatedEx {
    static class NewClass{
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

    public static void main(String[] args){

        //given
        NewClass newClass = new NewClass();

        //when
        newClass.oldField = 10;

        //then
        assertThat(newClass.getOldField()).isEqualTo(10);
    }

}
