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


    @GetMapping("")
    public String showIndexPage(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
                                @RequestParam(value = "size", required = false, defaultValue = "15") int size, Model model) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        model.addAttribute("books", bookService.getPage(pageNumber, size));
        return "index";
    }

}
