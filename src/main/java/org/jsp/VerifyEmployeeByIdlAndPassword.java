package org.jsp;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyEmployeeByIdlAndPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the user Id of the user");
		int id = sc.nextInt();
		
		System.out.println("Enter the password of the user");
		String pw = sc.next();

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();

		Query<User> q = ses.createQuery("select u from User u where u.id=?1 and u.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, pw);//ajm123
		
		try {
			User result = q.getSingleResult();
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Enter Valid Credential");
		}

	}

}
