package application.service;

import application.dto.BookDto;
import application.dto.CreateBookRequestDto;
import application.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();

    Book createBook(CreateBookRequestDto requestDto);

    Book getBookById(Long id);

    BookDto updateBook(Long id, Book book);

    void deleteBookById(Long id);
}
