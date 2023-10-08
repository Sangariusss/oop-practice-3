package com.sangarius.opp.practice3.persistence.entity;

import com.sangarius.opp.practice3.domain.Component;
import java.util.ArrayList;
import java.util.List;

public class Case {

    private final String name;
    private final String brand;
    private final String type; // Тип корпусу (наприклад, Mini Tower, Mid Tower, Full Tower)
    private final double price;
    private final List<Component> components; // Список компонентів, встановлених в корпусі

    public Case(String name, String brand, String type, double price) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.components = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return name + " (" + brand + ", " + type + ")";
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public List<Component> getComponents() {
        return components;
    }
}
