// BookService.java
package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // Constructor Injection
    public BookService(BookRepository bookRepository)  
    {
        this.bookRepository = bookRepository;
    }

    // Setter (already present, optional)
    public void setBookRepository(BookRepository bookRepository) 
    {
        this.bookRepository = bookRepository;
    }

    public void addBook() {
        bookRepository.save();
    }

}
