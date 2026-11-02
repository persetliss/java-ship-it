package ru.yandex.practicum;
import ru.yandex.practicum.delivery.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParcelBoxWeightLimitTest {

    @Test
    public void shouldAdd5KilosParcelInto10KilosBox() {
        StandardParcel standardParcel = new StandardParcel("Обычная посылка",
                "Москва, ул. Льва Толстого 10", 5000, 1);
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10000);
        boolean result = parcelBox.addParcel(standardParcel);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldAdd10KilosParcelInto10KilosBox() {
        StandardParcel standardParcel = new StandardParcel("Обычная посылка",
                "Москва, ул. Льва Толстого 10", 10000, 1);
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10000);
        boolean result = parcelBox.addParcel(standardParcel);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotAdd11KilosParcelInto10KilosBox() {
        StandardParcel standardParcel = new StandardParcel("Обычная посылка",
                "Москва, ул. Льва Толстого 10", 11000, 1);
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10000);
        boolean result = parcelBox.addParcel(standardParcel);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldAdd5KilosParcelAndThenNotAdd6KilosParcelInto10KilosBox() {
        StandardParcel standardParcel1 = new StandardParcel("Обычная посылка",
                "Москва, ул. Льва Толстого 10", 5000, 1);
        StandardParcel standardParcel2 = new StandardParcel("Обычная посылка",
                "Москва, ул. Льва Толстого 10", 6000, 1);
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(10000);
        boolean firstParcelHasBeenAdded = parcelBox.addParcel(standardParcel1);
        boolean secondParcelHasBeenAdded = parcelBox.addParcel(standardParcel2);

        Assertions.assertTrue(firstParcelHasBeenAdded);
        Assertions.assertFalse(secondParcelHasBeenAdded);
        Assertions.assertEquals(1, parcelBox.getAllParcels().size());
    }
}
