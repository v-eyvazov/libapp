package az.lib.libapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

    @Column(name = "published_on", nullable = false)
    private Short publishedOn;

    @Column(name = "language", nullable = false, length = 300)
    private String language;

    @Column(name = "pages", nullable = false)
    private Short pages;

    @Column(name = "image", length = 300)
    private String image;

    @OneToMany(mappedBy = "book")
    private List<AuthorsBooks> authorsBooks = new LinkedList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}