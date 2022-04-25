package ukim.finki.mk.lab2emt.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.mk.lab2emt.model.Author;
import ukim.finki.mk.lab2emt.repository.AuthorRepository;
import ukim.finki.mk.lab2emt.service.AuthorService;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public Author getById(Long id) {
        return this.authorRepository.getById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
