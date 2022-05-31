package az.lib.libapp.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {
    @NotBlank(message = "Title cannot be empty!")
    @Size(min = 3, max = 30, message = "Title must be between 3 and 30 characters!")
    private String title;

    private Boolean isRented;

    @NotBlank(message = "ISBN cannot be empty!")
    private String isbn;

    @Min(value = 0, message = "Publish date cannot be negative!")
    private Short publishedOn;

    @Size(min = 3, max = 30, message = "Language must be between 3 and 30 characters!")
    private String language;

    @Min(value = 1, message = "Number of pages cannot be less than 1!")
    private Short pages;

    private PublisherForm publisher;

    private AuthorForm author;
}