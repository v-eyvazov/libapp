package az.lib.libapp.repositories;

import az.lib.libapp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
