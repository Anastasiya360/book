package com.example.book.controller.impl;

import com.example.book.controller.BookController;
import com.example.book.model.Book;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @Override
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookService.getBookById(id);
    }

    @Override
    public Book create(Book book) {
        return bookService.create(book);
    }

    @Override
    public Book update(Integer id, Book book) {
        return bookService.update(id, book);
    }

    @Override
    public void deleteById(Integer id) {
        bookService.deleteById(id);
    }
}
