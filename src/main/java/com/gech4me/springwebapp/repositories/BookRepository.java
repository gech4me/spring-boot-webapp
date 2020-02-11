package com.gech4me.springwebapp.repositories;

import com.gech4me.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
