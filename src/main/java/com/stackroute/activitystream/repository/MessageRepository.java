package com.stackroute.activitystream.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.stackroute.activitystream.config.HibernateUtil;
import com.stackroute.activitystream.model.Message;

/*
 * This class contains the code for database interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */
public class MessageRepository {
	
	SessionFactory sessionFactory;
	
	public MessageRepository() {
		/*
		 * create a hibernate session from HibernateUtil
		 */
		sessionFactory=HibernateUtil.getSessionFactory();
		
	}
	
	/*
	 * This method is used to save messages in database
	 */ 
	
	public boolean sendMessage(Message message) {
		
		try {
		 Session session=sessionFactory.openSession();
		 Transaction tx=session.beginTransaction();
		 session.save(message);
		 tx.commit();
			return true;
		}catch(Exception e)
		{
		return false;
		}

		
	}
	
	/*
	 * This method is used to retrieve all messages in database
	 */
	public List<Message> getAllMessages(){
		
		try {
			 
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
	}
}
