package gt.treinamento.backend.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie {

    private String name;
    private String genderMovie;
    private Date launchDate;
    private Director director;
}
