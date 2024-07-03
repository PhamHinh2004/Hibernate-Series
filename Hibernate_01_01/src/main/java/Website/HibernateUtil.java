package Website;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static final SessionFactory sesssionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("cannot dowload");
			return null;
		}
	}

	public static SessionFactory getSesssionFactory() {
		// Tạo danh sách dịch vụ từ file config
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		// Tạo MetaData (siêu dữ liệu) cung cấp các thông tin về DB, charset, vv...
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		// Từ Metadata chúng ta có thể lấy ra SessionFactory, class đảm nhiệm tạo ra
		// Session
		return metadata.getSessionFactoryBuilder().build();

	}

	public void shutDown() {
		getSesssionFactory().close();
	}
}
