package com.erik.driver_license.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erik.driver_license.models.License;
import com.erik.driver_license.repo.LicenseRepo;

@Service
public class LicenseService {
	private final LicenseRepo licenseRepo;
	public LicenseService(LicenseRepo lrepo) {
		this.licenseRepo = lrepo;
	}
	public List<License> allLicense(){
		return (List<License>) licenseRepo.findAll();
	}
	public License createLicense(License l) {
		return licenseRepo.save(l);
	}
}
