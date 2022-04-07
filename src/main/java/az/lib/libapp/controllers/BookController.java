package az.lib.libapp.controllers;

import az.lib.libapp.domain.Author;
import az.lib.libapp.domain.AuthorsBook;
import az.lib.libapp.domain.Book;
import az.lib.libapp.domain.Publisher;
import az.lib.libapp.dto.forms.BookForm;
import az.lib.libapp.services.AuthorService;
import az.lib.libapp.services.AuthorsBookService;
import az.lib.libapp.services.BookService;
import az.lib.libapp.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final AuthorsBookService authorsBookService;

    public BookController(BookService bookService,
                          AuthorService authorService,
                          PublisherService publisherService,
                          AuthorsBookService authorsBookService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.authorsBookService = authorsBookService;
    }

    @GetMapping("")
    public String showIndexPage() {
        return "index";
    }

    @GetMapping("/create/bookForm")
    public String showBookForm(Model model) {
        Iterable<Author> authors = authorService.getAllAuthors();
        Iterable<Publisher> publishers = publisherService.getAllPublishers();
        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);
        model.addAttribute("bookForm", new BookForm());
        return "forms/bookForm";
    }

    @PostMapping("create/book")
    public String createBook(@ModelAttribute BookForm bookForm) {
        String publisherNameAndId = bookForm.getPublisher().getNameAndId();
        Publisher publisher = publisherService.getPublisherById(Integer.valueOf(
                publisherNameAndId.
                    substring(
                            publisherNameAndId.indexOf(":") + 1,
                            publisherNameAndId.indexOf("]")
                ))).orElse(null);

        String authorNameAndId = bookForm.getPublisher().getNameAndId();
        Author author = authorService.getAuthorById(Integer.valueOf(
                authorNameAndId.
                        substring(
                                authorNameAndId.indexOf(":") + 1,
                                authorNameAndId.indexOf("]")
                        ))).orElse(null);

        Book book = new Book();
        book.setTitle(bookForm.getTitle());
        book.setIsRented(bookForm.getIsRented());
        book.setIsbn(bookForm.getIsbn());
        book.setPublishedOn(bookForm.getPublishedOn());
        book.setPublisher(publisher);
        bookService.save(book);

        AuthorsBook authorsBook = new AuthorsBook();
        authorsBook.setBook(book);
        authorsBook.setAuthor(author);
        authorsBookService.save(authorsBook);

        return "redirect:/create/bookForm";
    }

}
