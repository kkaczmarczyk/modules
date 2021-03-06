package org.motechproject.batch.service;

import java.util.Map;

import org.motechproject.batch.exception.BatchException;
import org.motechproject.batch.model.BatchJobListDTO;
import org.motechproject.batch.model.CronJobScheduleParam;
import org.motechproject.batch.model.OneTimeJobScheduleParams;

/**
 * Interface to schedule reschedule jobs or update job parameters
 *
 * @author Naveen
 *
 */
public interface JobService {

    /**
     * get list of scheduled jobs
     *
     * @return batchJobListDTO which contains list of BatchJobDTO(contains
     *         fields from BatchJob <code>class</code>)
     */
    BatchJobListDTO getListOfJobs() throws BatchException;

    /**
     * Shedule a new cron job with given job name and cron expression
     *
     * @param params -
     *            <code>CronJobScheduleParam</code> object containing jobName,
     *            paramsMap and cronExpression
     * @throws BatchException
     */
    void scheduleJob(CronJobScheduleParam params) throws BatchException;

    /**
     * Schedule a one time job, to be run once in the future
     *
     * @param params -
     *            <code>OneTimeJobScheduleParams</code> object containing
     *            jobName, paramsMap and date
     * @throws BatchException
     */
    void scheduleOneTimeJob(OneTimeJobScheduleParams params)
            throws BatchException;

    /**
     * Update the job parameters of the scheduled job
     *
     * @param jobName
     *            job name for the job for which parameters to be updated
     * @param paramsMap
     *            List of parameters to be added or changed
     * @throws BatchException
     */
    void updateJobProperty(String jobName, Map<String, String> paramsMap)
            throws BatchException;

    String sayHello();

    /**
     * ReShedule an existing batch job with given job name and cron expression
     *
     * @param jobName
     *            job name for the job to be scheduled
     * @param cronExpression
     *            cron expression for the job (specified for the timely run of
     *            the job)
     * @throws BatchException
     */
    void rescheduleJob(String jobName, String cronExpression);

    /**
     * UnShedule an existing batch job with given job name
     *
     * @param jobName
     *            job name for the job to be scheduled
     * @throws BatchException
     */
    void unscheduleJob(String jobName) throws BatchException;

}
