package com.sangarius.opp.practice3.persistence.entity;

import com.sangarius.opp.practice3.domain.Component;
import com.sangarius.opp.practice3.domain.ConnectToMotherboard;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;
import com.sangarius.opp.practice3.persistence.entity.enums.FormFactor;
import java.util.ArrayList;
import java.util.List;

public class Motherboard implements Component {

    private final String name;
    private final FormFactor formFactor;
    private final boolean overclocking;
    private final Brand brand;
    private final List<Ram> rams;
    private final List<Memory> memories;
    private final List<Component> components; // Список компонентів, підключених до материнської плати
    // обов'язкові
    private Processor processor;
    // не обов'язкові
    private VideoCard videoCard;
    private AudioCard audioCard;

    public Motherboard(String name, FormFactor formFactor, boolean overclocking, Brand brand,
        Processor processor, CoolingDevice coolingDevice, List<Ram> rams, List<Memory> memories) {
        this.name = name;
        this.formFactor = formFactor;
        this.overclocking = overclocking;
        this.brand = brand;
        this.processor = processor;
        this.rams = rams;
        this.memories = memories;
        this.components = new ArrayList<>();
    }

    public double getPrice() {
        return 0.0;
    }

    public String getDescription() {
        return "Материнська плата: " + name + "\n"
            + "Форм-фактор: " + formFactor + "\n"
            + "Підтримка оверклокінгу: " + overclocking + "\n"
            + "Бренд: " + brand + "\n";
    }

    public void addRam(Ram ram) {
        rams.add(ram);
    }

    public void addMemory(Memory memory) {
        memories.add(memory);
    }

    public void addVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    public void addAudioCard(AudioCard audioCard) {
        this.audioCard = audioCard;
    }

    public void addProcessor(Processor processor) {
        this.processor = processor;
    }

    public void addComponent(Component component) {
        components.add(component);

        if (component instanceof ConnectToMotherboard) {
            ((ConnectToMotherboard) component).connectToMotherboard(this);
        }
    }

    public List<Component> getComponents() {
        return components;
    }
}
