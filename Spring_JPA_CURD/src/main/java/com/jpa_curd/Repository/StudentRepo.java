package com.jpa_curd.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpa_curd.Entities.Student;

public interface StudentRepo extends JpaRepository<Student,Integer > {
	
	//FindBy Method
	Student findByName(String name);
	
	Student findByAddress(String address);
	
	Student findByNameAndAddress(String name,String address);
	
	List<Student> findByNameOrAddress(String name,String address);

	List<Student> findByAddressIsNull();
	
	List<Student> findByAddressIsNotNull();
	 
	List<Student> findByNameLike(String name);
	
	List<Student> findByNameStartingWith(String ch );
	
	boolean existsByName(String name);
	
	
	//custom queries
	@Query("select u from Student u where u.name=?1 and u.address=?2")
	Student getStudentByNameAndAddress(String nm,String ad);
	
}

