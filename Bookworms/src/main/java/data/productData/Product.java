package data.productData;

public record Product(int productId, String title, String author, double price) {
    @Override
    public String toString() {
        return "Product ID: " + productId + " | " +
                "Title: " + title + " | " +
                "Author: " + author + " | " +
                "Price: " + price + "€";
    }
}
