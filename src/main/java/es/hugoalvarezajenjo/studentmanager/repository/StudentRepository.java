package es.hugoalvarezajenjo.studentmanager.repository;

import es.hugoalvarezajenjo.studentmanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
