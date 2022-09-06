package az.ingress.service;

import az.ingress.domain.Student;
import az.ingress.domain.Student$;
import az.ingress.repository.StudentRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final JPAStreamer jpaStreamer;

//    @PostConstruct
    public void listByQueryMethods() {
        repository.findByFirstName("Orkhan")
                .stream()
                .forEach(System.out::println);

        repository.findByFirstNameAndLastName("Orkhan", "Safarov")
                .stream()
                .forEach(System.out::println);
    }

//    @PostConstruct
    public void jpql() {
        repository.findStudentsWithJpql("Orkhan", "Safarov")
                .stream()
                .forEach(System.out::println);
    }

//    @PostConstruct
    public void nativeSql() {
        repository.findStudentsWithNativeSql("Orkhan", "Safarov")
                .stream()
                .forEach(System.out::println);
    }

    @PostConstruct
    public void jpaStreamer() {
        jpaStreamer.stream(Student.class)
                .filter(Student$.firstName.equal("Orkhan"))
                .limit(5)
                .forEach(System.out::println);
    }
}
