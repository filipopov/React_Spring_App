package ukim.finki.mk.lab2emt.web.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ukim.finki.mk.lab2emt.model.Author;
import ukim.finki.mk.lab2emt.service.AuthorService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAuthors(){
        return this.authorService.findAll();
    }
}
