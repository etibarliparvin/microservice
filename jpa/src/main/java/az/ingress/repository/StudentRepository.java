package az.ingress.repository;

import az.ingress.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String name);

    List<Student> findByFirstNameAndLastName(String name, String surname);

    @Query("select s from Student s where s.firstName = ?1 and s.lastName = ?2")
    List<Student> findStudentsWithJpql(String firstName, String lastName);

    @Query(nativeQuery = true, value = "select * from students s where s.first_name = ?1 and s.last_name = ?2")
    List<Student> findStudentsWithNativeSql(String firstName, String lastName);
}
