package domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Entity
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;

	protected Book() {}
	
	public Book(String name, String ISBNNumber, List<Author> authors, double price, List<Location> locations, String imageUrl) {
		this.name = name;
		this.ISBNNumber = ISBNNumber;
		this.authors = authors;
		this.locations = locations;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	private String name;
	
	private String imageUrl;
	
	@Id
	private String ISBNNumber;
	
	@OneToMany(mappedBy = "book")
	private List<Author> authors;
	
	private Double price;
	
	@OneToMany(mappedBy = "book")
	private List<Location> locations;
	
//	@ManyToMany
//	private List<Like> likes;
	
	
	public int getNumberOfLikes() {
//		return likes.size();
		return 150;
	}
}
