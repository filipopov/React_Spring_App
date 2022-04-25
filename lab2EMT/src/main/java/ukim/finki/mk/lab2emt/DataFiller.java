package ukim.finki.mk.lab2emt;

import org.springframework.stereotype.Component;
import ukim.finki.mk.lab2emt.model.Author;
import ukim.finki.mk.lab2emt.model.Book;
import ukim.finki.mk.lab2emt.model.Category;
import ukim.finki.mk.lab2emt.model.Country;
import ukim.finki.mk.lab2emt.service.AuthorService;
import ukim.finki.mk.lab2emt.service.BookService;
import ukim.finki.mk.lab2emt.service.CountryService;

import javax.annotation.PostConstruct;

@Component
public class DataFiller {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataFiller(BookService bookService,
                      AuthorService authorService,
                      CountryService countryService) {

        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void init(){
        Country country1 = new Country("Macedonia", "Europe");
        Country country2 = new Country("Canada", "North America");
        this.countryService.save(country1);
        this.countryService.save(country2);

        Author author1 = new Author("Riste","Ristov", country1);
        Author author2 = new Author("Petko", "Petkov", country2);
        this.authorService.save(author1);
        this.authorService.save(author2);

        this.bookService.addBook("Kniga1", Category.HISTORY, author1, 3);
        this.bookService.addBook("Kniga2", Category.DRAMA, author2, 5);
        this.bookService.addBook("Kniga3", Category.FANTASY, author1, 1);
    }
}
