package pl.filipwlodarczyk.SPRINGSECURITY.student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RequestMapping("api/v1/students")
@RestController
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(0L, "Filip"),
            new Student(1L, "Artur"),
            new Student(2L, "Zbigniew"),
            new Student(3L, "Marcin"),
            new Student(4L, "Maciek")

    );

    @GetMapping
    public List<Student> getStudents() {
        return STUDENTS;
    }


    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId) {
        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalStateException("Student with id " + studentId + " is not found"
                        ));
    }

}
