package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Course;
import ci.themitnick.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("Java 17")
                .credit(8)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.themitnick.ci")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialRepositoryList = courseMaterialRepository.findAll();
        System.out.println(courseMaterialRepositoryList);
    }

}
