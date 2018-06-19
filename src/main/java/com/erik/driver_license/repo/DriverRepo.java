package com.erik.driver_license.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erik.driver_license.models.Person;
@Repository
public interface DriverRepo extends CrudRepository<Person, Long> {

}
