package az.lib.libapp.services.impl;

import az.lib.libapp.domain.AuthorsBook;
import az.lib.libapp.repositories.AuthorsBookRepository;
import az.lib.libapp.services.AuthorsBookService;
import org.springframework.stereotype.Service;

@Service
public class AuthorsBookServiceImpl implements AuthorsBookService {

    private final AuthorsBookRepository authorsBookRepository;

    public AuthorsBookServiceImpl(AuthorsBookRepository authorsBookRepository) {
        this.authorsBookRepository = authorsBookRepository;
    }


    @Override
    public void save(AuthorsBook authorsBook) {
        authorsBookRepository.save(authorsBook);
    }
}
