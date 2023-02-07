package com.sba.project.SMS;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	// ------Declaring class variables

	private Scanner scannerObj;
	private boolean canRun;

	// ------Declaring objects--------

	private StudentService studentService;
	private CourseService courseService;

	public SMSRunner() {

		scannerObj = new Scanner(System.in);
		courseService = new CourseService();
		studentService = new StudentService();
		canRun = true;
	}

	public void close() {
		System.out.println("Thank you for using our application!");
		studentService.close();
	}

	public static void main(String[] args) {

		SMSRunner sms = new SMSRunner();
		while (sms.canRun) {
			System.out.println("\nStudent Management Sytem is running..\n");
			sms.run();
		}
		sms.close();

	}

	private void run() {
		// Login or quit
		switch (menuOfSMS()) {
		case 1:
			System.out.println("Enter Student Email: ");
			String email = scannerObj.nextLine();
			System.out.println("Enter Student Password: ");
			String pass = scannerObj.nextLine();
			if (isValidStudent(email, pass)) {
				launchStudentMenu(email);
			} else {
				System.out.println("Wrong Credentials");
			}
			break;
		case 2:
			canRun = false;
			System.out.println("Goodbye!");
			break;

		default:
			System.out.println("Invalid menu option!");

		}
	}

	private int menuOfSMS() {
		System.out.println("Are you a(n)");
		System.out.println("\n1.Student\n2.quit");
		System.out.println("Please, enter 1 (or) 2 ");
		String enteredMenuVal = scannerObj.nextLine();
		int menuItemIntVal = 0;
		try {
			menuItemIntVal = Integer.parseInt(enteredMenuVal);
		} catch (Exception e) {
			System.out.println("Invalid number!");
		}
		return menuItemIntVal;
	}

	private boolean isValidStudent(String email, String password) {

		boolean isValidStudent = studentService.validateStudent(email, password);
		if (isValidStudent) {
			System.out.println("\nRegistered courses\n");
			printCourses(studentService.getStudentCourses(email));
		}
		return isValidStudent;
	}

	public void printCourses(List<Course> courses) {
		System.out.printf("%5s%35S%25s\n", "ID", "Course", "Instructor");
		System.out.println("--------------------------------------------------------------------");
		for (Course c : courses) {
			System.out.printf("%5s%35S%25s\n", c.getcId(), c.getcName(), c.getcInstructorName());
		}
	}

	private void launchStudentMenu(String email) {
		System.out.println("\n1.Register to class\n2. Logout\nPlease Enter Selection: ");
		int studentMenuIntValue = 0;
		try {
			studentMenuIntValue = Integer.parseInt(scannerObj.nextLine());
		} catch (Exception e) {
			System.out.println("Invalid number!");
		}

		switch (studentMenuIntValue) {
		case 1: // Registering to new course
			System.out.println("\nAvailabe Courses:\n");
			printCourses(courseService.getAllCourses());

			try {
				System.out.print("\nWhich course?");
				int newlyRegisteringCourseID = Integer.parseInt(scannerObj.nextLine());
				if (studentService.registerStudentToCourse(email, newlyRegisteringCourseID)) {
					System.out.println("\nRegistration is sucessful\n");
				} else {
					System.out.println("\nGiven Course is Already Registered!\n ");
				}
				System.out.println("\nMyClasses:\n");
				printCourses(studentService.getStudentCourses(email));
			} catch (Exception e) {
				System.out.println("Invalid Course number!");
			}
			System.out.println("You have been Signed Out!!");
			break;
		case 2:
			System.out.println("You have been logged out!");
			break;
		default:
			System.out.println("Invalid Menu Item!");
			System.out.println("You have been logged out!");

		}
	
	}

}
