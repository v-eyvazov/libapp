package az.lib.libapp.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorForm {

    private String firstName;
    private String lastName;
    private String secondName;
    private String nameAndId;

}
