package org.motechproject.batch.service;

import org.motechproject.batch.exception.BatchException;
import org.motechproject.batch.model.JobExecutionHistoryListDTO;
import org.springframework.stereotype.Service;

/**
 * Interface to perform the trigger operation for all types of jobs
 *
 * @author Naveen
 *
 */
@Service
public interface JobTriggerService {

    /**
     * trigger a job instantly
     *
     * @param jobName
     *            name of the job to be triggered
     * @param date
     */
    long triggerJob(String jobName) throws BatchException;

    /**
     * Returns the execution history for a job
     *
     * @param jobName
     * @return
     * @throws BatchException
     */
    JobExecutionHistoryListDTO getJobExecutionHistory(String jobName)
            throws BatchException;

    /**
     * Restarts the Execution
     *
     * @param jobName
     * @param executionId
     */
    long restart(String jobName, Integer executionId) throws BatchException;

}
