package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {
    private static final int BASE_COST = 2;

    public StandardParcel(String description, String deliveryAddress, int weight, int sendDay) {
        super(description, deliveryAddress, weight, sendDay);
    }

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }
}