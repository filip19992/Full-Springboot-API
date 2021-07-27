package pl.filipwlodarczyk.SPRINGSECURITY.student;


import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("management/api/v1/students")
@RestController
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(0L, "Filip"),
            new Student(1L, "Artur"),
            new Student(2L, "Zbigniew"),
            new Student(3L, "Marcin"),
            new Student(4L, "Maciek")

    );

    @GetMapping
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }


    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        for (Student student : STUDENTS) {
            if (student.getStudentId().equals(studentId)) {
                STUDENTS.remove(student);
            } else {
                throw new IllegalStateException("There is no student with id " + studentId);
            }
        }
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,@RequestBody Student student) {
        System.out.println(String.format("%s %s", studentId, student));
    }
}
