package gt.treinamento.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {

    private String name;

    private String lastName;

    private String gender;

    private Date birthday;

    private String email;

    private List<Movie> movies;

}
