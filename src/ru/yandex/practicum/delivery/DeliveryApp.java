package ru.yandex.practicum.delivery;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelBox = new ParcelBox<>(2000);
    private static ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(1000);
    private static ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(500);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportParcel();
                    break;
                case 5:
                    showParcelBoxContents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить местоположение посылки");
        System.out.println("5 — Показать содержимое коробки с посылками");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Выберите тип посылки: ");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
        int choice = Integer.parseInt(scanner.nextLine());

        System.out.println("Укажите, что нужно доставить: ");
        String description = scanner.nextLine();
        System.out.println("Напишите адрес доставки: ");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Укажите вес: ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите день отправки одним числом: ");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, deliveryAddress, weight, sendDay);
                allParcels.add(standardParcel);
                standardParcelBox.addParcel(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, deliveryAddress, weight, sendDay);
                allParcels.add(fragileParcel);
                fragileParcelBox.addParcel(fragileParcel);
                trackableParcels.add(fragileParcel);
                break;
            case 3:
                System.out.println("Укажите срок хранения продукта в днях:");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, deliveryAddress,
                        weight, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableParcelBox.addParcel(perishableParcel);
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int deliverySum = 0;
        for (Parcel parcel : allParcels) {
            deliverySum += parcel.calculateDeliveryCost();
        }
        System.out.println("Суммарная стоимость доставки: " + deliverySum);
    }

    private static void reportParcel() {
        System.out.println("Укажите местоположение посылки: ");
        String newLocation = scanner.nextLine();
        for (Trackable trackableParcel : trackableParcels) {
            trackableParcel.reportStatus(newLocation);
        }
    }

    private static void showParcelBoxContents() {
        System.out.println("Выберите тип посылок в коробке: ");
        System.out.println("1 — Стандартная");
        System.out.println("2 — Хрупкая");
        System.out.println("3 — Скоропортящаяся");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                for (StandardParcel parcel : standardParcelBox.getAllParcels()) {
                    System.out.println(parcel.getDescription());
                }
                break;
            case 2:
                for (FragileParcel parcel : fragileParcelBox.getAllParcels()) {
                    System.out.println(parcel.getDescription());
                }
                break;
            case 3:
                for (PerishableParcel parcel : perishableParcelBox.getAllParcels()) {
                    System.out.println(parcel.getDescription());
                }
                break;
            default:
                System.out.println("Похоже, вы ошиблись");
        }
    }
}
