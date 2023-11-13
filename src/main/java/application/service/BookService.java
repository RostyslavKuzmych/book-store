package application.service;

import application.dto.BookDto;
import application.dto.CreateBookRequestDto;
import application.model.Book;
import java.util.List;

public interface BookService {
    Book save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto createBook(CreateBookRequestDto requestDto);

    BookDto getBookById(Long id);
}
