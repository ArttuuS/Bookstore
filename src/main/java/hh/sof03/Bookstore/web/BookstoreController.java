package hh.sof03.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.Bookstore.domain.Book;
import hh.sof03.Bookstore.domain.BookRepository;


@Controller
public class BookstoreController {
	@Autowired
	private BookRepository repository;


	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String listBooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:/booklist";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		Book book = repository.findById(bookId).orElse(null);
		if (book != null) {
			model.addAttribute("book", book);
			return "addbook";
		} else {
			return "redirect:/booklist";
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:/booklist";
	}
}
	