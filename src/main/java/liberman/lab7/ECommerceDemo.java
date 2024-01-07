package liberman.lab7;

public class ECommerceDemo {
    public static void main(String[] args) {
        User user1 = new User(1,"Nik");
        User user2 = new User(2,"Lera");
        User user3 = new User(3, "Vlad");

        Product product1 = new Product(1,"Iphone 15",1499.99,100);
        Product product2 = new Product(2, "Lenovo Legion", 1249.99, 235);
        Product product3 = new Product(3, "RTX3070 TI PALIT GAMEROCK", 799.99,130);

        ECommercePlatform eCommercePlatform = new ECommercePlatform();
        eCommercePlatform.addUsers(user1);
        eCommercePlatform.addUsers(user2);
        eCommercePlatform.addUsers(user3);

        eCommercePlatform.addProducts(product1);
        eCommercePlatform.addProducts(product2);
        eCommercePlatform.addProducts(product3);

        eCommercePlatform.getSortedProductsByPrice();
        eCommercePlatform.getSortedProductsByName();
        eCommercePlatform.getFilteredProductsByStock(150);

        user1.addToCart(product1,3);
        user1.addToCart(product2,1);
        user1.changeCount(product1,2);

        eCommercePlatform.createOrder(user1.getId(),user1.getCart());

        eCommercePlatform.recommendProducts(user1);

    }
}
