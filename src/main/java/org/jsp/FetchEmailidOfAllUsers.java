package org.jsp;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchEmailidOfAllUsers {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();

		Query<String> q = ses.createQuery("select u.email from User u", String.class);

		List<String> emails = q.getResultList();

		if (emails.size() > 0) {
			for (String email : emails) {
				System.out.println(email);
			}
		} else {
			System.out.println("No Emails info Found");
		}
	}

}
