package org.motechproject.openmrs18.resource;

import org.motechproject.openmrs18.rest.HttpException;
import org.motechproject.openmrs18.resource.model.Patient;
import org.motechproject.openmrs18.resource.model.PatientListResult;

public interface PatientResource {

    Patient createPatient(Patient patient) throws HttpException;

    PatientListResult queryForPatient(String term) throws HttpException;

    Patient getPatientById(String patientId) throws HttpException;

    String getMotechPatientIdentifierUuid() throws HttpException;

    void deletePatient(String patientUuid) throws HttpException;

    void updatePatientMotechId(String patientUuid, String newMotechId) throws HttpException;

}
