package hh.sof03.Bookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.Bookstore.domain.Book;

@Controller
public class BookstoreController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)

	public String annaKaikkiKirjat(Model model) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997, "9781408855652", 23.90));
		books.add(new Book("To Kill a Mockingbird", "Harper Lee", 1960, "9780061120084", 14.99));
		books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, "9780743273565", 12.95));

		model.addAttribute("books", books);

		return "bookstore";
	}

}
