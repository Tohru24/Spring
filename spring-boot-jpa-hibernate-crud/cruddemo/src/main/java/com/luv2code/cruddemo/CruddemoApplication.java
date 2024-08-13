package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int count = studentDAO.deleteAll();
		System.out.println("Deleted " + count + " students");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Updating student " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		myStudent.setFirstName("John");
		studentDAO.update(myStudent);
		System.out.println("Updated student " + myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Doe");
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudent(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student tempstudent : theStudents) {
			System.out.println(tempstudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		System.out.println("Creating student...");
		Student tempStudent = new Student("Daffy","Duck","daffy@gmail.com");

		System.out.println("Saving student...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Generated id :" + theId);

		System.out.println("Retrieving student with id " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student! " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student("John","Doe","john@gmail.com");
		Student tempStudent2 = new Student("Mary","Anna","mary@gmail.com");
		Student tempStudent3 = new Student("Bonita","Applebum","bonita@gmail.com");

		System.out.println("Saving 3 student objects ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating student...");
		Student tempStudent = new Student("Paul","Doe","paul@gmail.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("Done! Generated id: " + tempStudent.getId());
	}

}
