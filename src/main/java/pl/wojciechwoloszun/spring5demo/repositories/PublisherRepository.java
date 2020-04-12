package pl.wojciechwoloszun.spring5demo.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.wojciechwoloszun.spring5demo.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
