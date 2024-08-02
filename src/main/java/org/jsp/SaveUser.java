package org.jsp;

import org.hibernate.*;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sef = cfg.buildSessionFactory();
		Session ses = sef.openSession();
		Transaction tran = ses.getTransaction();
		tran.begin();

		User u = new User();
		u.setName("mosin");
		u.setPhone(6678543210L);
		u.setEmail("mk@037@gmail.com");
		u.setPassword("mk123");

		ses.save(u);
		tran.commit();
	}

}
