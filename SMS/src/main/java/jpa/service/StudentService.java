package jpa.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public class StudentService implements StudentDAO {
	SessionFactory factory;
	Session session;
	Transaction transaction;

	public void close() {
		session.close();
		factory.close();
	}

	public StudentService() {


		factory =FactoryService.getSessionFactory();
		session = factory.openSession();
		
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		// ------------ Hibernate Named Query -------------
		@SuppressWarnings("unchecked")
		TypedQuery<Student> query = session.getNamedQuery("getAllStudents");

		List<Student> students = query.getResultList();
		return students;

	}

	public Student getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		// ------------ Hibernate Named Query -------------
		@SuppressWarnings("unchecked")
		TypedQuery<Student> query = session.getNamedQuery("get_Student_by_email");
		query.setParameter("email", email);
		List<Student> studentsByEmail = query.getResultList();
		Student studentOfTheEmail = null;
		if (studentsByEmail != null && studentsByEmail.size() == 1) {
			studentOfTheEmail = studentsByEmail.get(0);
		}
		return studentOfTheEmail;

	}

	public boolean validateStudent(String email, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;

		Student s = getStudentByEmail(email);
		if (s != null) {
			flag = password.equals(s.getsPass());
		}
		return flag;

	}

	public boolean registerStudentToCourse(String email, int id) {
		// TODO Auto-generated method stub
		boolean isRegisterd = false;
		Student s = getStudentByEmail(email);
		boolean isAlreadyRegistered = false;
		if (s.getsCourses() != null) {
			for (Course i : s.getsCourses()) {
				if (id == i.getcId()) {
					isAlreadyRegistered = true;
					break;
				}
			}
		}
		if (!isAlreadyRegistered) {
			transaction = session.beginTransaction();

			CourseService cs = new CourseService();
			List<Course> allCourses = cs.getAllCourses();
			Course c = null;
			for (Course temp : allCourses) {
				if (temp.getcId() == id) {
					c = temp;
					isRegisterd=true;
					break;
				}
			}

			if (s.getsCourses() == null) {
				List<Course> newCourses = new ArrayList<Course>();
				newCourses.add(c);
				s.setsCourses(newCourses);
			} else {
				s.getsCourses().add(c);
			}

			session.save(s);
			transaction.commit();

		}
		return isRegisterd;
	}

	public List<Course> getStudentCourses(String email) {
		// TODO Auto-generated method stub
		List<Course> studentCourses = new ArrayList<Course>();
		Student s = getStudentByEmail(email);
		CourseService cs = new CourseService();
		List<Course> allCourses = cs.getAllCourses();
		List<Course> studentEnrolledCourses = s.getsCourses();
		if (studentEnrolledCourses != null) {
			for (Course c : allCourses) {
				for (int i = 0; i < studentEnrolledCourses.size(); i++) {
					if (studentEnrolledCourses.get(i).getcId() == c.getcId()) {
						studentCourses.add(c);
					}
				}
			}
		}

		return studentCourses;
	}

}
