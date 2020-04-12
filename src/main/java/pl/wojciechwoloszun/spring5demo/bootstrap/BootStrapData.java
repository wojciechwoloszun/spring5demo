package pl.wojciechwoloszun.spring5demo.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.wojciechwoloszun.spring5demo.domain.Author;
import pl.wojciechwoloszun.spring5demo.domain.Book;
import pl.wojciechwoloszun.spring5demo.repositories.AuthorRepository;
import pl.wojciechwoloszun.spring5demo.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author adam = new Author("Adam", "Mickiewicz");
        Book panTadeusz = new Book("Pan Tadeusz", "11E");
        adam.getBooks().add(panTadeusz);
        panTadeusz.getAuthors().add(adam);

        authorRepository.save(adam);
        bookRepository.save(panTadeusz);

        Author maria = new Author("Maria","Konopnicka");
        Book rota = new Book("Rota","10B");
        maria.getBooks().add(rota);
        rota.getAuthors().add(maria);

        authorRepository.save(maria);
        bookRepository.save(rota);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: "+bookRepository.count());
    }
}
