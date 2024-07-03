package Website;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		
		// add data into db
		/*
		try {
			session.getTransaction().begin();
			
			//  initiate CuocHop
			CuocHop cuocHop1 = new CuocHop();
			cuocHop1.setDiaChi("Hà Nội");
			CuocHop cuocHop2 = new CuocHop();
			cuocHop2.setDiaChi("TP.HCM");
			
			//  initiate NhanVien
			NhanVien nhanVien1 = new NhanVien();
			nhanVien1.setId("NV1");
			nhanVien1.setHoVaTen("Phạm Văn Hinh");
			NhanVien nhanVien2 = new NhanVien();
			nhanVien2.setId("NV2");
			nhanVien2.setHoVaTen("Đỗ Hùng Dũng");
			
			cuocHop1.addNhanVien(nhanVien1);
			cuocHop1.addNhanVien(nhanVien2);
			
			cuocHop2.addNhanVien(nhanVien1);
			cuocHop2.addNhanVien(nhanVien1);
			
			session.saveOrUpdate(cuocHop1);
			session.saveOrUpdate(cuocHop2);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		
		// get data from db
		try {
			session.getTransaction().begin();
			String sql = "select e from " + NhanVien.class.getName() + " e";
			System.out.println(sql);
//			List<CuocHop> list = session.createQuery(sql, CuocHop.class).getResultList();
			List<NhanVien> list = session.createQuery(sql, NhanVien.class).getResultList();
//			for (CuocHop cuocHop : list) {
//				System.out.println("cuocHop_id: " + cuocHop.getId());
//				Set<NhanVien> listNhanVien = cuocHop.getDanhSachNhanVien();
//				for (NhanVien nhanVien : listNhanVien) {
//					System.out.println("Ten Nhan Vien" + nhanVien.getHoVaTen());
//				}
//			}
			
			for (NhanVien nhanVien : list) {
				System.out.println("Nhanvien_id: "+ nhanVien.getHoVaTen());
				Set<CuocHop> listCuocHop = nhanVien.getDanhSachCuocHop();
				for (CuocHop cuocHop : listCuocHop) {
					System.out.println("CuocHop_id: "+ cuocHop.getId());
				}
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Cannot dowload data");
			session.getTransaction().rollback();
		}
	}
}