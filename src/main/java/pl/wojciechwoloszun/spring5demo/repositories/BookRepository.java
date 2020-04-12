package pl.wojciechwoloszun.spring5demo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.wojciechwoloszun.spring5demo.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
