package com.sangarius.opp.practice3.console;

import com.sangarius.opp.practice3.domain.Assembly;
import com.sangarius.opp.practice3.domain.AssemblyImpl;
import com.sangarius.opp.practice3.domain.ComputerAssemblyService;
import com.sangarius.opp.practice3.persistence.entity.builders.AudioCardBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.CoolingDeviceBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.MemoryBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.MotherboardBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.ProcessorBuilder;
import com.sangarius.opp.practice3.persistence.entity.builders.VideoCardBuilder;
import com.sangarius.opp.practice3.persistence.entity.enums.Brand;
import com.sangarius.opp.practice3.persistence.entity.enums.FormFactor;
import java.util.Scanner;

public class ComputerBuilderConsole {

    private final ComputerAssemblyService assemblyService;

    public ComputerBuilderConsole(Assembly assembly) {
        this.assemblyService = new ComputerAssemblyService(assembly);
    }

    public static void main(String[] args) {
        Assembly assembly = new AssemblyImpl();
        ComputerBuilderConsole builderConsole = new ComputerBuilderConsole(assembly);
        builderConsole.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Оберіть опцію:");
            System.out.println("1. Додати процесор");
            System.out.println("2. Додати пам'ять");
            System.out.println("3. Додати материнську плату");
            System.out.println("4. Додати відеокарту");
            System.out.println("5. Додати аудіокарту");
            System.out.println("6. Додати систему охолодження");
            System.out.println("7. Переглянути збірку");
            System.out.println("8. Завершити");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addProcessor();
                case 2 -> addMemory();
                case 3 -> addMotherboard();
                case 4 -> addVideoCard();
                case 5 -> addAudioCard();
                case 6 -> addCoolingDevice();
                case 7 -> viewAssembly();
                case 8 -> exit = true;
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private void addProcessor() {
        System.out.println("Введіть назву процесора:");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Введіть бренд процесора (AMD або Intel):");
        String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");
        Brand brand = Brand.valueOf(brandStr);

        System.out.println("Введіть сокет процесора:");
        String socket = new Scanner(System.in).nextLine();

        System.out.println("Введіть ціну процесора:");
        double price = new Scanner(System.in).nextDouble();

        ProcessorBuilder processorBuilder = new ProcessorBuilder()
            .setName(name)
            .setBrand(brand)
            .setSocket(socket)
            .setPrice(price);

        assemblyService.addProcessor(processorBuilder);
    }

    private void addMemory() {
        System.out.println("Введіть назву пам'яті:");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Введіть бренд пам'яті (наприклад Samsung, Kingston):");
        String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");
        Brand brand = Brand.valueOf(brandStr);

        System.out.println("Введіть тип пам'яті (SSD або HDD):");
        String type = new Scanner(System.in).nextLine();

        System.out.println("Введіть обсяг пам'яті в гігабайтах:");
        int capacityGB = new Scanner(System.in).nextInt();

        System.out.println("Введіть ціну пам'яті:");
        double price = new Scanner(System.in).nextDouble();

        MemoryBuilder memoryBuilder = new MemoryBuilder()
            .setName(name)
            .setBrand(brand)
            .setType(type)
            .setCapacityGB(capacityGB)
            .setPrice(price);

        assemblyService.addMemory(memoryBuilder);
    }

    private void addMotherboard() {
        System.out.println("Введіть назву материнської плати (наприклад B550M AORUS ELITE):");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Введіть бренд материнської плати (наприклад Gigabyte, Asus):");
        String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");
        Brand brand = Brand.valueOf(brandStr);

        System.out.println("Введіть форм-фактор материнської плати (наприклад ATX, MICRO_ATX):");
        String formFactorStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");
        FormFactor formFactor = FormFactor.valueOf(formFactorStr);

        System.out.println("Підтримка оверклокінгу? (true або false):");
        boolean overclocking = new Scanner(System.in).nextBoolean();

        MotherboardBuilder motherboardBuilder = new MotherboardBuilder()
            .setName(name)
            .setBrand(brand)
            .setFormFactor(formFactor)
            .setOverclocking(overclocking);

        assemblyService.addMotherboard(motherboardBuilder);
    }

    private void addVideoCard() {
        System.out.println("Введіть назву відеокарти:");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Введіть бренд відеокарти (наприклад Gigabyte, MSI):");
        String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");
        Brand brand = Brand.valueOf(brandStr);

        VideoCardBuilder videoCardBuilder = new VideoCardBuilder()
            .setName(name)
            .setBrand(brand);

        assemblyService.addVideoCard(videoCardBuilder);
    }

    private void addAudioCard() {
        System.out.println("Введіть назву аудіокарти:");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Введіть бренд аудіокарти (Realtek або Creative):");
        String brandStr = new Scanner(System.in).nextLine().toUpperCase().replace(" ", "_");
        Brand brand = Brand.valueOf(brandStr);

        AudioCardBuilder audioCardBuilder = new AudioCardBuilder()
            .setName(name)
            .setBrand(brand);

        assemblyService.addAudioCard(audioCardBuilder);
    }

    private void addCoolingDevice() {
        System.out.println("Введіть назву системи охолодження:");
        String name = new Scanner(System.in).nextLine();

        System.out.println("Система охолодження рідкісна? (true або false):");
        boolean liquidCooling = new Scanner(System.in).nextBoolean();

        CoolingDeviceBuilder coolingDeviceBuilder = new CoolingDeviceBuilder()
            .setName(name)
            .setLiquidCooling(liquidCooling);

        assemblyService.addCoolingDevice(coolingDeviceBuilder);
    }

    private void viewAssembly() {
        String description = assemblyService.getComputerAssembly().getDescription();
        System.out.println(description);
    }
}
