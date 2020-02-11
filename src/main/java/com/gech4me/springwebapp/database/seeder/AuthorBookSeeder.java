package com.gech4me.springwebapp.database.seeder;

import com.gech4me.springwebapp.model.Author;
import com.gech4me.springwebapp.model.Book;
import com.gech4me.springwebapp.repositories.AuthorRepository;
import com.gech4me.springwebapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthorBookSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public AuthorBookSeeder(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.run();
    }

    private void run() {
        Author getachew = new Author("Getachew","Mulat");
        Book spring = new Book("Develop app with spring boot","3434","Marvel");
        getachew.getBooks().add(spring);
        spring.getAuthors().add(getachew);

        authorRepository.save(getachew);
        bookRepository.save(spring);
    }
}
