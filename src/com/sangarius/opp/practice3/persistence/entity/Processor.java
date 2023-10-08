package com.sangarius.opp.practice3.persistence.entity;

import com.sangarius.opp.practice3.domain.Component;
import com.sangarius.opp.practice3.domain.ConnectToMotherboard;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;

public class Processor implements Component, ConnectToMotherboard {

    private final String name;
    private final Brand brand;
    private final String socket;
    private final double price;

    public Processor(String name, Brand brand, String socket, double price) {
        this.name = name;
        this.brand = brand;
        this.socket = socket;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Процесор " + name + " від " + brand + " (Socket: " + socket + ")";
    }

    @Override
    public void connectToMotherboard(Motherboard motherboard) {
        motherboard.addProcessor(this);
    }
}
