import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Product;
import utility.HibernateUtil;

public class Application {
	
	public static void main(String[] args) {
		Product p = new Product();
		p.setId(5004); 
		p.setName("New New");
		p.setPrice(BigDecimal.valueOf(1000));
		p.setQuantity(1000);
		
		//add(p);
		//update(p);
		//delete(p);
		//read();
//		Product pp = read(5000);
//		System.out.println(pp);
		
		List<Product> products = read("%pp%");
		for(Product product : products) {
			System.out.println(product);
		}
	}
	
	public static List<Product> read(String name) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Query<Product> query = session.createQuery(
				"FROM Product p WHERE p.name LIKE :name", Product.class);
		query.setParameter("name", name);
		List<Product> products = query.getResultList();
		session.close();
		return products;
	}
	
	public static Product read(Integer id) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Product product = session.find(Product.class, id);
		session.close();
		return product;
	}
	
	public static void delete(Product product) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(product);
		trans.commit();
		session.close();
	}
	
	public static void update(Product product) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(product);
		trans.commit();
		session.close();
	}
	
	public static void add(Product product) {
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(product);
		trans.commit();
		session.close();
	}
	
	public static void read() {
		SessionFactory factory = HibernateUtil.getFactory();
		// SQL Server -> Ấn nút New Query
		Session session = factory.openSession();
		
		Query<Product> query = session.createQuery(
				"SELECT p FROM Product p", Product.class);
		List<Product> products = query.getResultList();
		for(Product product : products) {
			System.out.println(product);
		}
		
		session.close();
	}
}
