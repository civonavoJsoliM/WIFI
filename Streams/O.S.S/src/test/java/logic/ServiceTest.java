package logic;

import data.Customer;
import data.Order;
import data.Product;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @ParameterizedTest
    @MethodSource("initialProducts")
    void getProductCheaperThen(List<Product> products, double amount,List<Product> expected) {
        ShopService shopService = new ShopService();
        List<Product> productsCheaperThen = shopService.getProductCheaperThen(products, amount);
        assertEquals(expected, productsCheaperThen);
    }
    static Stream<Arguments> initialProducts() {
        return Stream.of(
                Arguments.of(List.of(
                        new Product(1, "Coca Cola", .99),
                        new Product(2, "Snickers", 1.99),
                        new Product(3, "Heineken", 4.99),
                        new Product(4, "Lenor", 5.99)),
                        2.0,
                        List.of(
                                new Product(1, "Coca Cola", .99),
                                new Product(2, "Snickers", 1.99))),
                Arguments.of(List.of(), .99, List.of()),
                Arguments.of(List.of(
                        new Product(1, "Coca Cola", .99),
                        new Product(2, "Snickers", 1.99),
                        new Product(3, "Heineken", 4.99),
                        new Product(4, "Lenor", 5.99)),
                        .50,
                        List.of()));
    }

    @ParameterizedTest
    @MethodSource("initialCustomer")
    void calculateRevenue(List<Customer> customers, double expected) {
        ShopService shopService = new ShopService();
        double revenue = shopService.calculateRevenue(customers);
        assertEquals(expected, revenue);
    }
    static Stream<Arguments> initialCustomer() {
        return Stream.of(
                Arguments.of(List.of(new Customer("Milos", "Wien", "milos@intellij.com",
                        List.of(new Order(1, LocalDate.now(), 100.0))),
                        new Customer("Stefana", "Klosterneuburg", "stefana@intellij.com",
                                List.of(new Order(2, LocalDate.now(), 100.0))),
                        new Customer("Marina", "Kasidol", "marina@intellij.com",
                                List.of(new Order(3, LocalDate.now(), 100.0)))),
                        300.0),
                Arguments.of(List.of(), 0.0)
        );
    }
}