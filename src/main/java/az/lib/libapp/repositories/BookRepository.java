package az.lib.libapp.repositories;

import az.lib.libapp.domain.Book;
import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Integer> {
}
