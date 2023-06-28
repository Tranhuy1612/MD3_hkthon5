package ra.run;

import ra.config.InputMethods;
import ra.model.CartItem;
import ra.model.Catalog;
import ra.model.Product;
import ra.service.CartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    static List<Catalog> catalogs = new ArrayList<>();
    static List<Product> products = new ArrayList<>();
    static List<CartItem> cartItems = new ArrayList<>();


    public static void main(String[] args) {
        while (true) {
            System.out.println("**************************BASIC-MENU************************** \n" +
                    "1. Quản lý danh mục [5 điểm]\n" +
                    "2. Quản lý sản phẩm [5 điểm]\n" +
                    "3. Dành cho người dùng (***)\n" +
                    "4. Thoát");
            System.out.println("Nhap vao lua chon cua ban");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    CatalogManagement();
                    break;
                case 2:
                    ProductManagement();
                    break;
                case 3:
                    MenuUser();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.err.println("khong hop le, thu lai");
            }
        }
    }

    public static void CatalogManagement() {
        byte choice = 0;
        while (choice != 5) {
            System.out.println("********************CATALOG-MANAGEMENT********************\n" +
                    "1. Nhập số danh mục thêm mới và nhập thông tin cho từng danh mục [5 điểm]\n" +
                    "2. Hiển thị thông tin tất cả các danh mục [5 điểm]\n" +
                    "3. Sửa tên danh mục theo mã danh mục [5 điểm]\n" +
                    "4. Xóa danh muc theo mã danh mục (lưu ý ko xóa khi có sản phẩm) [5 điểm]\n" +
                    "5. Quay lại");
            System.out.println("Nhập vào  lựa chọn của bạn");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    createCatalog();
                    break;
                case 2:
                    showCatalog();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 4");
                    break;
            }
        }
    }

    public static void createCatalog() {
        System.out.println("Nhập số danh mục thêm mới ");
        int so = InputMethods.getInteger();
        for (int i = 0; i < so; i++) {
            System.out.println("--------nhập thông tin cho từng danh mục---------");
            Catalog catalog = new Catalog();
            catalog.inputData();
            catalogs.add(catalog);
        }
    }

    public static void showCatalog() {
        System.out.println("********** Hiển thị Catalog **********");
        for (Catalog catalog : catalogs) {
            System.out.println(catalog);
        }
        System.out.println("***************************************");
    }


    public static void ProductManagement() {
        byte choice = 0;
        while (choice != 7) {
            System.out.println("********************PRODUCT-MANAGEMENT********************\n" +
                    "1. Nhập số sản sản phẩm và nhập thông tin sản phẩm [5 điểm]\n" +
                    "2. Hiển thị thông tin các sản phẩm [5 điểm]\n" +
                    "3. Sắp xếp sản phẩm theo giá giảm dần [5 điểm]\n" +
                    "4. Xóa sản phẩm theo mã [5 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi thông tin của sách theo mã sách [10 điểm]\n" +
                    "7. Quay lại");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    ShowProduct();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 7");
                    break;
            }
        }
    }

    public static void createProduct() {
        System.out.println("Nhập số sản phẩm thêm mới ");
        int so = InputMethods.getInteger();
        for (int i = 0; i < so; i++) {
            System.out.println("--------nhập thông tin cho từng sản phẩm---------");
            Product product = new Product();
            product.inputData();
            products.add(product);
        }
    }

    public static void ShowProduct() {
        System.out.println("********** Hiển thị Product **********");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("***************************************");
    }

    public static void MenuUser() {
        CartService cartService = new CartService();
        Scanner scanner = new Scanner(System.in);
        byte choice = 0;
        while (choice != 7) {
            System.out.println("**************************MENU-USER**************************\n" +
                    "1. Xem danh sách sản phẩm\n" +
                    "2. Thêm vào giỏ hàng\n" +
                    "3. Xem tất cả sản phẩm giỏ hàng\n" +
                    "4. Thay đổi số lượng sản phẩm trong giỏ hàng\n" +
                    "5. Xóa 1 sản phẩm trong giỏ hàng\n" +
                    "6. Xóa toàn bộ sản phẩm trong giỏ hàng\n" +
                    "7. Quay lại");
            choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    ShowProduct();
                    break;
                case 2:
                    addToCart(cartService, products, scanner);
                    break;
                case 3:
                    showCartItem();
                    break;
                case 4:
//                    updateCartItemQuantity(cartService, scanner);
                    break;
                case 5:
//                    removeCartItem(cartService, scanner);
                    break;
                case 6:
                    removeAllCartItems(cartService);
                    break;
                case 7:
                    break;
                default:
                    System.err.println("Phải nhâp số từ 1 đến 7");
                    break;
            }
        }
    }

    private static void addToCart(CartService cartService, List<Product> products, Scanner scanner) {
        System.out.print("Nhập mã sản phẩm: ");
        String productId = scanner.nextLine();
        System.out.print("Nhập số lượng: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                selectedProduct = product;
                break;
            }
        }

        if (selectedProduct != null) {
            cartService.addToCart(selectedProduct, quantity);
        } else {
            System.out.println("Sản phẩm không tồn tại!");
        }
    }

    public static void showCartItem() {
        System.out.println("********** Hiển thị sản phẩm trong giỏ hàng **********");
        for (CartItem cartItem : cartItems) {
            System.out.println(cartItem);
        }
        System.out.println("***************************************");
    }

//    private static void updateCartItemQuantity(CartService cartService, Scanner scanner) {
//        System.out.print("Enter cart item ID: ");
//        String cartItemId = scanner.nextLine();
//        System.out.print("Enter new quantity: ");
//        int newQuantity = scanner.nextInt();
//        scanner.nextLine();
//
//        boolean updated = cartService.updateCartItemQuantity(cartItemId, newQuantity);
//        if (updated) {
//            System.out.println("Cart item quantity updated successfully!");
//        } else {
//            System.out.println("Failed to update cart item quantity. Please try again.");
//        }
//    }

    //    private static void removeCartItem(CartService cartService, Scanner scanner) {
//        System.out.print("Enter cart item ID: ");
//        String cartItemId = scanner.nextLine();
//
//        boolean removed = cartService.removeCartItem(cartItemId);
//        if (removed) {
//            System.out.println("Cart item removed successfully!");
//        } else {
//            System.out.println("Failed to remove cart item. Please try again.");
//        }
//    }
//
    private static void removeAllCartItems(CartService cartService) {
        cartService.removeAllCartItems();
        System.out.println("Tất cả sản phẩm đã được xóa!");
    }
}
