package az.lib.libapp.repositories;

import az.lib.libapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookRepository extends JpaRepository<Book, Integer> {
}
