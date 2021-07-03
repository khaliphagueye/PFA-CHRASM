package com.gestionH.Service;

import com.gestionH.entities.User;

public interface UserService {

	User findByUsernameOrEmail(String usernameOrEmail);
}