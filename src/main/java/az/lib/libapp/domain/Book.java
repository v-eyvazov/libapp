package az.lib.libapp.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "title", nullable = false, length = 300)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "is_rented", nullable = false)
    private Boolean isRented = false;

    @Column(name = "isbn", nullable = false, length = 300)
    private String isbn;

    @Column(name = "published_on")
    private LocalDate publishedOn;

    @Column(name = "image", length = 300)
    private String image;

    @OneToMany(mappedBy = "book")
    private Set<AuthorsBook> authorsBooks = new LinkedHashSet<>();

}