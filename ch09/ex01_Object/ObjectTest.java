package ch09.ex01_Object;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class ObjectTest {
    @Test
    public void equalsTest() throws Exception{
        //given
        Person p1 = new Person("�Ͽ�ȯ",20);
        Person p2 = new Person("�Ͽ�ȯ",20);
        //when
        boolean actual = p1.equals(p2);
        p2 = p1;
        boolean actual2 = p1.equals(p2);
        //then
        assertThat(actual).isFalse();
        assertThat(actual2).isTrue();
    }

    @Test
    public void overrideEquals() throws Exception{
        //given
        Student s1 = new Student(1, "�Ͽ�ȯ");
        Student s2 = new Student(1, "�Ͽ�ȯ");
        //when
        boolean actual = s1.equals(s2);
        //then
        assertThat(actual).isTrue();
    }

    @Test
    public void hashCodeTest() throws Exception{
        //given
        String str1 = "1";
        String str2 = "1";
        //when
        boolean actual1 = str1.hashCode() == str2.hashCode();
        //then
        assertThat(actual1).isTrue();
    }

    @Test
    public void toStringTest() throws Exception{
        //given
        Student s1 = new Student(1, "�Ͽ�ȯ");

        //when
        String actual = s1.toString();
        //then
        System.out.println(actual);
        assertThat(actual).isEqualTo("stdNo=1, name=�Ͽ�ȯ");
    }

    @Test
    public void cloneTest() throws Exception{
        //given
        Point origin = new Point(3,5);

        //when
        Point copy = origin.clone();
        copy.x = 1;

        String actual1 = origin.toString();
        String actual2 = copy.toString();
        //then
        assertThat(actual1).isEqualTo("x = 3, y = 5");
        assertThat(actual2).isEqualTo("x = 1, y = 5");
    }

    @Test
    public void clone_array() throws Exception{
        //given
        int[] arr = {1,2,3,4,5};

        //when
        int[] copy = arr.clone();
        copy[0] = 6;
        //then
        assertThat(Arrays.toString(arr)).isEqualTo("[1, 2, 3, 4, 5]");
        assertThat(Arrays.toString(copy)).isEqualTo("[6, 2, 3, 4, 5]");
    }

    @Test
    public void shallow_copy() throws Exception{
        //given
        Circle c1 = new Circle(new Point(1,1),2.0);
        Circle c2 = c1;
        //when
        c2.p1.y = 2;
        //then
        assertThat(c1.p1.y).isEqualTo(2);
        assertThat(c2.p1.y).isEqualTo(2);
    }

    @Test
    public void deepCopy() throws Exception{
        //given
        Circle c = new Circle(new Point(1,1),2.0);
        //when
        Circle copy = c.deepCopy();
        copy.p1.y = 2;
        //then
        assertThat(c.p1.y).isEqualTo(1);
        assertThat(copy.p1.y).isEqualTo(2);

    }

    @Test
    public void getClassTest() throws Exception{
        //given
        Class cObj = new Person("���ȯ",20).getClass(); // ������ ��ü�κ��� ��� ���
        Class cObj2 = Person.class; // Ŭ���� ���ͷ�(.class)�κ��� ��� ���
        Class cObj3 = Class.forName("Person"); // Ŭ���� �̸����κ��� ��� ���
        //when

        //then
    }

    @Test
    public void getClassInstance() throws Exception{
        //given
        Person p = new Person("���ȯ", 20);
        Class cObj = p.getClass();
        //when
        System.out.println(p);
        System.out.println(cObj);
        System.out.println(cObj.getName());
        System.out.println(cObj.toGenericString());
        //then

    }
}
