package hibernettapp;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
@WebServlet("/insertion")//it is a link between servlet and jsp files and insertion is a form action in jsp file in insertion
public class insertionservlet extends HttpServlet {//without https it will remain as a class with http it will become servlet
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Scanner scr = new Scanner(System.in);//to collect details from user

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata empty = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = empty.buildSessionFactory();

		Session s = sf.openSession();

		Transaction t = s.beginTransaction();
		
		String name = req.getParameter("name");
		
		String email = req.getParameter("email");
		
		String branch = req.getParameter("branch");
		
		Long phonenum = Long.parseLong(req.getParameter("phonenum"));

		empcrud e = new empcrud(0,name,email,branch,phonenum);

		s.save(e);

		t.commit();
	}
}
