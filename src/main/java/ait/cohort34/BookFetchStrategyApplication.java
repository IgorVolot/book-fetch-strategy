package ait.cohort34;

import ait.cohort34.book.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookFetchStrategyApplication implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookFetchStrategyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.addBooks();
        bookRepository.printAuthorsOfBook("978-3-16-148410-1");
    }
}
