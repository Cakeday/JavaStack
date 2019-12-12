package com.whatever.relationships.services;

import java.util.List;
import java.util.Optional;

import com.whatever.relationships.models.License;
import com.whatever.relationships.repositories.LicenseRepository;

import org.springframework.stereotype.Service;

/**
 * License
 */
@Service
public class LicenseService {

    private final LicenseRepository licenseRepository;
// The below constructor must match the classname!!!
    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    // creates and updates a license
    public License createLicense(License b) {
        return licenseRepository.save(b);
    }

    // returns all the licenses
    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }

    // retrieves a license
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepository.findById(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }



    // deletes a license
    public void deleteLicense(long id) {
    	licenseRepository.deleteById(id);
    }
}