package com.erik.driver_license.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(updatable=false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private License license;
    
    public Person() {}
    public Person(String fname, String lname) {
    	this.firstName = fname;
    	this.lastName = lname;
    }
    //getters
    public String getFName() {
    	return this.firstName;
    }
    public String getLName() {
    	return this.lastName;
    }
    public License getLicense() {
    	return this.license;
    }
    //setters
    public void setFName(String fname) {
    	this.firstName = fname;
    }
    public void setLName(String lname) {
    	this.lastName = lname;
    }
    @PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
}
