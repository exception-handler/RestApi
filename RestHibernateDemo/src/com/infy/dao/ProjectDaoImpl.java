package com.infy.dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import com.infy.model.Project;
public class ProjectDaoImpl implements ProjectDao {
	
	@Override
	public void addProject(Project proj) {
		System.out.println("Inside add proj---");
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(proj);
		transaction.commit();
		session.close();
	}

	@Override
	public List<Project> getAllProjects() {
List<Project> projList = new ArrayList<Project>();
		// TODO Auto-generated method stub
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
Query query = session.createQuery("from Project");
		projList = query.list();
		transaction.commit();
		session.close();
		return projList;
	}
		
		}


