package br.edu.unifacisa.ecommerce.services;

import br.edu.unifacisa.ecommerce.entities.User;
import br.edu.unifacisa.ecommerce.enums.UserType;
import br.edu.unifacisa.ecommerce.exceptions.UserAlreadyExistsException;
import br.edu.unifacisa.ecommerce.exceptions.ContentNotFoundException;
import br.edu.unifacisa.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) throws UserAlreadyExistsException {
        if (checkUserExistence(user.getUsername())) {
            userRepository.addNewUser(user);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    public User editUser(User user) throws ContentNotFoundException {
        User userUpdated = userRepository.findByUsername(user.getUsername());
        if (userUpdated != null) {
            userUpdated.setUsername(user.getUsername());
            userUpdated.setPassword(user.getPassword());
            userUpdated.setAddress(user.getAddress());
            return userUpdated;
        }
        throw new ContentNotFoundException("User not found.");
    }

    public boolean deleteUser(String username) throws ContentNotFoundException {
        if (!checkUserExistence(username)) {
            userRepository.deleteUser(findByUsername(username));
            return true;
        }
        throw new ContentNotFoundException("User not found.");
    }

    public String login(String username, String password) throws ContentNotFoundException, IllegalArgumentException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                StringBuilder sb = new StringBuilder();
                long currentTime = Instant.now().toEpochMilli();
                String token = sb.append(currentTime).append("-").append(UUID.randomUUID().toString()).toString();
                user.setToken(token);
                return token;
            }
            throw new IllegalArgumentException("Invalid password");
        }
        throw new ContentNotFoundException("User not found.");
    }

    public boolean checkUserExistence(String username) {
        List<User> allUsers = userRepository.findAll();
        for (User userToVerify: allUsers) {
            if (userToVerify.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkUserType(String username, UserType userType) {
        User user = userRepository.findByUsername(username);
        List<User> allUsers = userRepository.findAll();
        for (User userToVerify: allUsers) {
            if (userToVerify.getUserType() == userType && userToVerify.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String username) throws ContentNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return userRepository.findByUsername(username);
        }
        throw new ContentNotFoundException("User not found.");
    }
}
