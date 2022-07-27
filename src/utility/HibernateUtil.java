package utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import model.Product;
import model.Student;

public class HibernateUtil {

	private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        // Cấu hình kết nối
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, 
        		"org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, 
        		"com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, 
        		"jdbc:sqlserver://localhost:1433;databaseName=SDB_01_Order;encrypt=true;trustServerCertificate=true;");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "reallyStrongPwd#123");
        properties.put(Environment.SHOW_SQL, "true");
        // tự động tạo DB
        // properties.put(Environment.HBM2DDL_AUTO, "create");

        conf.setProperties(properties);
        
        // Khai báo Class được ánh xạ
        // conf.addAnnotatedClass(Student.class);
        conf.addAnnotatedClass(Product.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFactory() {
        return FACTORY;
    }
}
