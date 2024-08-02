package org.jsp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllUsers {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	SessionFactory fac = configuration.buildSessionFactory();//created  the jdbc connection
    	Session ses = fac.openSession();
    	Query<User> q = ses.createQuery("select u from User u");
    	List<User> userslist = q.getResultList();
    	if(userslist.size()>0)
    	{
    		for (User user : userslist) {
				System.out.println(user);
			}
    	}else
    	{
    		System.out.println("No user info found");
    	}
	}

}
