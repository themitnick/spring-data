package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByGuardianName(String name);

    Optional<Student> findByFirstNameAndLastName(String firstName, String LastName);

    //JPQL
    @Query("select s from Student s where s.email = ?1")
    Student getStudentByEmailAddress(String email);

    @Query("select s.firstName from Student s where s.email = ?1")
    String getStudentFirstNameByEmailAddress(String email);

    //Native Query
    @Query(
            value = "SELECT * FROM student s WHERE s.email = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String email);

    //Named parameters
    @Query(
            value = "SELECT * FROM student s WHERE s.email = :email",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNamedParameter(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(
            value = "update student set first_name = ?1 where email = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailAddress(String firstName, String email);
}
