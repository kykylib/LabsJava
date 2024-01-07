package liberman.lab7;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails = new HashMap<>();
    ;
    private double totalPrice = 0;

    public Order(Integer id, Integer userId, Map<Product, Integer> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = orderDetails;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Map<Product, Integer> getOrderDetails() {
        return orderDetails;
    }

    public double getTotalPrice() {
        getOrderDetails().forEach((product, integer) -> {
            if (integer == 1) {
                totalPrice += product.getPrice();
            }
            else {
                totalPrice += product.getPrice() * integer;
            }
        });
        return totalPrice;
    }
}
