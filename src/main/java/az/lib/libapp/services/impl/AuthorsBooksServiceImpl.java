package az.lib.libapp.services.impl;

import az.lib.libapp.domain.AuthorsBooks;
import az.lib.libapp.repositories.AuthorsBooksRepository;
import az.lib.libapp.services.AuthorsBooksService;
import org.springframework.stereotype.Service;

@Service
public class AuthorsBooksServiceImpl implements AuthorsBooksService {

    private final AuthorsBooksRepository authorsBooksRepository;

    public AuthorsBooksServiceImpl(AuthorsBooksRepository authorsBooksRepository) {
        this.authorsBooksRepository = authorsBooksRepository;
    }


    @Override
    public void save(AuthorsBooks authorsBooks) {
        authorsBooksRepository.save(authorsBooks);
    }
}
