package Website;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {
	
	private Long id;
	private String title;
	private String detail;
	
	// default constructor
	public Todo() {
		super();
	}

	// full pammeter constructor
	public Todo(Long id, String title, String detail) {
		super();
		this.id = id;
		this.title = title;
		this.detail = detail;
	}

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	
	
}