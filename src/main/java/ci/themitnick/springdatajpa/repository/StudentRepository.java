package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull(String name);

    List<Student> findByGuardianName(String name);

    Optional<Student> findByFirstNameAndLastName(String firstName, String LastName);
}
