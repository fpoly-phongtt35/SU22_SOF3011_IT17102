package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import model.Product;
import utility.HibernateUtil;

public class ProductRepository {

	public List<Product> getAll() {
		List<Product> products = null;
		
		SessionFactory factory = HibernateUtil.getFactory();
		Session session = factory.openSession();
		
		Query<Product> query = session
				.createQuery("FROM Product p", Product.class);
		products = query.getResultList();
		
		session.close();
		
		return products;
	}
}
