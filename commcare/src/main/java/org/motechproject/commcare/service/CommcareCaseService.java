package org.motechproject.commcare.service;

import org.motechproject.commcare.domain.CaseInfo;
import org.motechproject.commcare.domain.CaseTask;
import org.motechproject.commcare.domain.CasesInfo;
import org.motechproject.commcare.response.OpenRosaResponse;

import java.util.List;
/**
 * This service provides two main features: Interacting with CommCareHQ's programmatic case APIs and uploading case XML wrapped in a form instance to CommCareHQ.
 *
 */
public interface CommcareCaseService {

    /**
     * Query CommCareHQ for a case by its case id and user id.
     * @param caseId The id of the case on CommCareHQ
     * @param userId The user id from CommCareHQ
     * @return A CaseInfo object representing the state of the case or null if that case does not exist.
     */
    CaseInfo getCaseByCaseIdAndUserId(String caseId, String userId);

    /**
     * Query CommCareHQ for a case by its case id.
     * @param caseId The id of the case on CommCareHQ
     * @return A CaseInfo object representing the state of the case or null if that case does not exist.
     */
    CaseInfo getCaseByCaseId(String caseId);

    /**
     * Query CommCareHQ for all cases of a given case type and page.
     * @param type The type of case on CommCareHQ
     * @param pageSize
     * @param pageNumber
     * @return A list of CaseInfo objects representing cases of the given type and page found on the configured domain of CommCareHQ
     */
    List<CaseInfo> getCasesByType(String type, Integer pageSize, Integer pageNumber);

    /**
     * Query CommCareHQ for all cases under a given user id.
     * @param userId The user id from CommCareHQ
     * @param pageSize
     * @param pageNumber
     * @return A list of CaseInfo objects representing cases under the given user id and page found on the configured domain of CommCareHQ
     */
    List<CaseInfo> getCasesByUserId(String userId, Integer pageSize, Integer pageNumber);

    /**
     * Query CommCareHQ for all cases of a given case type, user id and page.
     * @param userId The user id from CommCareHQ
     * @param type The type of case on CommCareHQ
     * @param pageSize
     * @param pageNumber
     * @return A list of CaseInfo objects representing cases of the given type, user id and page found on the configured domain of CommCareHQ
     */
    List<CaseInfo> getCasesByUserIdAndType(String userId, String type, Integer pageSize, Integer pageNumber);

    /**
     * Query CommCareHQ for all cases of a given page.
     * @param pageSize
     * @param pageNumber
     * @return A list of CaseInfo objects representing cases of the given page found on the configured domain of CommCareHQ
     */
    List<CaseInfo> getCases(Integer pageSize, Integer pageNumber);

    /**
     * Query CommCareHQ for all cases of the given page and cases metadata
     * @param pageSize
     * @param pageNumber
     * @return CasesInfo wrapper, containing CaseInfo objects and case metadata from CommCareHQ
     */
    CasesInfo getCasesWithMetadata(Integer pageSize, Integer pageNumber);

    /**
     * Query CommCareHQ for all cases of a given case name, page and cases metadata.
     * @param caseName The case name of case on CommCareHQ
     * @param pageSize
     * @param pageNumber
     * @return CasesInfo wrapper, containing CaseInfo objects and case metadata from CommCareHQ
     */
    CasesInfo getCasesByCasesNameWithMetadata(String caseName, Integer pageSize, Integer pageNumber);

    /**
     * Query CommCareHQ for all cases of a given date modified range, page and cases metadata.
     * @param dateModifiedStart
     * @param dateModifiedEnd
     * @param pageSize
     * @param pageNumber
     * @return CasesInfo wrapper, containing CaseInfo objects and case metadata from CommCareHQ.
     */
    CasesInfo getCasesByCasesTimeWithMetadata(String dateModifiedStart, String dateModifiedEnd, Integer pageSize, Integer pageNumber);

    /**
     * Query CommCareHQ for all cases of a given case name, date modified range, page and cases metadata.
     * @param caseName The case name of case on CommCareHQ
     * @param dateModifiedStart
     * @param dateModifiedEnd
     * @param pageSize
     * @param pageNumber
     * @return CasesInfo wrapper, containing CaseInfo objects and case metadata from CommCareHQ
     */
    CasesInfo getCasesByCasesNameAndTimeWithMetadata(String caseName, String dateModifiedStart, String dateModifiedEnd, Integer pageSize, Integer pageNumber);

    /**
     * Upload case xml wrapped in a minimal xform instance to CommCareHQ.
     * @param caseTask An object representing the case information and case actions to be submitted as case xml
     * @return An informational object representing the status, nature and message of the response from CommCareHQ when attempting to upload this instance of case xml. Returns null if your case xml was incorrect.
     */
    OpenRosaResponse uploadCase(CaseTask caseTask);
}
