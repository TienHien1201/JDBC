/*Tạo File hibernateutil giống như 1 cái nơi mà chúng ta có thể lấy ra đc những thông tin mà chúng
 * ta đã cấu hình ở hibernate.cfg.xml và chúng ta kết nối đến cơ sở dữ liệu. Nhớ muốn sử dụng đc thì 
 * phải có file hibernate.cfg.xml và đã đc cấu hình rồi thì ta mới sử dụng đc class này để tương tác*/
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Loi khong the tao SessionFactory");
			return null;
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		getSessionFactory().close();
	}
}
