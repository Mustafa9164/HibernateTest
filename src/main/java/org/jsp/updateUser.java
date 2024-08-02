package org.jsp;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class updateUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id which you want to update the record");
		int id = sc.nextInt();

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();
		Transaction tran = ses.getTransaction();
		tran.begin();

		User u = new User();
		u.setId(id);
		u.setName("K L Rahul");
		u.setPhone(6986543210L);
		u.setEmail("klr@037@gmail.com");
		u.setPassword("klr123");

		ses.update(u);
		tran.commit();
	}

}
