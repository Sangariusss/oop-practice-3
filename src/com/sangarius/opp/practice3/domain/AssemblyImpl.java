package com.sangarius.opp.practice3.domain;

import com.sangarius.opp.practice3.persistence.entity.Case;
import com.sangarius.opp.practice3.persistence.entity.Motherboard;
import java.util.ArrayList;
import java.util.List;

public class AssemblyImpl implements Assembly {

    private final List<Component> components = new ArrayList<>();
    private Motherboard motherboard;
    private Case computerCase;

    @Override
    public void addComponent(Component component) {
        components.add(component);
    }

    @Override
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Component component : components) {
            totalPrice += component.getPrice();
        }
        return totalPrice;
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder("Збірка комп'ютера:");

        if (motherboard != null) {
            description.append("\nМатеринська плата: ").append(motherboard.getDescription());
        }

        if (computerCase != null) {
            description.append("\nКорпус: ").append(computerCase.getDescription());
        }

        description.append("\nКомпоненти:");
        for (Component component : components) {
            description.append("\n- ").append(component.getDescription());
        }

        return description.toString();
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public void connectToMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
        List<Component> componentList = getComponents();
        for (Component component : componentList) {
            motherboard.addComponent(component);
        }
    }

    @Override
    public void connectToCase(Case computerCase) {
        this.computerCase = computerCase;
        List<Component> componentList = getComponents();
        for (Component component : componentList) {
            computerCase.addComponent(component);
        }
    }
}
