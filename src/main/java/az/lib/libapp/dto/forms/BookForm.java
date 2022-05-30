package az.lib.libapp.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {
    private String title;
    private Boolean isRented;
    private String isbn;
    private Short publishedOn;
    private PublisherForm publisher;
    private AuthorForm author;
    private String language;
    private Short pages;
}