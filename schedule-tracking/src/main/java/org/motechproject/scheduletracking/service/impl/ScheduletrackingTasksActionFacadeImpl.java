package org.motechproject.scheduletracking.service.impl;

import org.joda.time.DateTime;
import org.motechproject.commons.date.model.Time;
import org.motechproject.scheduletracking.service.ScheduletrackingTasksActionFacade;
import org.motechproject.scheduletracking.service.EnrollmentRequest;
import org.motechproject.scheduletracking.service.ScheduleTrackingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;


public class ScheduletrackingTasksActionFacadeImpl implements ScheduletrackingTasksActionFacade {

    @Autowired
    private ScheduleTrackingService scheduleTrackingService;

    public void enroll(String externalId, String scheduleName, // NO CHECKSTYLE ParameterNumber
                       String preferredAlertTime, DateTime referenceDate, String referenceTime,
                       DateTime enrolmentDate, String enrollmentTime, String startingMilestoneName) {
        EnrollmentRequest enrollmentRequest = new EnrollmentRequest()
                .setExternalId(externalId)
                .setScheduleName(scheduleName)
                .setPreferredAlertTime(new Time(preferredAlertTime))
                .setReferenceDate(referenceDate.toLocalDate())
                .setReferenceTime(new Time(referenceTime))
                .setEnrollmentDate(enrolmentDate.toLocalDate())
                .setEnrollmentTime(new Time(enrollmentTime))
                .setStartingMilestoneName(startingMilestoneName);

        scheduleTrackingService.enroll(enrollmentRequest);
    }

    public void unenroll(String externalId, String scheduleName) {
        scheduleTrackingService.unenroll(externalId, Arrays.asList(scheduleName));
    }
}
