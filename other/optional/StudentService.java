package other.optional;

public class StudentService {
    private StudentRepository studentRepository;

    // wrong
//    public Student findById(Long studentId){
//        return studentRepository.findById(studentId).orElse(createStudentWithId(studentId));
//    }

    // right
    public Student findById(Long studentId){
        return studentRepository.findById(studentId).orElseGet(()->createStudentWithId(studentId));
    }

    private Student createStudentWithId(Long studentId){
        Student student = new Student(studentId, "anonymous");
        return studentRepository.save(student);
    }
}
