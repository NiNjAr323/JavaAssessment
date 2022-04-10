package com.java.assessment.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.assessment.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}