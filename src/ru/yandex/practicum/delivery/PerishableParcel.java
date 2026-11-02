package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int timeToLive;
    private static final int BASE_COST = 3;

    public PerishableParcel(String description, String deliveryAddress, int weight, int sendDay, int timeToLive) {
        super(description, deliveryAddress, weight, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    protected int getBaseCost() {
        return BASE_COST;
    }

    public boolean isExpired(int currentDay) {
        if ((sendDay + timeToLive) >= currentDay) {
            return false;
        } else {
            return true;
        }
    }
}
