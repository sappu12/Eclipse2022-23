package jpa.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

public class CourseService implements CourseDAO {

	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		@SuppressWarnings("unchecked")
		TypedQuery<Course> sqlQuery1 = session.getNamedQuery("get_all_courses");

		List<Course> list = sqlQuery1.getResultList();

		session.close();
		factory.close();
		return list;
	}

}
