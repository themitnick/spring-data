package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Guardian;
import ci.themitnick.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    Guardian guardian = Guardian.builder()
            .name("Konate")
            .email("konante@yahoo.ci")
            .mobile("0258963245")
            .build();

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .email("yao@gmail.com")
                .firstName("tyrone")
                .lastName("YAO")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Student student = Student.builder()
                .lastName("Cisse")
                .firstName("Jean Luc")
                .email("luc@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

}
