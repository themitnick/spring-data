package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Course;
import ci.themitnick.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("total Elements = " + totalElements);
        System.out.println("Total pages = " + totalPages);
        System.out.println("Courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0, 4, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2,
                Sort.by("title")
                        .descending()
                .and(Sort.by("credit"))
        );

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Courses sort by title = " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("A", firstPageTenRecords).getContent();
        System.out.println("Courses contain a letter A = " + courses);
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
