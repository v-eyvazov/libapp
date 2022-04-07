package az.lib.libapp.dto.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookForm {
    private String title; //
    private Boolean isRented; //
    private String isbn; //

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedOn; //
    private PublisherForm publisher;
    private AuthorForm author;
}