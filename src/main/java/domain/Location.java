package domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Location implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected Location() {}
	
	public Location(int placeCode1, int placeCode2, String placeName) {
		this.placeCode1 = placeCode1;
		this.placeCode2 = placeCode2;
		this.placeName = placeName;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int LocationId;
	
	private int placeCode1;
	
	private int placeCode2;
	
	private String placeName;
	
	@ManyToOne
	@JoinTable
	private Book book;
	
	
}
