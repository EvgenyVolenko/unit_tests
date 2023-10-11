package seminars.first.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return отсортированный по возрастанию и цене список продуктов
     */
    public List<Product> getSortedListProducts() {
        Comparator<Product> compareByCost = Comparator.comparing(Product::getCost);
        return this.products.stream().sorted(compareByCost).collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * @return самый дорогой продукт
     */
    public Product getMostExpensiveProduct() {

        Product product = getProducts().get(0);
        int maxPrice = getProducts().get(0).getCost();
        for (int i = 1; i < getProducts().size(); i++) {
            if (maxPrice < getProducts().get(i).getCost()) {
                maxPrice = getProducts().get(i).getCost();
                product = getProducts().get(i);
            }
        }
        return product;
    }
}