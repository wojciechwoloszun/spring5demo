package pl.wojciechwoloszun.spring5demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.wojciechwoloszun.spring5demo.domain.Author;
import pl.wojciechwoloszun.spring5demo.domain.Book;
import pl.wojciechwoloszun.spring5demo.domain.Publisher;
import pl.wojciechwoloszun.spring5demo.repositories.AuthorRepository;
import pl.wojciechwoloszun.spring5demo.repositories.BookRepository;
import pl.wojciechwoloszun.spring5demo.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pwn = new Publisher();
        pwn.setName("PWN");
        pwn.setCity("Warsaw");

        publisherRepository.save(pwn);

        Author adam = new Author("Adam", "Mickiewicz");
        Book panTadeusz = new Book("Pan Tadeusz", "11E");
        adam.getBooks().add(panTadeusz);
        panTadeusz.getAuthors().add(adam);
        panTadeusz.setPublisher(pwn);
        pwn.getBooks().add(panTadeusz);

        authorRepository.save(adam);
        bookRepository.save(panTadeusz);
        publisherRepository.save(pwn);

        Author maria = new Author("Maria", "Konopnicka");
        Book rota = new Book("Rota", "10B");
        maria.getBooks().add(rota);
        rota.getAuthors().add(maria);
        rota.setPublisher(pwn);
        pwn.getBooks().add(rota);

        authorRepository.save(maria);
        bookRepository.save(rota);
        publisherRepository.save(pwn);

        System.out.println("Started in Bootstrap");
        System.out.println("Publisher count: " + publisherRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
    }
}
