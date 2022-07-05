package az.lib.libapp.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherForm {

    @NotBlank(message = "Name cannot be empty!")
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters!")
    private String name;

    @URL(message = "Web address is not valid!")
    private String website;

    private String nameAndId;

}
