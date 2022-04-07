package az.lib.libapp.services.impl;


import az.lib.libapp.domain.Book;
import az.lib.libapp.repositories.BookRepository;
import az.lib.libapp.services.BookService;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
}
