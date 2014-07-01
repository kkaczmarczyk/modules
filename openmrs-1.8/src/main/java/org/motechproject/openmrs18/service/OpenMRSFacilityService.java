package org.motechproject.openmrs18.service;

import org.motechproject.openmrs18.domain.OpenMRSFacility;

import java.util.List;

/**
 * Interface to save and get facilities (Location)
 */
public interface OpenMRSFacilityService {
    /**
     *  Saves the given facility in the MRS System
     * @param facility  object to be saved
     * @return The saved instance of the facility
     */
    OpenMRSFacility saveFacility(OpenMRSFacility facility);

    /**
     * Gets all the facilities in the MRS system
     * @return List of all available facilities
     */
    List<? extends OpenMRSFacility> getFacilities();

    /**
     * Fetches all facilities that have the given location name
     * @param locationName Value to be used to search
     * @return List of matched facilities
     */
    List<? extends OpenMRSFacility> getFacilities(String locationName);

    /**
     * Fetches facility by facility id (not the MOTECH ID of the facility)
     * @param facilityId Id of the facility to be fetched
     * @return Facility with the given id
     */
    OpenMRSFacility getFacility(String facilityId);

    void deleteFacility(String facilityId);

    OpenMRSFacility updateFacility(OpenMRSFacility facility);
}
