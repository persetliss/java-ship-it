package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private List<T> parcels = new ArrayList<>();
    private int maxWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public boolean addParcel(T parcel) {
        int parcelBoxWeight = 0;
        for (T newParcel : parcels) {
            parcelBoxWeight += newParcel.getWeight();
        }
        if ((parcelBoxWeight + parcel.getWeight()) > maxWeight) {
            System.out.println("Посылка <<" + parcel.getDescription() + ">> не может быть добавлена в коробку. Превышен предельный вес");
            return false;
        } else {
            parcels.add(parcel);
            return true;
        }
    }

    public List<T> getAllParcels() {
        return parcels;
    }
}
