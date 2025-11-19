package com.sol.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student 
{
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;

	    private String firstName;
	    private String lastName;
	    private String email;
	    private Double gpa;           // ← changed from Long salary → Double gpa (more suitable)

	    // Constructors
	    public Student() {}

	    public Student(String firstName, String lastName, String email, Double gpa) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.gpa = gpa;
	    }

	    // Getters and Setters
	    public Integer getId() { return id; }
	    public void setId(Integer id) { this.id = id; }

	    public String getFirstName() { return firstName; }
	    public void setFirstName(String firstName) { this.firstName = firstName; }

	    public String getLastName() { return lastName; }
	    public void setLastName(String lastName) { this.lastName = lastName; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public Double getGpa() { return gpa; }
	    public void setGpa(Double gpa) { this.gpa = gpa; }

	    @Override
	    public String toString() {
	        return "Student [id=" + id + ", firstName=" + firstName + 
	               ", lastName=" + lastName + ", email=" + email + 
	               ", gpa=" + gpa + "]";
	    }

}


