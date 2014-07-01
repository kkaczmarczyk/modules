package org.motechproject.openmrs18.service;

import org.motechproject.openmrs18.domain.OpenMRSUser;
import org.motechproject.openmrs18.exception.UserAlreadyExistsException;

import java.util.List;
import java.util.Map;

/**
 * Interface to handle MRSUser (staff)
 */
public interface OpenMRSUserService {

    /**
     * Key to obtain {@link MRSUser} from {@link #saveUser(MRSUser)} and {@link #updateUser(MRSUser)}
     */
    String USER_KEY = "mrsUser";

    /**
     * Key to obtain password from {@link #saveUser(MRSUser)} and {@link #updateUser(MRSUser)}
     */
    String PASSWORD_KEY = "password";

    /**
     * Changes the password of the user.
     *
     * @param currentPassword Old password
     * @param newPassword     New password
     */
    void changeCurrentUserPassword(String currentPassword, String newPassword);

    /**
     * Creates a new MRSUser
     *
     * @param mrsUser Instance of the User object to be saved
     * @return A Map containing saved user's data
     * @throws UserAlreadyExistsException Thrown if the user already exists
     */
    Map<String, Object> saveUser(OpenMRSUser mrsUser) throws UserAlreadyExistsException;

    /**
     * Resets the password of a given User
     *
     * @param userId User's unique identifier
     * @return New password
     */
    String setNewPasswordForUser(String userId);

    /**
     * Gets all users present in the MRS system
     *
     * @return List of all Users
     */
    List<OpenMRSUser> getAllUsers();

    /**
     * Finds user by UserName
     *
     * @param userId User's unique Identifier
     * @return The User object, if found.
     */
    OpenMRSUser getUserByUserName(String userId);

    /**
     * Updates User attributes.
     *
     * @param mrsUser MRS User object
     * @return A Map containing saved user's data
     */
    Map<String, Object> updateUser(OpenMRSUser mrsUser);
}
