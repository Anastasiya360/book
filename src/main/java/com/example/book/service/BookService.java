package com.example.book.service;

import com.example.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Book> getBooks();

    Book getBookById(Integer id);

    Book create(Book book);

    Book update(Integer id, Book book);

    void deleteById(Integer id);
}
