package az.ingress.ms10demo1.controller;

import az.ingress.ms10demo1.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return new StudentDto(1L, "Tural", "Memmedov");
    }

    @GetMapping("/list")
    public List<StudentDto> getStudentList() {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++)
            list.add(new StudentDto((long) i, "Parvin", "Etibarli"));
        return list;
    }

    // Create student
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createStudent(@RequestBody StudentDto studentDto) {
        System.out.println(studentDto);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        System.out.println("update student with id " + id + " to " + studentDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        System.out.println("deleting student with id " + id);
    }
}
