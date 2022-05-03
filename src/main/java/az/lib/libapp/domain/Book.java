package az.lib.libapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;


@Getter
@NoArgsConstructor
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
    private final List<AuthorsBooks> authorsBooks = new LinkedList<>();

//     <---------------------------------BUILDER PATTERN------------------------------------->

    private Book(String title,
                 Publisher publisher,
                 Boolean isRented,
                 String isbn,
                 Short publishedOn,
                 String language,
                 Short pages,
                 String image) {
        this.title = title;
        this.publisher = publisher;
        this.isRented = isRented;
        this.isbn = isbn;
        this.publishedOn = publishedOn;
        this.language = language;
        this.pages = pages;
        this.image = image;
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }

    public static class BookBuilder {

        private String title;
        private Publisher publisher;
        private Boolean isRented;
        private String isbn;
        private Short publishedOn;
        private String language;
        private Short pages;
        private String image;

        public BookBuilder setTitle(final String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setPublisher(final Publisher publisher) {
            this.publisher = publisher;
            return this;
        }

        public BookBuilder setIsRented(final Boolean isRented) {
            this.isRented = isRented;
            return this;
        }

        public BookBuilder setIsbn(final String isbn) {
            this.isbn = isbn;
            return this;
        }

        public BookBuilder setPublishedOn(final Short publishedOn) {
            this.publishedOn = publishedOn;
            return this;
        }

        public BookBuilder setLanguage(final String language) {
            this.language = language;
            return this;
        }

        public BookBuilder setPages(final Short pages) {
            this.pages = pages;
            return this;
        }

        public BookBuilder setImage(final String image) {
            this.image = image;
            return this;
        }

        public Book build() {
            return new Book(title, publisher, isRented, isbn, publishedOn, language, pages, image);
        }
    }


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