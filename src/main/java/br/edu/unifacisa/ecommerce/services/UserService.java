package br.edu.unifacisa.ecommerce.services;
import br.edu.unifacisa.ecommerce.entities.User;
import br.edu.unifacisa.ecommerce.exceptions.UserAlreadyExistsException;
import br.edu.unifacisa.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) throws UserAlreadyExistsException {
        if (verifyUser(user)) {
            userRepository.addNewUser(user);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    public User editUser(User user) {
        User userUpdated = userRepository.findUserById(user.getId());
        userUpdated.setUsername(user.getUsername());
        userUpdated.setPassword(user.getPassword());
        userUpdated.setAddress(user.getAddress());
        return userUpdated;
    }

    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    public String getAddress(int id) {
        User user = userRepository.findUserById(id);
        return user.getAddress();
    }

    public double getBalance(int id) {
        User user = userRepository.findUserById(id);
        return user.getBalance();
    }

    public boolean verifyUser(User user) throws UserAlreadyExistsException {
        List<User> allUsers = userRepository.findAllUsers();
        for (User userToVerify: allUsers) {
            if (userToVerify.equals(user)) {
                return false;
            }
        }
        return true;
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }
}
