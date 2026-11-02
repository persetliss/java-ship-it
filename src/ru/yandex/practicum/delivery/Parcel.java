package ru.yandex.practicum.delivery;

public abstract class Parcel {
    protected String description;
    protected String deliveryAddress;
    protected int weight;
    protected int sendDay;

    public Parcel(String description, String deliveryAddress, int weight, int sendDay) {
        this.description = description;
        this.deliveryAddress = deliveryAddress;
        this.weight = weight;
        this.sendDay = sendDay;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + description + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + description + ">> доставлена по адресу " + deliveryAddress);
    }

    protected abstract int getBaseCost();

    public int calculateDeliveryCost() {
        return weight * getBaseCost();
    }
}
