package az.lib.libapp.services;

import az.lib.libapp.domain.Author;

import java.util.Optional;

public interface AuthorService {
    Iterable<Author> getAllAuthors();
    Optional<Author> getAuthorById(Integer id);
    void save(Author author);
}
