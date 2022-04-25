package ukim.finki.mk.lab2emt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ukim.finki.mk.lab2emt.model.Book;
import ukim.finki.mk.lab2emt.model.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT category FROM Book")
    List<Category> findCategories();
}
