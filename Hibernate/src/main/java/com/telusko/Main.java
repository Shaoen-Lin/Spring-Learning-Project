package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setName("Navin");
        a1.setTech("Java");

        // 建立 ServiceRegistry
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml") // 預設路徑可省略
                .build();

        // 建立 Metadata 並加入 Annotated class
        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Alien.class)
                .buildMetadata();

        // 建立 SessionFactory
        SessionFactory factory = metadata.buildSessionFactory();

        // 使用 Hibernate 儲存資料要 Commit the Transaction
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.persist(a1);
            session.getTransaction().commit();
        }

        factory.close();
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
