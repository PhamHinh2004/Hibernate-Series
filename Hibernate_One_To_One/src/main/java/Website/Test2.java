package Website;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Test2 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactoy();
		
	      if (sessionFactory == null) {
	            System.out.println("SessionFactory is null. Check your configuration.");
	            return;
	        }

	        Session session = sessionFactory.getCurrentSession();

	        try {
	            session.getTransaction().begin();
	            String hql = "select e from " + Address.class.getName() + " e";
	            System.out.println("Generated HQL query: " + hql);
	            
	            Query<Address> query = session.createQuery(hql, Address.class);
	            List<Address> addresses = query.getResultList();

	            System.out.println("Number of addresses found: " + addresses.size());
	            for (Address address : addresses) {
	                System.out.println("ID of address: " + address.getId());
	                System.out.println("Name: " + address.getPerson().getName());
	                System.out.println("Province: " + address.getProvince());
	                System.out.println("City: " + address.getCity());
	            }

	            session.getTransaction().commit();
	        } catch (Exception e) {
	            System.out.println("Cannot handle your request!!! Exception: " + e.getMessage());
	            e.printStackTrace();
	            if (session.getTransaction() != null) {
	                session.getTransaction().rollback();
	            }
	        } finally {
	            if (session != null && session.isOpen()) {
	                session.close();
	            }
	            if (sessionFactory != null && !sessionFactory.isClosed()) {
	                sessionFactory.close();
	            }
	        }
	}
}
