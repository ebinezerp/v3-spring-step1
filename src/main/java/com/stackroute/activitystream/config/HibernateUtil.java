package com.stackroute.activitystream.config;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.stackroute.activitystream.model.Message;

@SuppressWarnings("deprecation")
public class HibernateUtil {

	public static SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		try {
			Configuration config = new Configuration();
			return config.configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("Error in creating SessionFactory object." + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	/*
	 * build the sessionFactory object based on the parameters from
	 * hibernate.cfg.xml file. Also, handle exception if the session factory object
	 * can't be created
	 */
	
	/*
	public static boolean insertMessage(Message message)
	{
		try {
	  SessionFactory sessionFactory=getSessionFactory();
	Session session= sessionFactory.openSession();
	
	Transaction transaction=  session.beginTransaction();
	session.save(message);
	transaction.commit();
	
	return true;
		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e);
			return false;
		}
	}
	
	
	
	public static List<Message> getAllMessages()
	{
		try {
		 SessionFactory sessionFactory=getSessionFactory();
			Session session= sessionFactory.openSession();
			
			Transaction transaction=  session.beginTransaction();
			List<Message> allMessages=session.createQuery("from Message", Message.class).getResultList();
			transaction.commit();
			
		 return allMessages;
		}catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e);
			return null;
		}
	}*/
}

