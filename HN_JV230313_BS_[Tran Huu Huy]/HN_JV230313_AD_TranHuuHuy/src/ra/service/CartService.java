package ra.service;

import ra.model.CartItem;
import ra.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    private List<CartItem> cartItems;

    public CartService() {
        cartItems = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) {
        boolean flag = false;
        for (CartItem item : cartItems) {
            if (item.getProduct().getProductId().equals(product.getProductId())) {
                item.setQuantity(item.getQuantity() + quantity);
                flag = true;
                break;
            }
        }
        if (!flag) {

        }
        product.setStock(product.getStock() - quantity);
        System.out.println("Product added to cart successfully!");
    }

    public void removeAllCartItems() {
        for (CartItem item : cartItems) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            product.setStock(product.getStock() + quantity);
        }
        cartItems.clear();
        System.out.println("All cart items removed successfully!");
    }

    private String generateCartItemId() {
        // Generate a unique cart item ID (e.g., using UUID.randomUUID())
        // Return the generated ID
        return "CART_ITEM_ID";
    }


}


