package org.jsp;

import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name which you want to find the record");
		String name = sc.nextLine();

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();
		Query<User> q = ses.createQuery("select u from User u where u.name=?1");
		q.setParameter(1, name);

		try {
			User u = q.getSingleResult();
			System.out.println(u);
		} catch (Exception e) {
			System.err.println("Enter valid name");
		}
	}

}
