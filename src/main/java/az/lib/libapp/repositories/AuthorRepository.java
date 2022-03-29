package az.lib.libapp.repositories;

import az.lib.libapp.domain.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
