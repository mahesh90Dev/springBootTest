package spring.test.spring5webapp1.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private String publisher;
	
	private String isbn;
	
	@ManyToMany
	@JoinTable(name="AUTHOR_BOOK", joinColumns= @JoinColumn(name="BOOK_ID"), 
	inverseJoinColumns= @JoinColumn(name="AUTHOR_ID"))
	private Set<Author> authors;
	
	public Book() {
		
	}

	public Book(String title, String publisher, String isbn) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.isbn = isbn;
	}

	public Book(String title, String publisher, String isbn, Set<Author> authors) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.isbn = isbn;
		this.authors = authors;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", publisher=" + publisher + ", isbn=" + isbn + ", authors="
				+ authors + "]";
	}
	
}
