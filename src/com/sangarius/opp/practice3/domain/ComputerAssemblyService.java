package com.sangarius.opp.practice3.domain;

import com.sangarius.opp.practice3.persistence.entity.AudioCard;
import com.sangarius.opp.practice3.persistence.entity.CoolingDevice;
import com.sangarius.opp.practice3.persistence.entity.Memory;
import com.sangarius.opp.practice3.persistence.entity.Motherboard;
import com.sangarius.opp.practice3.persistence.entity.Processor;
import com.sangarius.opp.practice3.persistence.entity.Ram;
import com.sangarius.opp.practice3.persistence.entity.VideoCard;
import com.sangarius.opp.practice3.persistence.entity.builders.AudioCardBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.CoolingDeviceBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.MemoryBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.MotherboardBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.ProcessorBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.RamBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.VideoCardBuilder;

public class ComputerAssemblyService {

    private final Assembly computerAssembly;

    public ComputerAssemblyService(Assembly computerAssembly) {
        this.computerAssembly = computerAssembly;
    }

    public void addProcessor(ProcessorBuilder processorBuilder) {
        Processor processor = processorBuilder.build();
        computerAssembly.addComponent(processor);
    }

    public void addMemory(MemoryBuilder memoryBuilder) {
        Memory memory = memoryBuilder.build();
        computerAssembly.addComponent(memory);
    }

    public void addMotherboard(MotherboardBuilder motherboardBuilder) {
        Motherboard motherboard = motherboardBuilder.build();
        computerAssembly.addComponent(motherboard);
    }

    public void addVideoCard(VideoCardBuilder videoCardBuilder) {
        VideoCard videoCard = videoCardBuilder.build();
        computerAssembly.addComponent(videoCard);
    }

    public void addAudioCard(AudioCardBuilder audioCardBuilder) {
        AudioCard audioCard = audioCardBuilder.build();
        computerAssembly.addComponent(audioCard);
    }

    public void addCoolingDevice(CoolingDeviceBuilder coolingDeviceBuilder) {
        CoolingDevice coolingDevice = coolingDeviceBuilder.build();
        computerAssembly.addComponent(coolingDevice);
    }

    public void addRam(RamBuilder ramBuilder) {
        Ram ram = ramBuilder.build();
        computerAssembly.addComponent(ram);
    }

    public Assembly getComputerAssembly() {
        return computerAssembly;
    }
}
