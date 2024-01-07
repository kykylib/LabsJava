package liberman.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private Integer id;
    private String userName;
    private List<Order> orderHistory = new ArrayList<>();

    private Map<Product,Integer> cart = new HashMap<>();

    public User(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void addToCart(Product product, Integer integer){
        cart.put(product,integer);
    }
    public void removeFromCart(Product product){
        cart.remove(product);
    }
    public void changeCount(Product product, Integer integer){
        cart.replace(product,integer);
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addToOrderHistory(Order order) {
        orderHistory.add(order);
    }


}
