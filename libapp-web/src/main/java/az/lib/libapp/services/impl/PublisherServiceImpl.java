package az.lib.libapp.services.impl;

import az.lib.libapp.domain.Publisher;
import az.lib.libapp.repositories.PublisherRepository;
import az.lib.libapp.services.PublisherService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Iterable<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Override
    public Optional<Publisher> getPublisherById(Integer id) {
        return publisherRepository.findById(id);
    }

    @Override
    public void save(Publisher publisher) {
        publisherRepository.save(publisher);
    }
}
