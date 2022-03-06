package ru.netology.domain;

import java.util.Objects;

public class TShirt extends Product {
    private String brand;
    private String color;
    private String size;

    public TShirt(){
        super();
    }

    public TShirt(long id, String name, int price, String brand, String color, String size) {
        super(id, name, price);
        this.brand = brand;
        this.color = color;
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return brand;
    }

    public void setColor(String color) {
        this.brand = brand;
    }

    public String getSize() {
        return brand;
    }

    public void setSize(String size) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt that = (TShirt) o;
        return Objects.equals(brand, that.brand) &&
                Objects.equals(color, that.color) &&
                Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, color, size);
    }

    @Override
    public String toString() {
        return "Book {" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", price=" + super.getPrice() +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
