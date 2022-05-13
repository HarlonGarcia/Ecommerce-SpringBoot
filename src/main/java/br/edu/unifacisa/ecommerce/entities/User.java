package br.edu.unifacisa.ecommerce.entities;
import java.io.Serializable;
public class User implements Serializable {
    private static final long serialVersionUID = 2639917832277755961L;
    private Long id;
    private String username;
    private String password;

    public User(){
    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
