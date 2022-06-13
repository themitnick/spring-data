package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
