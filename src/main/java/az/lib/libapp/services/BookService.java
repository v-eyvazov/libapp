package az.lib.libapp.services;


import az.lib.libapp.domain.Book;
import az.lib.libapp.domain.paging.Paged;

public interface BookService {

    void save(Book book);

    Paged<Book> getBooks(int pageNumber, int size);

    Paged<Book> getBook(String title);

}
