package com.example.book.service.impl;

import com.example.book.exception.ApiException;
import com.example.book.model.Book;
import com.example.book.service.BookService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final List<Book> books = new ArrayList<>();
    private Integer idBook = 1;

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Book getBookById(Integer id) {
        if (id == null) {
            throw new ApiException("id не передан", HttpServletResponse.SC_BAD_REQUEST);
        }
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        throw new ApiException("Книга не найдена", HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    public Book create(Book book) {
        book.setId(idBook++);
        checkParam(book);
        books.add(book);
        return book;
    }

    @Override
    public Book update(Integer id, Book book) {
        Book oldBook = getBookById(id);
        if (book.getTitle() != null && !book.getTitle().isBlank()) {
            oldBook.setTitle(book.getTitle());
        }
        if (book.getAuthor() != null && !book.getAuthor().isBlank()) {
            oldBook.setAuthor(book.getAuthor());
        }
        if (book.getDescription() != null && !book.getDescription().isBlank()) {
            oldBook.setDescription(book.getDescription());
        }
        if (book.getPrice() != null) {
            oldBook.setPrice(book.getPrice());
        }
        return oldBook;
    }

    @Override
    public void deleteById(Integer id) {
        Book book = getBookById(id);
        books.remove(book);
    }

    private void checkParam(Book book) {
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new ApiException("Заголовок не передан", HttpServletResponse.SC_BAD_REQUEST);
        }
        if (book.getPrice() == null) {
            throw new ApiException("Цена не передана", HttpServletResponse.SC_BAD_REQUEST);
        }
        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            throw new ApiException("Автор не передан", HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
