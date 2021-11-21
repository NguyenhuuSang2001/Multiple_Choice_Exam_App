/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import pojo.*;

/**
 *
 * @author PC
 */
public class HibernateUtil {

    private final static SessionFactory FACTORY;

    static {
        Configuration conf = null;

        System.out.println("hi");
        conf = new Configuration();//đọc chả hiểu gì 
        Properties pros = new Properties();
        pros.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        pros.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        pros.put(Environment.URL, "jdbc:mysql://localhost:3306/app_choose");
        pros.put(Environment.USER, "root");
        pros.put(Environment.PASS, "");
        pros.put(Environment.SHOW_SQL, "true");

        conf.setProperties(pros);
        conf.addAnnotatedClass(Users.class);
        conf.addAnnotatedClass(InforTest.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        //Configuration conf = new Configuration().configure();
        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getSessionFactory() {
        return FACTORY;
    }

}
