package com.erik.driver_license.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "licenses")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private LocalDateTime expiration_date;
    private String state;
    @Column(updatable=false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    public License() {}
    public License(String num, LocalDateTime exp, String State) {
    	this.number = num;
    	this.expiration_date = exp;
    	this.state = State;
    }
    //getters
    public String getNum() {
    	return this.number;
    }
    public LocalDateTime getExpiration() {
    	return this.expiration_date;
    }
    public String getState() {
    	return this.state;
    }
    //setters
    public void setNum(String num) {
    	this.number = num;
    }
    public void setExpiration(LocalDateTime exp) {
    	this.expiration_date = exp;
    }
    public void setState(String State) {
    	this.state = State;
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