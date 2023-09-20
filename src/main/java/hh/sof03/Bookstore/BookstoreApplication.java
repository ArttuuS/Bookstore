package hh.sof03.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Taru sormusten herrasta", "Kirjailija Kirja", 1998, "1281408565652", 21.90);
			Book b2 = new Book("Esimerkkikirja2", "Risto Matti", 1923, "9781408565652", 89.90);
			Book b3 = new Book("Mahtava kirja", "Leevi Leeviläinen", 2008, "7881408565652", 15.90);

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);

		};

	}
}
