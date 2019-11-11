package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    public static SessionFactory sessionFactory;

//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
//            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//            return metadata.getSessionFactoryBuilder().build();
//        }
//        return sessionFactory;
//    }
private static StandardServiceRegistry registry;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
}