package Website;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class CuocHop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tenCuocHop;
	private String diaChi;
	private Date thoiGian;
	
	
	// khi CuocHop là chủ thể sở hữu khi đó sẽ có các quyền I D U C  với NhanVien  
	@ManyToMany(cascade = CascadeType.ALL) // casade đồng thời lưu các gúa trị NhanVien trong danhSachNhanVien
	@JoinTable(name="cuochop_nhanvien", // tạo ra một table mới 
				joinColumns = {@JoinColumn(name="cuochop_id")}, // khóa ngoại 1 là chinh id của CuocHop
				inverseJoinColumns = {@JoinColumn(name="nhanvien_id")} // khóa ngoại 2 là id của NhanVien
	)
	private Set<NhanVien> danhSachNhanVien = new HashSet<NhanVien>();

	public CuocHop() {
		super();
	}

	public CuocHop(int id, String tenCuocHop, String diaChi, Date thoiGian, Set<NhanVien> danhSachNhanVien) {
		super();
		this.id = id;
		this.tenCuocHop = tenCuocHop;
		this.diaChi = diaChi;
		this.thoiGian = thoiGian;
		this.danhSachNhanVien = danhSachNhanVien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenCuocHop() {
		return tenCuocHop;
	}

	public void setTenCuocHop(String tenCuocHop) {
		this.tenCuocHop = tenCuocHop;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}

	public Set<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}

	public void setDanhSachNhanVien(Set<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}
	
	public void addNhanVien(NhanVien nv) {
		this.danhSachNhanVien.add(nv);
	}
	
	
}