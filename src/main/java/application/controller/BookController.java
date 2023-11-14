package application.controller;

import application.dto.BookDto;
import application.dto.CreateBookRequestDto;
import application.mapper.BookMapper;
import application.model.Book;
import application.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll()
                .stream()
                .map(b -> bookMapper.toDto(b))
                .toList();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return bookMapper.toDto(book);
    }

    @PostMapping
    public BookDto createBook(@RequestBody CreateBookRequestDto requestDto) {
        Book book = bookService.createBook(requestDto);
        return bookMapper.toDto(book);
    }
}
