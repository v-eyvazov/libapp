package az.lib.libapp.repositories;

import az.lib.libapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Integer> {
}
