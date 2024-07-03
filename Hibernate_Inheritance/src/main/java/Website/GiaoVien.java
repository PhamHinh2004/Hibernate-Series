package Website;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class GiaoVien extends ConNguoi{
	private String monPhuTrach;

	
	
	public GiaoVien() {
	}
	public GiaoVien(String id, String hoVaTen, Date ngaySinh, String monPhuTrach) {
		super(id, hoVaTen, ngaySinh);
		this.monPhuTrach = monPhuTrach;
	}
	public String getMonPhuTrach() {
		return monPhuTrach;
	}
	public void setMonPhuTrach(String monPhuTrach) {
		this.monPhuTrach = monPhuTrach;
	}
	
}
