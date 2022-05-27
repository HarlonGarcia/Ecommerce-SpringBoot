package br.edu.unifacisa.ecommerce.enums;

public enum OrderStatus {
    NOT_SHIPPED(1),
    DISPATCHED(2);

    private int code;

    public int getCode() {
        return code;
    }

    private OrderStatus (int code) {
        this.code = code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus orderStatus: OrderStatus.values()) {
            if (orderStatus.getCode() == code) {
                return orderStatus;
            }
        }
        throw new IllegalArgumentException("There is no status with this code!");
    }
}
