package Website;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactoy();
		Session session = sessionFactory.getCurrentSession();
		try {
			
			session.getTransaction().begin();
//			Person person = new Person();
//			person.setName("Pham Van Hinh");
//			
//			session.save(person);
//			
//			Address address = new Address();
//			address.setCity("Nam Định");
//			address.setProvince("Nam Định");
//			
//			session.save(address);
//			
			
			Person person = session.find(Person.class, 1L);
			Address address = session.find(Address.class, 1L);
			address.setPerson(person);
			session.saveOrUpdate(address);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("cannot insert data into database");
			session.getTransaction().rollback();
		}
	}
}