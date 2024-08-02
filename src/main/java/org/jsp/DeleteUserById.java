package org.jsp;

import java.util.Scanner;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class DeleteUserById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id which you want to delete the record");
		int id = sc.nextInt();
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();
		Transaction tran = ses.getTransaction();

		tran.begin();

		User user = ses.get(User.class, id);
		if (user != null) {
			ses.delete(user);
			tran.commit();
			System.out.println("User Deleted sucessfully " + user);
		} else {
			System.out.println("Enter valid id");
		}

	}

}
