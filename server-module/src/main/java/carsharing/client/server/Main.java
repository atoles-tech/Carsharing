package carsharing.client.server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        // Создание конфигурации Hibernate
        Configuration configuration = new Configuration();
        configuration.configure();
        // Читает hibernate.cfg.xml

        // Создание ServiceRegistry
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // Создание SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        // Проверка соединения
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            System.out.println("Соединение с базой данных успешно установлено!");
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
        } finally {
            sessionFactory.close();
        }
    }
}
