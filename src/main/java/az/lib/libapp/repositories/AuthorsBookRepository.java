package az.lib.libapp.repositories;

import az.lib.libapp.domain.AuthorsBook;
import org.springframework.data.repository.CrudRepository;

public interface AuthorsBookRepository extends CrudRepository<AuthorsBook,Integer> {
}
