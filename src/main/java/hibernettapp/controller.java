package hibernettapp;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class controller {

	public static void main(String[] args) {

		Scanner src = new Scanner(System.in);// to implement data from user
		int ch;// example name ch
		do {
			displayname();// to provide security

			System.out.println("Enter your choice");

			ch = Integer.parseInt(src.nextLine());//to print in next line

			switch (ch) {

			case 1:
				insertion();
				break;

			case 2:
				delete();
				break;

			case 3:
				update();
				break;

			case 4:
				getall();
				break;

			case 5:
				getbyid();
				break;

			case 6:
				System.exit(0);// to exit repeated loops
				break;

			default:
				System.out.println("invalid operation");//otherwise it will print invalid
				break;
			}
		} while (ch > 0);//for creating loop to repeat steps
	}

	private static void update() {
		
		Scanner scr = new Scanner(System.in);//to take details from user
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();//to connect this project to backend(sql)

		Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();//to st

		SessionFactory sf = mt.buildSessionFactory();//it contains all sql properties

		Session s = sf.openSession();
		
		System.out.println("Enter id");
		
		int id = scr.nextInt();
		
		Transaction t = s.beginTransaction();
		
		empcrud e = s.get(empcrud.class, id);
		
		if(e!=null) {
			
			System.out.println("Enter name");
			
			e.setName(scr.next());
			
			System.out.println("Enter email");
			
			e.setEmail(scr.next());
			
			System.out.println("Enter branch");
			
			e.setBranch(scr.next());
			
			System.out.println("Enter phonenum");
			
			e.setPhonenum(scr.nextLong());
			
			s.update(e);
			
			t.commit();
			
			System.out.println("Updated Successfully");
			
		}
	}

	private static void getbyid() {
		
		Scanner scr = new Scanner(System.in);//to take details from user
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();//to connect this project to backend(sql)

		Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();//to st

		SessionFactory sf = mt.buildSessionFactory();//it contains all sql properties

		Session s = sf.openSession();
		
		System.out.println("Enter Id: ");
		
		int id = scr.nextInt();
		
		Transaction t = s.beginTransaction();
		
		empcrud e = s.get(empcrud.class, id);
		
		if(e!=null) {
			
			System.out.println("id: "+e.getId());
			
			System.out.println("name: "+e.getName());
			
			System.out.println("email: "+e.getEmail());
			
			System.out.println("branch: "+e.getBranch());
			
			System.out.println("phonenum: "+e.getPhonenum());
		}
		
		t.commit();

	}
//-------------------getall--------------------//
	private static void getall() {
		
		Scanner scr = new Scanner(System.in);//to take details from user
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();//to connect this project to backend(sql)

		Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();//to st

		SessionFactory sf = mt.buildSessionFactory();//it contains all sql properties

		Session s = sf.openSession();//it starts to create database 

		Transaction t = s.beginTransaction();//it starts to send data to sql

		List<empcrud> li = s.createQuery("from empcrud",empcrud.class).list();
		
		t.commit();
		
		for(empcrud e:li) {
			
			System.out.println("id: "+e.getId());
			
			System.out.println("name: "+e.getName());
			
			System.out.println("email: "+e.getEmail());
			
			System.out.println("branch: "+e.getBranch());
			
			System.out.println("phonenum: "+e.getPhonenum());
			
		}
	}
	

	private static void delete() {
		
		Scanner scr = new Scanner(System.in);//to take details from user
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();//to connect this project to backend(sql)

		Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();//to st

		SessionFactory sf = mt.buildSessionFactory();//it contains all sql properties

		Session s = sf.openSession();//it starts to create database 
		
		System.out.println("Enter id:");
		
		int id = scr.nextInt();

		Transaction t = s.beginTransaction();//it starts to send data to sql

		empcrud e = s.get(empcrud.class, id);
		
		s.delete(e);
		
		t.commit();//it shows whether it is inserted or not
		
		System.out.println("Successfully deletd");

	}

	private static void insertion() {
		
		Scanner scr = new Scanner(System.in);//to take details from user
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();//to connect this project to backend(sql)

		Metadata mt = new MetadataSources(ssr).getMetadataBuilder().build();//to st

		SessionFactory sf = mt.buildSessionFactory();//it contains all sql properties

		Session s = sf.openSession();//it starts to create database 

		Transaction t = s.beginTransaction();//it starts to send data to sql

		empcrud e = new empcrud();//to insert the data into table(empcrud table name)
		
		System.out.println("Enter name");//it shows in console what to perform
		
		e.setName(scr.next());
		
		System.out.println("Enter email");
		
		e.setEmail(scr.next());
		
		System.out.println("Enter branch");
		
		e.setBranch(scr.next());
		
		System.out.println("Enter phonenum");
		
		e.setPhonenum(scr.nextLong());
		
		s.save(e);
		
		t.commit();//it shows whether it is inserted or not
		
		System.out.println("Successfully Inserted");
	}

	private static void displayname() {
		System.out.println("________________");//to print the details in console
		System.out.println("\t1.insertion");
		System.out.println("\t2.delete");
		System.out.println("\t3.update");
		System.out.println("\t4.getall");
		System.out.println("\t5.getbyid");
		System.out.println("\t6.exit");
		System.out.println("________________");

	}

}
