package az.lib.libapp.controllers;

import az.lib.libapp.domain.Publisher;
import az.lib.libapp.dto.forms.PublisherForm;
import az.lib.libapp.services.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {


    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/create/publisher")
    public String showPublisherForm(Model model) {
        model.addAttribute("publisherForm", new PublisherForm());
        return "forms/publisher-form";
    }

    @PostMapping("form/create/publisher")
    public String createPublisher(@ModelAttribute PublisherForm publisherForm) {
        Publisher publisher = new Publisher();
        publisher.setName(publisherForm.getName());
        publisher.setWebsite(publisherForm.getWebsite());
        publisherService.save(publisher);
        return "redirect:/create/publisher";
    }

}
