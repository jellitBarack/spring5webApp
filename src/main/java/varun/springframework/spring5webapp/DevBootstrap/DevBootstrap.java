package varun.springframework.spring5webapp.DevBootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import varun.springframework.spring5webapp.model.Author;
import varun.springframework.spring5webapp.model.Book;
import varun.springframework.spring5webapp.model.Publisher;
import varun.springframework.spring5webapp.repository.AuthorRepository;
import varun.springframework.spring5webapp.repository.BookRepository;
import varun.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
