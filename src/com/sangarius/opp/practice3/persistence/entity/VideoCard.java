package com.sangarius.opp.practice3.persistence.entity;

import com.sangarius.opp.practice3.domain.Component;
import com.sangarius.opp.practice3.domain.ConnectToMotherboard;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;

public class VideoCard implements Component, ConnectToMotherboard {

    private final String name;
    private final Brand brand;
    private final double price;

    public VideoCard(String name, Brand brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return "Відеокарта " + name + " від " + brand;
    }

    @Override
    public void connectToMotherboard(Motherboard motherboard) {
        motherboard.addVideoCard(this);
    }
}
