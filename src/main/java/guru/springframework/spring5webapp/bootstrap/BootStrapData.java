package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author bob = new Author("Robert","Martin");
        Book abc = new Book("Design Patterns","12322");
        Book ndc = new Book("Nagas","324");
        bob.getBooks().add(abc);
        abc.getAuthors().add(bob);
        ndc.getAuthors().add(bob);

        authorRepository.save(bob);
        bookRepository.save(abc);
        bookRepository.save(ndc);

        Publisher harperCollins = new Publisher("HarperCollins","US");
        Publisher pen = new Publisher("Penguin","Viking Press");
        publisherRepository.save(harperCollins);
        publisherRepository.save(pen);


        System.out.println("BootStrapData.run");
        System.out.println(" Number of books :" +bookRepository.count() );
        System.out.println(" Number of publishers : "+publisherRepository.count());
    }
}
