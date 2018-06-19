package com.erik.driver_license.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erik.driver_license.models.License;
@Repository
public interface LicenseRepo extends CrudRepository<License, Long> {
	
}
