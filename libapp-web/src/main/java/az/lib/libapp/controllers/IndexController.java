package az.lib.libapp.controllers;


import az.lib.libapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private final BookService bookService;

    public IndexController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/")
    public String showIndexPage(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                                @RequestParam(value = "size", required = false, defaultValue = "20") int size, Model model) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        model.addAttribute("books", bookService.getBooks(pageNumber, size));
        return "index";
    }

    @GetMapping("/find")
    public String findBook(@RequestParam String title, Model model){
        model.addAttribute("books", bookService.getBook(title));
        return "index";
    }

}
