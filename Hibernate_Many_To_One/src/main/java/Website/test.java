package Website;


import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSeeFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
//		try {
//			session.getTransaction().begin();
//			Author author1 = new Author("author01", "Pham Van Hinh", new Date(System.currentTimeMillis()));
//			Book book1 = new Book("book1", "Work of Life", 2000, author1);
//			Book book2 = new Book("book2", "Working Life", 3000, author1);
//			session.saveOrUpdate(author1);
//			session.saveOrUpdate(book1);
//			session.saveOrUpdate(book2);
//			
//			
//			Author author2 = new Author("author02", "Đề Cao", new Date(System.currentTimeMillis()));
//			Book book3 = new Book("book3", "Funny Trip", 2000, author2);
//			Book book4 = new Book("book4", "Wild Animals", 3000, author2);
//			session.saveOrUpdate(author2);
//			session.saveOrUpdate(book3);
//			session.saveOrUpdate(book4);
//			
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			System.out.println("Không thể tạo");
//			session.getTransaction().rollback();
//		}
		
//		try {
//			session.getTransaction().begin();
//			Author author = new Author();
//			author.setAuthor_Id("authorid");
//			author.setName("HCM");
//			Book book1 = new Book();
//			book1.setBook_id("b2");
//			book1.setAuthor(author);
////			session.save(author);
//			session.save(book1);
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("cannot push data into database");
//			session.getTransaction().rollback();
//		}
		
		
		try {
			session.getTransaction().begin();
//			String sql = "select e from "+ Author.class.getName() + " e";
//			System.out.println("sql : " + sql);
//			List<Author> authors = session.createQuery(sql, Author.class).getResultList();
//			for (Author author : authors) {
//				System.out.println("2s");
//				List<Book> books = author.getListBook();
//				for (Book book : books) {
//					System.out.println("id: " + book.getBook_id());
//				}
//			}
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("cannot push data into database");
			session.getTransaction().rollback();
		}
	}
}
