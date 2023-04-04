package exam.onlineshop.services.impl;

import exam.onlineshop.entities.User;
import exam.onlineshop.entities.impl.DefaultUser;
import exam.onlineshop.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";

    private static final int DEFAULT_USERS_CAPACITY = 10;
    private static DefaultUserManagementService instance;
    private User[] registeredUsers = new DefaultUser[DEFAULT_USERS_CAPACITY];
    private int nbUserRegistered = 0;

    public DefaultUserManagementService() {
    }

    @Override
    public String registerUser(User user) {
        if (getUserByEmail(user.getEmail()) != null) {
            return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
        } else if (user.getEmail().isEmpty() || user.getEmail().isBlank()) {
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }
        registeredUsers[nbUserRegistered++] = user;
        return NO_ERROR_MESSAGE;
    }

    @Override
    public User[] getUsers() {
        User[] allRegisteredUsers = new DefaultUser[registeredUsers.length];
        int idx = 0;
        for (User user:registeredUsers
             ) {
            if (user == null) {
                break;
            }
            allRegisteredUsers[idx++] = user;
        }
        return allRegisteredUsers;
    }

    @Override
    public User getUserByEmail(String userEmail) {
        if (nbUserRegistered == 0) {
            return null;
        }
        for (User user:registeredUsers
             ) {
            if (user == null) {
                return null;
            }
            if (user.getEmail().equals(userEmail)) {
                return user;
            }
        }
        return null;
    }

    public static DefaultUserManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultUserManagementService();
        }
        return instance;
    }

    void clearServiceState() {
        instance = null;
        nbUserRegistered = 0;
        registeredUsers = new DefaultUser[DEFAULT_USERS_CAPACITY];
    }
}
