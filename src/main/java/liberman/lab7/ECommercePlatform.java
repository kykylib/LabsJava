package liberman.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ECommercePlatform {
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Product> products = new HashMap<>();
    private Map<Integer, Order> orders = new HashMap<>();

    public void addUsers(User user){
        users.put(user.getId(),user);
    }

    public void addProducts(Product product){
        products.put(product.getId(), product);
    }

    public Order createOrder(Integer userId, Map<Product, Integer> cart){
        Order order = new Order(orders.size()+1,userId,cart);

        for(Map.Entry<Product, Integer> entry: cart.entrySet()){
            Product product = entry.getKey();
            Integer value = entry.getValue();

            if (products.containsKey(product.getId()) && products.get(product.getId()).getStock() >= value) {

                products.get(product.getId()).setStock(products.get(product.getId()).getStock() - value);
            } else {
                System.out.println("Недостатньо товару на складі для продукту: " + product);
                return null;
            }
        }
        orders.put(order.getId(), order);
        System.out.println("Замовлення успішно зроблено " + order.getOrderDetails());
        User user = users.get(userId);
        user.addToOrderHistory(order);
        return order;
    }

    public void displayAllOrders() {
        for (Order order : orders.values()) {
            System.out.println(order);
        }
    }
    public void displayAllUsers() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
    public void displayAllAvailableProducts() {
        for (Product product: products.values()) {
            System.out.println(product);
        }
    }
    public void getSortedProductsByPrice() {
        List<Product> list = new ArrayList<>();
        for (Product product: products.values()) {
            list.add(product);
        }
        list.sort(Product::compareTo);
        System.out.println("Від дешевих до найдорожчих\n" + list + "\n");

    }
    public List<Product> getSortedProductsByName() {
        List<Product> productList = new ArrayList<>(products.values());
        productList.sort(new NameComparator());
        System.out.println("За назвою\n" + productList);
        return productList;
    }

    public List<Product> getFilteredProductsByStock(int minStock) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getStock() >= minStock) {
                filteredProducts.add(product);
            }
        }
        System.out.println("За кількістю \n" + filteredProducts);
        return filteredProducts;
    }

    public List<Product> recommendProducts(User user) {
        List<Product> recommendedProducts = new ArrayList<>();
        for (Order order : user.getOrderHistory()) {
            for (Map.Entry<Product, Integer> entry : order.getOrderDetails().entrySet()) {
                if (!recommendedProducts.contains(entry.getKey())) {
                    recommendedProducts.add(entry.getKey());
                }
            }
        }
        for (Map.Entry<Product, Integer> entry : user.getCart().entrySet()) {
            if (!recommendedProducts.contains(entry.getKey())) {
                recommendedProducts.add(entry.getKey());
            }
        }
        System.out.println("Рекомендовані товари \n" + recommendedProducts);
        return recommendedProducts;
    }
}
