package exam.onlineshop.services;

import exam.onlineshop.entities.User;

public interface UserManagementService {
    String registerUser(User user);

    User[] getUsers();

    User getUserByEmail(String userEmail);

}
