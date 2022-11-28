package other.optional;

import java.util.Optional;

public class StudentRepository {
    public static Optional<Student> findById(Long studentId) {
        // 데이터베이스에 질의하여 studentId에 따른 Student 인스턴스를 반환하다고 가정합니다.
        return null;
    }

    public Student save(Student student) {
        // 데이터베이스에 student 인스턴스를 저장한다고 가정합니다.
        return null;
    }
}
