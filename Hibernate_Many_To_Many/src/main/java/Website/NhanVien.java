package Website;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class NhanVien {
	
	@Id
	private String id;
	private String hoVaTen;
	private Date dateOfBirthday;
	
	// Mappedby sẽ đánh dấu CuocHop mới là thực thể chủ sở hữu này 
	// khi đó thì sẽ thuộc tính "danhSachCuocHop" sẽ ánh xạ từ danh sách "danhSachNhanVien" 
	@ManyToMany(mappedBy = "danhSachNhanVien")
	private Set<CuocHop> danhSachCuocHop = new HashSet<CuocHop>();

	
	
	public NhanVien() {
		super();
	}



	public NhanVien(String id, String hoVaTen, Date dateOfBirthday, Set<CuocHop> danhSachCuocHop) {
		super();
		this.id = id;
		this.hoVaTen = hoVaTen;
		this.dateOfBirthday = dateOfBirthday;
		this.danhSachCuocHop = danhSachCuocHop;
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



	public Date getDateOfBirthday() {
		return dateOfBirthday;
	}



	public void setDateOfBirthday(Date dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}



	public Set<CuocHop> getDanhSachCuocHop() {
		return danhSachCuocHop;
	}



	public void setDanhSachCuocHop(Set<CuocHop> danhSachCuocHop) {
		this.danhSachCuocHop = danhSachCuocHop;
	}
	
	public void addCuocHop(CuocHop cp) {
		this.danhSachCuocHop.add(cp);
	}
	
}
