package az.lib.libapp.services;


import az.lib.libapp.domain.Book;
import az.lib.libapp.dto.paging.Paged;

public interface BookService {
    Iterable<Book> getAllBooks();

    void save(Book book);

    Paged<Book> getPage(int pageNumber, int size);

}
