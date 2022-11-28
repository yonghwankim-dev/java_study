package other.optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Person {
    private String name;
    private int age;
    private University university;
}
