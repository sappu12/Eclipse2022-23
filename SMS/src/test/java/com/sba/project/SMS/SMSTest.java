package com.sba.project.SMS;


import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.FactoryService;
import jpa.service.StudentService;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class SMSTest {

	private static SessionFactory sessionFactory;
	private Session session;

	@BeforeAll
	public static void setup() {
		sessionFactory = FactoryService.getSessionFactory();
		System.out.println("SessionFactory created");
	}

	@AfterAll
	public static void tearDown() {
		if (sessionFactory != null)
			sessionFactory.close();
		System.out.println("SessionFactory destroyed");
	}

	@BeforeEach
	public void openSession() {
		session = sessionFactory.openSession();
		System.out.println("Session created");
	}

	@AfterEach
	public void closeSession() {
		if (session != null)
			session.close();
		System.out.println("Session closed\n");
	}

	@Test
	@Order(1)
	public void testvalidateStudent() {
		System.out.println("Running test Validate...");

		StudentService studentservice = new StudentService();
		boolean isValid = studentservice.validateStudent("sbowden1@yellowbook.com", "SJc4aWSU");
		Assertions.assertTrue(isValid);
	}

	@Test
	@Order(2)
	public void getStudentByEmail() {
		System.out.println("Running test Student By Email...");

		StudentService studentservice = new StudentService();
		Student s = studentservice.getStudentByEmail("sbowden1@yellowbook.com");

		Assertions.assertEquals(s.getsName(), "Sonnnie Bowden");
		Assertions.assertEquals(s.getsPass(), "SJc4aWSU");

	}

	@Test
	@Order(4)
	public void getStudentCourses() {
		System.out.println("Running test get Student Registered Courses...");

		StudentService studentservice = new StudentService();
		List<Course> course = studentservice.getStudentCourses("sbowden1@yellowbook.com");
		boolean isPassed = false;
		for (int i = 0; i < course.size(); i++) {
			if (course.get(i).getcId() == 4) {
				isPassed = true;
				break;
			}

		}

		Assertions.assertTrue(isPassed);
	}

	@Test
	@Order(3)
	public void registerStudentToCourse() {
		System.out.println("Running test Student Register to Course...");

		StudentService studentservice = new StudentService();
		boolean isRegister = studentservice.registerStudentToCourse("sbowden1@yellowbook.com", 4);

		if (isRegister) {
			Assertions.assertTrue(isRegister);
		} else {
			Assertions.assertFalse(isRegister);
		}

	}

}
