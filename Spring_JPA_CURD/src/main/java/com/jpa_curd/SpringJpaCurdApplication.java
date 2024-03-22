package com.jpa_curd;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa_curd.Entities.Student;
import com.jpa_curd.Repository.StudentRepo;

@SpringBootApplication
public class SpringJpaCurdApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaCurdApplication.class, args);

		StudentRepo strepo = context.getBean(StudentRepo.class);

		// Student st=new Student();
		// insertMethod
		// st.setName("Rajesh"); st.setAddress("Korea");

		// strepo.save(st);

		/*
		 * GetMethod List<Student> list=(List<Student>) strepo.findAll();
		 * 
		 * list.forEach(stall -> System.out.println(stall));
		 */

		/*
		 * Student st=strepo.findById(1).get(); System.out.println(st);
		 */

		/*
		 * st.setName("Ramesh"); st.setAddress("USA");
		 * 
		 * strepo.save(st); System.out.println("Updated data");
		 */

		/*
		 * strepo.delete(st); System.out.println("Delete successfully");
		 */

		Student s = (Student) strepo.findByName("Rajesh");
		System.out.println(s);

		Student s2 = (Student) strepo.findByAddress("Korea");
		System.out.println(s2);

		Student s3 = (Student) strepo.findByNameAndAddress("Shyam", "Korea");
		System.out.println(s2);

		List<Student> s4 = (List<Student>) strepo.findByNameOrAddress("Ram", "USA");
		s4.forEach(student -> System.out.println(student));

		List<Student> s5 = (List<Student>) strepo.findByAddressIsNull();

		s4.forEach(student1 -> System.out.println(student1));

		List<Student> s6 = (List<Student>) strepo.findByAddressIsNotNull();
		s4.forEach(student3 -> System.out.println(student3));

		List<Student> s7 = (List<Student>) strepo.findByNameLike("Rajesh");
		s4.forEach(student4 -> System.out.println(student4));

		List<Student> s8 = (List<Student>) strepo.findByNameStartingWith("Ra");
		s4.forEach(student5 -> System.out.println(student5));

		boolean f = strepo.existsByName("Rajesh");
		System.out.println(f);

		// Custom query using
		Student su = strepo.getStudentByNameAndAddress("bale", "ktm");
		System.out.println(su);

	}

}
