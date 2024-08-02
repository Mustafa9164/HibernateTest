package org.jsp;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByEmail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Email of the user whose record you want to fetch:");
		String em = sc.next();

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();

		Query<User> q = ses.createQuery("select u from User u where u.email=?1");
		q.setParameter(1, em);

		try {
			User result = q.getSingleResult();
			System.out.println(result);
		} catch (Exception e) {
			System.err.println("Enter valid Email id");
		}
	}

}
