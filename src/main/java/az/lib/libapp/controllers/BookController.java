package az.lib.libapp.controllers;

import az.lib.libapp.domain.Author;
import az.lib.libapp.domain.AuthorsBooks;
import az.lib.libapp.domain.Book;
import az.lib.libapp.domain.Publisher;
import az.lib.libapp.dto.forms.BookForm;
import az.lib.libapp.services.AuthorService;
import az.lib.libapp.services.AuthorsBooksService;
import az.lib.libapp.services.BookService;
import az.lib.libapp.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static az.lib.libapp.utilities.Extract.extractId;


@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final AuthorsBooksService authorsBooksService;

    public BookController(BookService bookService,
                          AuthorService authorService,
                          PublisherService publisherService,
                          AuthorsBooksService authorsBooksService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.authorsBooksService = authorsBooksService;
    }


    @GetMapping("/create/book")
    public String showBookForm(Model model) {
        Iterable<Author> authors = authorService.getAllAuthors();
        Iterable<Publisher> publishers = publisherService.getAllPublishers();
        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);
        model.addAttribute("bookForm", new BookForm());
        return "forms/create-forms/book-form";
    }

    @PostMapping("/form/create/book")
    public String createBook(@ModelAttribute BookForm bookForm) {
        Publisher publisher = publisherService.getPublisherById(extractId(bookForm.getPublisher().getNameAndId()))
                .orElse(null);
        Author author = authorService.getAuthorById(extractId(bookForm.getAuthor().getNameAndId()))
                .orElse(null);

        Book book = Book.builder()
                .setTitle(bookForm.getTitle())
                .setIsRented(bookForm.getIsRented())
                .setIsbn(bookForm.getIsbn())
                .setPublishedOn(bookForm.getPublishedOn())
                .setPublisher(publisher)
                .setLanguage(bookForm.getLanguage())
                .setPages(bookForm.getPages())
                .build();

        bookService.save(book);

        AuthorsBooks authorsBook = new AuthorsBooks();
        authorsBook.setBook(book);
        authorsBook.setAuthor(author);
        authorsBooksService.save(authorsBook);

        return "redirect:/create/book";
    }

}
