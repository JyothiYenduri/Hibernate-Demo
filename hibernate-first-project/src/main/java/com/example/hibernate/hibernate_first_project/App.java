package com.example.hibernate.hibernate_first_project;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
    	
    	//create configuration
    	Configuration configuration=new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Song.class);

    	//create session factory
    	SessionFactory sessionFactory=configuration.buildSessionFactory();
    	
    	//initialize the session object
    	Session session=sessionFactory.openSession();
    	
        Song song1=new Song();
        
        song1.setId(2);
        song1.setSongName("Teri Meri");
        song1.setArtist("Chinna");
        
        session.beginTransaction();
        session.save(song1);
        session.getTransaction().commit();
        
        System.out.println("song saved...check db...");
    }
}
