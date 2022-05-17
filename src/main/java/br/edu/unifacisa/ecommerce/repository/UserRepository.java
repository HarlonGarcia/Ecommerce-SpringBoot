package br.edu.unifacisa.ecommerce.repository;
import br.edu.unifacisa.ecommerce.entities.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository(){
        this.users = new ArrayList<>();
    }
    public User addNewUser(User user) {
        users.add(user);
        return user;
    }
    public void deleteUser(int id) {
        User user = this.findUserById(id);
        users.remove(user);
    }
    public List<User> findAllUsers() {
        return users;
    }
    public User findUserById(int id) {
        for (User user: users) {
            if (user.getId() == id) return user;
        }
        return null;
    }
}
