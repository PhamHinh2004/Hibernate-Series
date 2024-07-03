package Website;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String city;
	private String province;
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL) 
	// mappedBy : address là thuộc tính address của Person. Sau khi thêm hay set thì chúng sẽ ánh xạ lẫn nhau
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<Person> persons;

	
	
	public Address() {
		super();
	}

	public Address(Long id, String city, String province, Collection<Person> persons) {
		super();
		this.id = id;
		this.city = city;
		this.province = province;
		this.persons = persons;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Collection<Person> getPersons() {
		return persons;
	}

	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}
	
	
	
}
