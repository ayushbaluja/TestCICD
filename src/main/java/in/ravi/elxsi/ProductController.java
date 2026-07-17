package in.ravi.elxsi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    private List<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product(101, "Laptop"));
        products.add(new Product(102, "Mobile"));
        products.add(new Product(103, "Hair Dryer"));
        products.add(new Product(104, "CAR"));
        products.add(new Product(105, "Charger"));
        products.add(new Product(106, "ECUs"));
        products.add(new Product(107, "Bike"));
        products.add(new Product(108, "Scooter"));
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "app", "Java Inventory API"
        );
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }
}