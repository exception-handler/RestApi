package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.fortis.Doctor;
import com.fortis.RegularDoctor;
import com.fortis.VisitingDoctor;

public class MainClass {

	// load cdg file
	Configuration cfg = new AnnotationConfiguration();
	// Session factory
	SessionFactory factory = cfg.configure().buildSessionFactory();
	// session
	Session session = factory.openSession();
	Session session1 = factory.openSession();
	// transaction
	Transaction t = session.beginTransaction();
	

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		MainClass m = new MainClass();

		while (true) {
			System.out.println("enter choice:");
			System.out.println("1 to add visiting doctor");
			System.out.println("2 to add regular doctor");
			System.out.println("3 to view doctors");
			System.out.println("4 to update doctor name using hql");
			System.out.println("5 to accept specialization from the keyboard and display doc info");
			System.out.println("6 display doc where specialization is cardiologist or pediatrician");

			System.out.println("0 to exit");
			int ch = Integer.parseInt(m.sc.nextLine());
			switch (ch) {
			case 1:
				m.addVisitingDoctor();
				break;
			case 2:
				m.addRegularDoctor();
				break;
			case 3:
				m.getData();
				break;
			case 4:
				m.updateName();
				break;
			case 5:
				m.viewOnSpecialisation();
				break;

			case 6:
				m.displayDocWithSpecialisation();
				break;
			case 0:
				System.exit(0);

			default:
				System.out.println("Wrong choice");
				break;
			}// switch end

		} // while end

	}// main end

	public void addVisitingDoctor() {
		t = session.beginTransaction();

		System.out.println("enter doctor name");
		String name = sc.nextLine();
		System.out.println("enter specialisation");
		String specialization = sc.nextLine();

		System.out.println("enter visitingHours");
		int visitingHours = Integer.parseInt(sc.nextLine());
		System.out.println("enter visitingCharges");
		int visitingCharges = Integer.parseInt(sc.nextLine());

		VisitingDoctor vd = new VisitingDoctor(name, specialization, visitingHours, visitingCharges);

		session.save(vd);

		t.commit();

		System.out.println("------DONE--------");
	}

	public void addRegularDoctor() {
		t = session.beginTransaction();

		System.out.println("enter doctor name");
		String name = sc.nextLine();
		System.out.println("enter specialisation");
		String specialization = sc.nextLine();
		Doctor doctor = new Doctor(name, specialization);
		System.out.println("enter no of leaves");
		int noOfLeaves = Integer.parseInt(sc.nextLine());
		System.out.println("enter salary");
		int salary = Integer.parseInt(sc.nextLine());

		RegularDoctor rd = new RegularDoctor(name, specialization, noOfLeaves, salary);

		session.save(rd);

		t.commit();

		System.out.println("----DONE---");

	}

	public void getData() {

		t = session.beginTransaction();
		Query query = session.createQuery("from Doctor");
		List<Doctor> list = query.list();
		for (Doctor doctor : list) {
			System.out.println(doctor);
			System.out.println(doctor.getdId());
			System.out.println(doctor.getName());
		}
	}

	public void updateName() {
		t = session.beginTransaction();
		System.out.println("enter id to be updated");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("enter new name");
		String name = sc.nextLine();
		Query query = session.createQuery("update Doctor set name=? where dId=?");
		query.setString(0, name);
		query.setInteger(1, id);
		query.executeUpdate();
		t.commit();

	}

	public void viewOnSpecialisation() {
		t = session.beginTransaction();
		System.out.println("enter specialisation");
		String specialisation = sc.nextLine();
		Query query = session.createQuery("from Doctor where specialization=?");
		query.setString(0, specialisation);
		query.executeUpdate();
		t.commit();
	}

	public void displayDocWithSpecialisation() {
		t = session.beginTransaction();
		
		/*Query query = session.createQuery("from Doctor where specialization=? or specialization=?");
		query.setString(0, "cardiologist");
		query.setString(1, "Pediatrician");

		List<Doctor> list = query.list();
		for (Doctor doctor : list) {
			System.out.println(doctor);
			System.out.println(doctor.getdId());
			System.out.println(doctor.getName());
		}*/
		List<String> list=new ArrayList<>();
		list.add("cardiologist");
		list.add("Pediatrician");
		Criteria criteria=session.createCriteria(Doctor.class);
		ArrayList<Doctor> doc=(ArrayList<Doctor>) criteria.add(Restrictions.in("specialization", list)).list();
		for (Doctor doctor : doc) {
			System.out.println(doctor);
			System.out.println(doctor.getdId());
			System.out.println(doctor.getName());
		}
		t.commit();
	}
}
