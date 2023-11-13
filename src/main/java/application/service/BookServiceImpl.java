package application.service;

import application.dto.BookDto;
import application.dto.CreateBookRequestDto;
import application.exception.EntityNotFoundException;
import application.mapper.BookMapper;
import application.model.Book;
import application.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private BookMapper bookMapper;

    @Override
    public Book save(CreateBookRequestDto book) {
        Book newBook = bookMapper.toModel(book);
        bookRepository.save(newBook);
        return newBook;
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto createBook(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findBookById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't get book by id " + id));
        return bookMapper.toDto(book);
    }
}
