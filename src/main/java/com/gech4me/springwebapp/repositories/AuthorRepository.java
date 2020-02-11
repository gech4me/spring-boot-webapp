package com.gech4me.springwebapp.repositories;

import com.gech4me.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
