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