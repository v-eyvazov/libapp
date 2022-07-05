package az.lib.libapp.repositories;

import az.lib.libapp.domain.AuthorsBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsBooksRepository extends JpaRepository<AuthorsBooks,Integer> {
}
