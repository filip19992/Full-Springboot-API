package pl.filipwlodarczyk.SPRINGSECURITY.student;


import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
    }


    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        STUDENTS.removeIf(student -> student.getStudentId().equals(studentId));
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable("studentId") Long studentId,@RequestBody Student student) {
        System.out.println(String.format("%s %s", studentId, student));
    }
}
