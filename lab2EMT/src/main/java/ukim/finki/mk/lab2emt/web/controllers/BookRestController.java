package ukim.finki.mk.lab2emt.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.mk.lab2emt.model.Author;
import ukim.finki.mk.lab2emt.model.Book;
import ukim.finki.mk.lab2emt.model.Category;
import ukim.finki.mk.lab2emt.model.Country;
import ukim.finki.mk.lab2emt.model.dto.BookDto;
import ukim.finki.mk.lab2emt.service.AuthorService;
import ukim.finki.mk.lab2emt.service.BookService;
import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookRestController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping({"/","/books"})
    public List<Book> getBooks(){
        return this.bookService.findAll();
    }

    @GetMapping("/categories")
    public List<Category> getCategories(){
        return Arrays.asList(Category.values());
    }

    @DeleteMapping("/books/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        this.bookService.deleteBook(id);
    }

    @PostMapping("/books/add")
    public void addBook(@RequestBody BookDto bookDto){
        this.bookService.addBook(bookDto.getName(), bookDto.getCategory(), this.authorService.getById(bookDto.getAuthorId()), bookDto.getAvailableCopies());
    }

    @PostMapping("/books/edit/{id}")
    public Book editBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.editBook(id, bookDto.getName(), bookDto.getCategory(), authorService.getById(bookDto.getAuthorId()));
    }

    @PostMapping("/books/markAsTaken/{id}")
    public void markAsTaken(@PathVariable Long id){
        this.bookService.markAsTaken(id);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id){
        return this.bookService.findById(id).map(product -> ResponseEntity.ok().body(product)).orElseGet(()->ResponseEntity.notFound().build());
    }
}
