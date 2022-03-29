package az.lib.libapp.services;

import az.lib.libapp.domain.Book;

import java.util.List;

public interface BookService {
    Iterable<Book> getAllBooks();
}
