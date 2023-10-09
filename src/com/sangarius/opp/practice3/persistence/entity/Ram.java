package com.sangarius.opp.practice3.persistence.entity;

import com.sangarius.opp.practice3.domain.Component;
import com.sangarius.opp.practice3.domain.ConnectToMotherboard;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;

public class Ram implements Component, ConnectToMotherboard {

    private final String name;
    private final int capacityGB;
    private final Brand brand;
    private final String type; // DDR4, DDR5
    private final double price;

    public Ram(String name, int capacityGB, Brand brand, String type, double price) {
        this.name = name;
        this.capacityGB = capacityGB;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Оперативна пам'ять " + name + " " + capacityGB + "GB " + type;
    }

    @Override
    public void connectToMotherboard(Motherboard motherboard) {
        motherboard.addRam(this);
    }
}
