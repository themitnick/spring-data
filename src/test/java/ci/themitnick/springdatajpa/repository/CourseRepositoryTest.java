package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Course;
import ci.themitnick.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }

//You can remove comment to test @ManyToOne

//    @Test
//    public void saveCourseWithTeacher(){
//
//        Teacher teacher = Teacher.builder()
//                .firstName("Tyrone")
//                .lastName("Konan")
//                .build();
//
//        Course courseAWS = Course.builder()
//                .title("AWS")
//                .credit(10)
//                .teacher(teacher)
//                .build();
//
//        courseRepository.save(courseAWS);
//    }

}
