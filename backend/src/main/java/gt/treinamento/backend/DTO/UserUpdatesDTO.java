package gt.treinamento.backend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserUpdatesDTO {

    private String name;
    private String lastName;
    private String Gender;
    private Date birthday;

}
