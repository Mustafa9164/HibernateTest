package org.jsp;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhoneNumberOfAllUsers {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();

		Query<Long> q = ses.createQuery("select u.phone from User u", long.class);
		List<Long> phoneNumbers = q.getResultList();
		if (phoneNumbers.size() > 0) {
			for (long phoneNumber : phoneNumbers) {
				System.out.println(phoneNumber);
			}
		} else {
			System.out.println("No phone number info found.");
		}

	}

}
