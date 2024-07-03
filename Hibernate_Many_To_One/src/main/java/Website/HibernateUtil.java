package Website;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("cannot intitiate session factory");
			return null;
		}
	}
	
	
	public static SessionFactory getSeeFactory() {
		return sessionFactory;
	}
	
	public static void shutDown() {
		getSeeFactory().close();
	}
}