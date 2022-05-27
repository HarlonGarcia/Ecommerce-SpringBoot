package br.edu.unifacisa.ecommerce.enums;

public enum UserType {
    ADMIN(1),
    SELLER(2),
    CLIENT(3);

    private int code;

    public int getCode() {
        return code;
    }

    private UserType(int code) {
        this.code = code;
    }

    public static UserType valueOf(int code) {
        for (UserType userType: UserType.values()) {
            if (userType.getCode() == code) {
                return userType;
            }
        }
        throw new IllegalArgumentException("There is no user type with this code!");
    }
}
