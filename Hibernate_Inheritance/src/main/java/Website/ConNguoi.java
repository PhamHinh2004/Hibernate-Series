package Website;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ConNguoi {
	
	@Id
	private String id;
	private String hoVaTen;
	private Date ngaySinh;
	
	public ConNguoi() {
		super();
	}

	public ConNguoi(String id, String hoVaTen, Date ngaySinh) {
		super();
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	
}