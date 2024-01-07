package liberman.lab7;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ECommerceTest {
    @Test
    public void testOrderCreation() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        User user = new User(1, "John");
        Product laptop = new Product(1, "Laptop", 1200.0, 15);

        ecommercePlatform.addUsers(user);
        ecommercePlatform.addProducts(laptop);

        user.addToCart(laptop, 1);
        Order order = ecommercePlatform.createOrder(user.getId(),user.getCart());

        assertEquals(1, order.getOrderDetails().size());
        assertTrue(order.getOrderDetails().containsKey(laptop));
        assertEquals(user.getId(), order.getUserId());
        assertEquals(1200.0, order.getTotalPrice(), 0.01);
    }

    @Test
    public void testRecommendations() {
        ECommercePlatform ecommercePlatform = new ECommercePlatform();
        User user = new User(1, "John");
        Product laptop = new Product(1, "Laptop", 1200.0, 15);
        Product smartphone = new Product(2, "Smartphone", 800.0, 20);

        ecommercePlatform.addUsers(user);
        ecommercePlatform.addProducts(laptop);
        ecommercePlatform.addProducts(smartphone);

        user.addToCart(laptop, 1);
        List<Product> recommendations = ecommercePlatform.recommendProducts(user);

        assertEquals(1, recommendations.size());
        assertTrue(recommendations.contains(laptop));
    }
}
