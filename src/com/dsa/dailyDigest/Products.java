package com.dsa.dailyDigest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class Products {

    public static void main(String[] args) {

        List<ProductItem> ProductItems = Arrays.asList(
                new ProductItem("P1", "Mobile", 15000),
                new ProductItem("P2", "Mobile", 12000),
                new ProductItem("P3", "Laptop", 55000),
                new ProductItem("P4", "Laptop", 48000),
                new ProductItem("P5", "TV", 30000),
                new ProductItem("P6", "TV", 28000));

        // P1 Mobile 15000
        // P2 Mobile 12000
        // P3 Laptop 55000
        // P4 Laptop 48000
        // P5 TV 30000
        // P6 TV 28000
        Map<String, ProductItem> higherstMap = ProductItems.stream()
                .collect(Collectors.groupingBy(ProductItem::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(ProductItem::getPrice)),
                                Optional::get)));

        for (Entry<String, ProductItem> productItem : higherstMap.entrySet()) {

            System.out.println(productItem.getKey() + " and values is " + productItem.getValue());

        }

    }

}

class ProductItem {
    String id, category;
    double price;

    ProductItem(String i, String c, double p) {
        id = i;
        category = c;
        price = p;
    }

    @Override
    public String toString() {
        return "ProductItem [id=" + id + ", category=" + category + ", price=" + price + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
// highest‑priced product per category.