package az.ingress.studentdockercompose.repository;

import az.ingress.studentdockercompose.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByIdAndActive(Long id, Integer active);

    List<Student> findAllByActive(Integer active);
}
