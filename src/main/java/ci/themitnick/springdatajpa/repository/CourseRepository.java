package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
