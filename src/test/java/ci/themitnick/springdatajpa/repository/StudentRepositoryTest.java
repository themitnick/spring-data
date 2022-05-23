package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Guardian;
import ci.themitnick.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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
                .lastName("Goudou")
                .firstName("Jeannot")
                .email("g.jeannot@yaho.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void findStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("tyrone");
        System.out.println("Students = " + students);
    }

    @Test
    public void findStudentContainingName(){
        List<Student> students = studentRepository.findByFirstNameContaining("Jean");
        System.out.println("Students list = " + students);
    }

    @Test
    public void findByFirstNameAndLastName(){
        Optional<Student> student = studentRepository.findByFirstNameAndLastName("tyrone", "YAO");
        System.out.println("Student =" + student);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("yao@gmail.com");
        System.out.println("Student by Email = " + student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress(){
        String studentFirstName = studentRepository.getStudentFirstNameByEmailAddress("yao@gmail.com");
        System.out.println("Student firstName by email = " + studentFirstName);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("luc@gmail.com");
        System.out.println("Student by Email = " + student);
    }

    @Test
    public void getStudentByEmailAddressNamedParameter(){
        Student student = studentRepository.getStudentByEmailAddressNamedParameter("luc@gmail.com");
        System.out.println("Student by Email = " + student);
    }

    @Test
    public void  updateStudentNameByEmailAddress(){
       studentRepository.updateStudentNameByEmailAddress("Tyrone Yao", "yao@gmail.com");
    }

}
