package az.lib.libapp.services;

import az.lib.libapp.domain.Book;


public interface BookService {
    Iterable<Book> getAllBooks();

    void save(Book book);
}
