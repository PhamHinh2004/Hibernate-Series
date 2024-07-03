package Website;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

//@Entity : đanh dấu đây là một 1 Entity trong database
@Entity
@Data
@Builder
public class Author {
	@Id
	private String author_Id;
	private String name;
	private Date dateOfBirth;
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Book> listBook;

	public Author() {
		super();
	}

	public Author(String author_Id, String name, Date dateOfBirth, List<Book> listBook) {
		super();
		this.author_Id = author_Id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.listBook = listBook;
	}

	public String getAuthor_Id() {
		return author_Id;
	}

	public void setAuthor_Id(String author_Id) {
		this.author_Id = author_Id;
	}

	public List<Book> getListBook() {
		return listBook;
	}

	public void setListBook(List<Book> listBook) {
		this.listBook = listBook;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
