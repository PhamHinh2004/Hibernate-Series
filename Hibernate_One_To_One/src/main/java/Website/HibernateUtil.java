package Website;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	static final SessionFactory sessionFactory = buidSessionFactory();

	private static SessionFactory buidSessionFactory() {
		try {
			return new  Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("cannot get a session factory");
			return null;
		}
	}
	
	public static SessionFactory getSessionFactoy() {
		return sessionFactory;
	}
	
	public static void shutDown() {
		getSessionFactoy().close();
	}
}
