package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.sym.Name;

import domain.Author;
import domain.Book;
import domain.Location;

@Controller
@RequestMapping("/books")
public class BookController {
	
	List<Book> books = new ArrayList<>() {
		{
			add(new Book("To Kill a Mockingbird", "9780446310789", List.of(new Author("Harper Lee")), 10.99, List.of(new Location(10,20,"New York")), "https://www.gutenberg.org/cache/epub/70637/pg70637.cover.medium.jpg"));
			add(new Book("1984", "9780451524935", List.of(new Author("George Orwell")), 8.99, List.of(new Location(10,20,"London")),"https://www.gutenberg.org/cache/epub/70636/pg70636.cover.medium.jpg"));
			add(new Book("Pride and Prejudice", "9780486284736", List.of(new Author("Jane Austen")), 7.99, List.of(new Location(10,20,"Bath"), new Location(10,20,"London")),"https://www.gutenberg.org/cache/epub/17103/pg17103.cover.medium.jpg"));
		}
	};
	
	@GetMapping
	public String getBooks(Model model) {
		model.addAttribute("books", books);
		return "index";
	}
	
	@GetMapping("/{isbn}")
	public String getBookDetails(@PathVariable("isbn") String isbn, Model model) {
		Optional<Book> optionalBook = books.stream().filter(book -> book.getISBNNumber().equals(isbn)).findFirst();
		if(optionalBook.isPresent()) {
			model.addAttribute("book", optionalBook.get());
			return "book_detail.html";
		}
		return "404.html";
	}
	
}
