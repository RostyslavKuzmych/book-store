package application;

import application.model.Book;
import application.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyBookStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(MyBookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setAuthor("Taras Shevchenko");
            book.setPrice(BigDecimal.valueOf(50));
            book.setTitle("Will");
            book.setDescription("The book is very philosophical");
            book.setIsbn("978");
            bookService.save(book);
            System.out.println(bookService.findAll());
        };
    }

}
