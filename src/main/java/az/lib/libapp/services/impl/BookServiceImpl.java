package az.lib.libapp.services.impl;


import az.lib.libapp.domain.Book;
import az.lib.libapp.dto.paging.Paged;
import az.lib.libapp.dto.paging.Paging;
import az.lib.libapp.repositories.BookRepository;
import az.lib.libapp.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    @Override
    public Paged<Book> getPage(int pageNumber, int size) {
        PageRequest request = PageRequest.of(pageNumber - 1, size, Sort.by("id"));
        Page<Book> bookPage = bookRepository.findAll(request);
        return new Paged<>(bookPage, Paging.of(bookPage.getTotalPages(), pageNumber, size));
    }


}
