package az.lib.libapp.services.impl;

import az.lib.libapp.domain.Author;
import az.lib.libapp.repositories.AuthorRepository;
import az.lib.libapp.services.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl (AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> getAuthorById(Integer id) {
        return authorRepository.findById(id);
    }

    @Override
    public void save(Author author){
        authorRepository.save(author);
    }

}
