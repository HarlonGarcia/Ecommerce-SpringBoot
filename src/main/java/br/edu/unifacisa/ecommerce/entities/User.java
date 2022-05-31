package br.edu.unifacisa.ecommerce.entities;

import br.edu.unifacisa.ecommerce.dto.UserDto;
import br.edu.unifacisa.ecommerce.enums.UserType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 2639917832277755961L;
    private String token;
    private String username;
    private String password;
    private String address;
    private double balance;
    private UserType userType;
    private Cart userCart = new Cart();
    private List<String> userOrders = new ArrayList<>();

    public User(){
    }

    public User(String username, String password, String address, UserType userType){
        this.token = "";
        this.username = username;
        this.password = password;
        this.address = address;
        this.userType = userType;
    }

    public UserDto toDto() {
        return new UserDto(getUsername(), getAddress(), getBalance());
    }

    public void setUserType(int userCode) {
        this.userType = UserType.valueOf(userCode);
    }

    public UserType getUserType() {
        return userType;
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

    public String getToken() {
        return token;
    }

    public void setToken(String id) {
        this.token = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void withDraw(double amount) {
        this.balance -= amount;
    }

    public List<String> getUserOrders() {
        return userOrders;
    }

    public void addOrder(String orderId) {
        userOrders.add(orderId);
    }

    @Override
    public boolean equals(Object userUnchecked) {
        if (this == userUnchecked) return true;
        if (userUnchecked == null || getClass() != userUnchecked.getClass()) return false;
        User user = (User) userUnchecked;
        return Objects.equals(username, user.username) && ((User) userUnchecked).getUserType() == userType;
    }

    public Cart getCart() {
        return userCart;
    }
}
