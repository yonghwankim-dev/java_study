package other.optional;

import ch07.ex_24_interface.Unit;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class PersonTest {
    // avoid
//    public String getStudentId(Person person){
//        return person.getUniversity().getStudentId();
//    }

    // PREFER
    public String getStudentId(Person person){
        return Optional.ofNullable(person)
                        .map(Person::getUniversity)
                        .map(University::getStudentId)
                        .orElse("student is null");
    }

    @Test
    public void testGetStudentId(){
        //given
        Person person1 = new Person("kim", 20, new University("A대", 1, "std1"));
        Person person2 = null;
        Person person3 = new Person("lee", 21, null);
        Person person4 = new Person("park", 20, new University("A대", 1, null));
        //when
        String actual1 = getStudentId(person1);
        String actual2 = getStudentId(person2);
        String actual3 = getStudentId(person3);
        String actual4 = getStudentId(person4);
        //then
        assertThat(actual1).isEqualTo("std1");
        assertThat(actual2).isEqualTo("student is null");
        assertThat(actual3).isEqualTo("student is null");
        assertThat(actual4).isEqualTo("student is null");
    }

    @Test
    public void testOptionalEmpty(){
        //given
        Optional<Student> emptyPerson = Optional.empty();
        //when
        boolean actual = emptyPerson.isPresent();
        //then
        assertThat(actual).isFalse();
    }

    @Test
    public void testOptionalOf(){
        //given
        Student std1 = new Student(1L, "김용환");
        //when
        Optional<Student> optionalStudent = Optional.of(std1);
        Student actual = optionalStudent.get();
        //then
        assertThat(actual.getName()).isEqualTo("김용환");
    }

    @Test(expected = NullPointerException.class)
    public void testOptionalOf_whenStudentIsNull(){
        //given
        Student std1 = null;
        //when
        Optional<Student> optionalStudent = Optional.of(std1);
        //then
        fail("NullPointerException이 발생해야 합니다.");
    }
    
    @Test
    public void testOptionalOfNullable(){
        //given
        Student std1 = null;
        //when
        Optional<Student> optionalStudent = Optional.ofNullable(std1);
        Student student = optionalStudent.orElse(new Student(0L, "미정"));
        //then
        assertThat(student.getName()).isEqualTo("미정");
    }

    @Test
    public void testOrElse(){
        //given
        String name = "yonghwan";
        Optional<String> optionalStudent = Optional.ofNullable(name);
        //when
        String actual = optionalStudent.orElse(getDefaultName());
        //then
        System.out.println(actual);
        assertThat(actual).isEqualTo("yonghwan");
    }

    @Test
    public void testOrElseGet(){
        //given
        String name = "yonghwan";
        Optional<String> optionalStudent = Optional.ofNullable(name);
        //when
        String actual = optionalStudent.orElseGet(()->getDefaultName());
        //then
        System.out.println(actual);
        assertThat(actual).isEqualTo("yonghwan");
    }

    private String getDefaultName(){
        System.out.println("call getDefaultName()");
        return "anonymous";
    }

}