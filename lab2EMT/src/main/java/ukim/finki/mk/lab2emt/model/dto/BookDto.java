package ukim.finki.mk.lab2emt.model.dto;

import lombok.Data;
import ukim.finki.mk.lab2emt.model.Author;
import ukim.finki.mk.lab2emt.model.Category;

@Data
public class BookDto {
    private String name;
    private Category category;
    private Long authorId;
    private Integer availableCopies;

    public BookDto(String name, Category category, Long authorId, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

    public BookDto() {}
}
