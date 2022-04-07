package az.lib.libapp.services;

import az.lib.libapp.domain.Publisher;

import java.util.Optional;

public interface PublisherService {
    Iterable<Publisher> getAllPublishers();
    Optional<Publisher> getPublisherById(Integer id);
    void save(Publisher publisher);
}
