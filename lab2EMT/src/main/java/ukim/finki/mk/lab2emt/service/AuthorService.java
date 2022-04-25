package ukim.finki.mk.lab2emt.service;

import ukim.finki.mk.lab2emt.model.Author;

import java.util.List;

public interface AuthorService {
    Author save(Author author);
    Author getById(Long id);
    List<Author> findAll();
}
