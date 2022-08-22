package az.ingress.ms10demo1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long age;
    private String firstName;
    private String lastName;
}
