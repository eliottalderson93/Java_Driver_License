package com.erik.driver_license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.erik.driver_license.models.Person;
import com.erik.driver_license.repo.DriverRepo;

@Service
public class PeopleService {
	private final DriverRepo dRepo; 
	public PeopleService(DriverRepo dRepo) {
		this.dRepo = dRepo;
	}
	public List<Person> allPeople(){
		return (List<Person>) dRepo.findAll();
	}
	public Person createPerson(Person p) {
		return dRepo.save(p);
	}
	public Person findPerson(Long id) {
		Optional<Person> optPerson = dRepo.findById(id);
		if (optPerson.isPresent()) {
			return optPerson.get();
		}
		else {
			return null;
		}
	}
}
