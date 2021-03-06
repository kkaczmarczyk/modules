package org.motechproject.alerts.contract;

import org.motechproject.alerts.domain.AlertStatus;
import org.motechproject.alerts.domain.UpdateCriterion;

import java.util.HashMap;
import java.util.Map;

/**
 * \ingroup Alerts

 * Maintains the fields of alert to be updated and the new values for the them
 */
public class UpdateCriteria {

    private Map<UpdateCriterion, Object> allCriteria = new HashMap<UpdateCriterion, Object>();

    public UpdateCriteria() {
    }

    /**
     * Gets all the update criteria that have been added so far
     *
     * @return A map with criterion type as key and new value for the field as value
     */
    public Map<UpdateCriterion, Object> getAll() {
        return allCriteria;
    }

    /**
     * Marks that status field of alert is to be updated and stores the new value
     *
     * @param newStatus New value for the status field of alert
     * @return Instance with the current criterion added to it.
     */
    public UpdateCriteria status(AlertStatus newStatus) {
        allCriteria.put(UpdateCriterion.STATUS, newStatus);
        return this;
    }

    /**
     * Marks that name field of alert is to be updated and stores the new value
     *
     * @param newName New value for the name field of alert
     * @return Instance with the current criterion added to it.
     */
    public UpdateCriteria name(String newName) {
        allCriteria.put(UpdateCriterion.NAME, newName);
        return this;
    }

    /**
     * Marks that description field of alert is to be updated and stores the new value
     *
     * @param newDescription New value for the description field of alert
     * @return Instance with the current criterion added to it.
     */
    public UpdateCriteria description(String newDescription) {
        allCriteria.put(UpdateCriterion.DESCRIPTION, newDescription);
        return this;
    }

    /**
     * Marks that priority field of alert is to be updated and stores the new value
     *
     * @param newPriority New value for the priority field of alert
     * @return Instance with the current criterion added to it.
     */
    public UpdateCriteria priority(int newPriority) {
        allCriteria.put(UpdateCriterion.PRIORITY, newPriority);
        return this;
    }

    /**
     * Marks that data field of alert is to be updated and stores the new value
     *
     * @param newData New property => value pairs to be added / updated to the data field of alert
     * @return Instance with the current criterion added to it.
     */
    public UpdateCriteria data(Map<String, String> newData) {
        allCriteria.put(UpdateCriterion.DATA, newData);
        return this;
    }

    @Override
    public String toString() {
        return "UpdateCriteria" + allCriteria;
    }
}
