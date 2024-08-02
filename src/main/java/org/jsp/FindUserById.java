package org.jsp;

import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class FindUserById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id which you want to find the record");
		int id = sc.nextInt();
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();

		try {
			User user = ses.get(User.class, id);
			System.out.println(user);
		} catch (Exception e) {
			System.err.println("Enter valid id");
		}
	}

}
