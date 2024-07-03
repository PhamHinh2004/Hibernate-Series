package Website;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSession();
		Session session = sessionFactory.getCurrentSession();
		try {
			session.getTransaction().begin();
			GiaoVien gv = new GiaoVien("GV01", "Nguyen Van A",new Date(100, 1, 30), "hibernate");
			SinhVien sv = new SinhVien("07123", "Sinh viên 1", new Date(105, 2, 15), 9.8);
			
//			session.save(gv);
//			System.out.println("1");
			session.save(sv);
			System.out.println("1");
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Cannot save data");
			session.getTransaction().rollback();
		}
	}
}
