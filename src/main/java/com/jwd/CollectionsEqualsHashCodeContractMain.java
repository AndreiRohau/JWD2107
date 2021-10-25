package com.jwd;

import java.util.HashSet;

public class CollectionsEqualsHashCodeContractMain {
    public static void main(String[] args) {
//        Set<String> ints = new HashSet<>();
//        ints.add("3");
//        System.out.println(ints);
//        ints.add("3");
//        System.out.println(ints);
//        ints.add("4");
//        System.out.println(ints);
//        ints.add("4");
//        System.out.println(ints);
//        ints.add("5");
//        System.out.println(ints);

        HashSet<Product> products = new HashSet<>();
        products.add(new Product(1L, "laptop1", "dell1", "v11", 10001d));
        products.add(new Product(1L, "laptop2", "dell2", "v12", 10002d)); // by
        products.add(new Product(1L, "laptop3", "dell3", "v13", 10003d)); // refurbished

        products.forEach(System.out::println);
    }

    static class Product {
        private Long id;
        private String type;
        private String brand;
        private String name;
        private Double price;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Product product = (Product) o;

            if (type != null ? !type.equals(product.type) : product.type != null) return false;
            if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
            if (name != null ? !name.equals(product.name) : product.name != null) return false;
            return price != null ? price.equals(product.price) : product.price == null;
        }

        @Override
        public int hashCode() {
            int result = type != null ? type.hashCode() : 0;
            result = 31 * result + (brand != null ? brand.hashCode() : 0);
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (price != null ? price.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", type='" + type + '\'' +
                    ", brand='" + brand + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        public Product() {
        }

        public Product(Long id, String type, String brand, String name, Double price) {
            this.id = id;
            this.type = type;
            this.brand = brand;
            this.name = name;
            this.price = price;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}
