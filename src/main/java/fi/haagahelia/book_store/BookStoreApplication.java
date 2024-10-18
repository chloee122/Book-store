package fi.haagahelia.book_store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.book_store.domain.Book;
import fi.haagahelia.book_store.domain.BookRepository;
import fi.haagahelia.book_store.domain.Category;
import fi.haagahelia.book_store.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner booksStoreDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");
			
			Category category1 = new Category("Novel");
			Category category2 = new Category("Novella");

			crepository.save(category1);
			crepository.save(category2);

			brepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", category1));
			brepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", category2));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
			log.info(book.toString());
			}
		};
	}

}
