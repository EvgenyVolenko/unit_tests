package seminars.first.hw;

import seminars.first.model.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShopTest {
    public static void main(String[] args) {

        Shop shop = new Shop();
        List<Product> products= new ArrayList<>();

        Product product;
        String[] names = {"apple", "tomato", "bread", "water"};
        int[] costs = {35, 25, 100, 34};

        for (int i = 0; i < names.length; i++) {
            product = new Product();
            product.setCost(costs[i]);
            product.setTitle(names[i]);
            products.add(product);
        }
        shop.setProducts(products);

        System.out.println("args = " + products.toString());

        System.out.println("Самый дорогой продукт - " + shop.getMostExpensiveProduct());
        System.out.println("args = " + shop.getSortedListProducts().toString());

        assertThat(shop).isNotNull();
        assertThat(shop.getMostExpensiveProduct()).isEqualTo(products.get(2));
        assertThat(shop.getProducts().size()).isEqualTo(4);
        assertThat(shop.getSortedListProducts()).isNotEmpty();
        assertThat(shop.getSortedListProducts().sort());

    }

    /*
     1. Проверить, что магазин хранит верный список продуктов (количество продуктов, состав корзины)
     2. Проверить, что магазин возвращает верный самый дорого продукт getMostExpensiveProduct
     3. Проверить, что магазин возвращает верный отсортированный по цене список продуктов
    */
}




