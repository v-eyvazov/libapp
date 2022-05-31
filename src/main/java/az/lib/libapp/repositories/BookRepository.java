package az.lib.libapp.repositories;

import az.lib.libapp.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookRepository extends JpaRepository<Book, Integer> {

    Page<Book> findBookByTitleContaining(Pageable pageable, String title);
}
