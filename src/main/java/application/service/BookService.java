package application.service;

import application.dto.CreateBookRequestDto;
import application.model.Book;
import java.util.List;

public interface BookService {
    Book save(CreateBookRequestDto requestDto);

    List<Book> findAll();

    Book createBook(CreateBookRequestDto requestDto);

    Book getBookById(Long id);

    void updateBook(Book book);

    void deleteBookById(Long id);
}
