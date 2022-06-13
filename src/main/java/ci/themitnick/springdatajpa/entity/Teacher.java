package ci.themitnick.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Teacher {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long teacherId;
    private String firstName;
    private String lastName;

    @OneToMany(
         cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;
}
