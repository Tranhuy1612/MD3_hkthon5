package ra.model;

import ra.config.InputMethods;


public class Product {
    private String productId;
    private String productName;
    private double productPrice;
    private String description;
    private int stock;
    private Catalog catalog;
    private boolean status = true;

    public Product() {
    }

    public Product(String productId, String productName, double productPrice, String description, int stock, Catalog catalog, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.description = description;
        this.stock = stock;
        this.catalog = catalog;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + "\n"
                + "Product Name: " + productName + "\n"
                + "Product Price: " + productPrice + "\n"
                + "Description: " + description + "\n"
                + "Stock: " + stock + "\n"
                + "Catalog: " + catalog + "\n"
                + "Status: " + (status ? "Bán" : "Không bán");
    }

    public void inputData() {
        System.out.println("Nhập Id sản phẩm : (bắt đầu chữ p và có 4 kí tự)");


        System.out.println("Nhập tên sản phẩm");
        this.productName = InputMethods.getString();
        System.out.println("Nhập giá sản phẩm");
        this.productPrice = InputMethods.getDouble();
        System.out.println("Nhập miêu tả sản phẩm");
        this.description = InputMethods.getString();
        System.out.println("Stock ( hàng dự trữ )");
        this.stock = InputMethods.getInteger();
//        System.out.println("Catalog");
//        this.catalog=InputMethods.getString();
        System.out.println("Status");
        this.status = InputMethods.getBoolean();
    }

    public void displayData() {
        System.out.println("productId :" + productId);
        System.out.println("productName :" + productName + "|productPrice" + productPrice);
        System.out.println("description :" + description + "|stock" + stock);
        System.out.println("Status :" + (status ? "Ban" : "Khong Ban"));
    }

}
