package br.edu.unifacisa.ecommerce.services;

import br.edu.unifacisa.ecommerce.entities.User;
import br.edu.unifacisa.ecommerce.exceptions.UserAlreadyExistsException;
import br.edu.unifacisa.ecommerce.exceptions.ContentNotFoundException;
import br.edu.unifacisa.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    public User editUser(User user) {
        User userUpdated = userRepository.findByUsername(user.getUsername());
        userUpdated.setUsername(user.getUsername());
        userUpdated.setPassword(user.getPassword());
        userUpdated.setAddress(user.getAddress());
        return userUpdated;
    }

    public boolean deleteUser(String username) throws ContentNotFoundException {
        if (!checkUserExistence(username)) {
            userRepository.deleteUser(findByUsername(username));
            return true;
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

    public boolean checkUserType(String username, int userType) {
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
