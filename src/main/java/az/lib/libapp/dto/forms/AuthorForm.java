package az.lib.libapp.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorForm {

    @NotBlank(message = "Name cannot be empty!")
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters!")
    private String firstName;

    @NotBlank(message = "Lastname cannot be empty!")
    @Size(min = 3, max = 30, message = "Lastname must be between 3 and 30 characters!")
    private String lastName;

    @NotBlank(message = "Second name cannot be empty!")
    @Size(min = 3, max = 30, message = "Second name must be between 3 and 30 characters!")
    private String secondName;

    private String nameAndId;

}
