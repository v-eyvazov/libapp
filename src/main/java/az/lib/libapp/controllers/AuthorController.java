package az.lib.libapp.controllers;

import az.lib.libapp.domain.Author;
import az.lib.libapp.dto.forms.AuthorForm;
import az.lib.libapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }


    @GetMapping("/create/author")
    public String showAuthorForm(Model model) {
        model.addAttribute("authorForm", new AuthorForm());
        return "forms/author-form";
    }

    @PostMapping("/form/create/author")
    public String createAuthor(@ModelAttribute AuthorForm authorForm) {
        Author author = new Author();
        author.setFirstName(authorForm.getFirstName());
        author.setLastName(authorForm.getLastName());
        author.setSecondName(authorForm.getSecondName());
        authorService.save(author);
        return "redirect:/create/author";
    }

}
