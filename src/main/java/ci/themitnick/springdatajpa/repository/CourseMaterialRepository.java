package ci.themitnick.springdatajpa.repository;

import ci.themitnick.springdatajpa.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
