package ukim.finki.mk.lab2emt.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab2emt.model.Author;
import ukim.finki.mk.lab2emt.model.Book;
import ukim.finki.mk.lab2emt.model.Category;
import ukim.finki.mk.lab2emt.repository.BookRepository;
import ukim.finki.mk.lab2emt.service.BookService;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book addBook(String name, Category category, Author author, Integer availableCopies){
        Book book = new Book(name, category, author, availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public Book editBook(Long id, String name, Category category, Author author) {
        Book b = this.bookRepository.getById(id);
        b.setName(name);
        b.setCategory(category);
        b.setAuthor(author);

        return this.bookRepository.save(b);
    }

    @Override
    public List<Category> findCategories(){
        return this.bookRepository.findCategories();
    }

    @Override
    public void deleteBook(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Book markAsTaken(Long id) {
        Book b = this.bookRepository.getById(id);
        b.setAvailableCopies(b.getAvailableCopies()-1);
        return this.bookRepository.save(b);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }
}
