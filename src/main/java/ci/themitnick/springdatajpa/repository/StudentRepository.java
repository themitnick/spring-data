package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
