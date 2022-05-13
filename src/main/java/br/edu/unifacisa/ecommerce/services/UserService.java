package br.edu.unifacisa.ecommerce.services;
import br.edu.unifacisa.ecommerce.entities.User;
import br.edu.unifacisa.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.addNewUser(user);
    }
    public User editUser(User user) {
        User userUpdated = userRepository.findUserById(user.getId());
        userUpdated.setUsername(user.getUsername());
        userUpdated.setPassword(user.getPassword());
        return userUpdated;
    }
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }
}
