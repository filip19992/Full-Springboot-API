package pl.filipwlodarczyk.SPRINGSECURITY.student;

import lombok.*;

@Getter
@Setter
public class Student {

    private Long studentId;
    private  String username;


    public Student(Long studentId, String username) {
        this.studentId = studentId;
        this.username = username;
    }
}
