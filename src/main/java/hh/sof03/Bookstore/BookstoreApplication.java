package hh.sof03.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;
import hh.sof03.Bookstore.domain.Category;
import hh.sof03.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Taru sormusten herrasta", "Kirjailija Kirja", 1998, "1281408565652", 21.90));
			repository.save(new Book("Esimerkkikirja2", "Risto Matti", 1923, "9781408565652", 89.90));
			repository.save(new Book("Mahtava kirja", "Leevi Leeviläinen", 2008, "7881408565652", 15.90));

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}

	@Bean
	public CommandLineRunner demo2(CategoryRepository repository) {
		return (args) -> {
			log.info("save a couple of categories");
			repository.save(new Category(1, "Scifi"));
			repository.save(new Category(2, "Comedy"));
			repository.save(new Category(3, "Drama"));

			log.info("fetch all categories");
			for (Category category : repository.findAll()) {
				log.info(category.toString());
			}

		};

	}
}
