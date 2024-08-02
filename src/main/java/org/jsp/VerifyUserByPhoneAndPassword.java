package org.jsp;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyUserByPhoneAndPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone number of the user");
		long pn = sc.nextLong();

		System.out.println("Enter the password of the user");
		String pw = sc.next();

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();

		Query<User> q = ses.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, pn);
		q.setParameter(2, pw);// ajm123

		try {
			User user = q.getSingleResult();
			System.out.println(user);
		} catch (Exception e) {
			System.out.println("Enter valid credential");
		}

	}

}
