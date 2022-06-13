package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Course;
import ci.themitnick.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseDocker = Course.builder()
                .title("Docker")
                .credit(5)
                .build();

        Course courseKafka = Course.builder()
                .title("Kafka")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Mitnick")
                .lastName("YAO")
                //.courses(List.of(courseDocker, courseKafka))
                .build();

        teacherRepository.save(teacher);
    }

}
