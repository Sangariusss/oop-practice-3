package com.sangarius.opp.practice3.persistence.entity;

import com.sangarius.opp.practice3.domain.Component;
import com.sangarius.opp.practice3.domain.ConnectToMotherboard;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;

public class Memory implements Component, ConnectToMotherboard {

    private final String name;
    private final int capacityGB;
    private final String type; // SDD, HDD
    private final double price;
    private final Brand brand;

    public Memory(String name, int capacityGB, String type, double price, Brand brand) {
        this.name = name;
        this.capacityGB = capacityGB;
        this.type = type;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Пам'ять " + name + " " + capacityGB + "GB " + type + " " + brand;
    }

    @Override
    public void connectToMotherboard(Motherboard motherboard) {
        motherboard.addMemory(this);
    }
}
