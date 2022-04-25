package ukim.finki.mk.lab2emt.service;

import ukim.finki.mk.lab2emt.model.Author;
import ukim.finki.mk.lab2emt.model.Book;
import ukim.finki.mk.lab2emt.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    Book addBook(String name, Category category, Author author, Integer availableCopies);
    Book editBook(Long id, String name, Category category, Author author);
    List<Category> findCategories();
    void deleteBook(Long id);
    Book markAsTaken(Long id);
    Optional<Book> findById(Long id);
}
