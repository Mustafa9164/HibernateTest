package org.jsp;

import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByPhone {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone number of the user whose record you want to fetch:");
		long pn = sc.nextLong();

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();

		Query<User> q = ses.createQuery("select u from User u where u.phone=?1");
		q.setParameter(1, pn);
		try {
			User user = q.getSingleResult();
			System.out.println(user);
		} catch (Exception e) {
			System.out.println("Invalid credintial");
		}
	}

}
