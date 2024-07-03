package Website;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSesssionFactory();
		/*
		 * Mọi thao tác với DB bắt từ từ một session
		 */

		Session session = sessionFactory.getCurrentSession();
		
/*
 * Truy xuất các giá trị từ database
 * 
 */
//		try {
//			/*
//			 * session phải mở transaction trước khi thực hiện
//			 */
//			session.getTransaction().begin();
//			String jpql = "select e from " +Todo.class.getName() + " e";
//			System.out.println(jpql);
//			
//			
//			/*
//			 * Tạo đối tượng Query
//			 * 
//			 */
//			Query<Todo> query = session.createQuery(jpql, Todo.class);
//			
//			
//			/*
//			 * Thực hiện câu truy vấn 
//			 * 
//			 */
//			List<Todo> todos = query.getResultList();
//			System.out.println(todos.size());
//			for (Todo todo : todos) {
//				System.out.println(todo);
//			}
//			
//			// Commit là thực hiện mọi thay đổi xuống DB nếu có
//            session.getTransaction().commit();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			// Rollback trong trường hợp có lỗi xẩy ra.
//            session.getTransaction().rollback();
//		}
		
/*
 * Thêm một giá trị vào database
 * 
 */
		try {
			session.getTransaction().begin();
			Todo todo = new Todo();
			todo.setDetail("from sunday to friday");
			todo.setTitle("Workout");
			session.save(todo);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error cannot tranfer data down to database");
			session.getTransaction().rollback();
		}
	}
}
