package br.edu.unifacisa.ecommerce.repository;

import br.edu.unifacisa.ecommerce.entities.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users;

    public UserRepository(){
        this.users = new ArrayList<>();
    }

    public void addNewUser(User user) {
        users.add(user);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public List<User> findAll() {
        return users;
    }

    public User findByUsername(String username) {
        for (User user: users) {
            if (username.equals(user.getUsername())) return user;
        }
        return null;
    }
}
