package pl.wojciechwoloszun.spring5demo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.wojciechwoloszun.spring5demo.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
