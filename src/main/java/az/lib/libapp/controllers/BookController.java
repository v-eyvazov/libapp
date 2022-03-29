package az.lib.libapp.controllers;

import az.lib.libapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String showIndexPage() {
        return "index";
    }

}
