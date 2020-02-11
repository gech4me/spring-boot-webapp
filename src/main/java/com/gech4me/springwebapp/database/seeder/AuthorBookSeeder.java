package com.gech4me.springwebapp.database.seeder;

import com.gech4me.springwebapp.model.Author;
import com.gech4me.springwebapp.model.Book;
import com.gech4me.springwebapp.model.Publisher;
import com.gech4me.springwebapp.repositories.AuthorRepository;
import com.gech4me.springwebapp.repositories.BookRepository;
import com.gech4me.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthorBookSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public AuthorBookSeeder(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.run();
    }

    private void run() {
        Author getachew = new Author("Getachew", "Mulat");
        Book spring = new Book("Develop app with spring boot", "3434");
        Publisher maravel = new Publisher("Maravel","St. Ava");
        getachew.getBooks().add(spring); // Add book to books
        spring.getAuthors().add(getachew); // Attach Author and book
        maravel.getBooks().add(spring); // Attach Publisher and book

        authorRepository.save(getachew);
        bookRepository.save(spring);
        publisherRepository.save(maravel);
    }
}
