package ru.yandex.practicum;
import ru.yandex.practicum.delivery.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PerishableParcelIsExpiredTest {

    @Test
    public void shouldPerishableParcelNotBeExpiredWhenCurrentDay2() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка",
                "Москва, ул. Льва Толстого 10", 0, 1, 3);
        boolean isExpired = perishableParcel.isExpired(2);
        Assertions.assertFalse(isExpired);
    }

    @Test
    public void shouldPerishableParcelNotBeExpiredWhenCurrentDay4() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка",
                "Москва, ул. Льва Толстого 10", 0, 1, 3);
        boolean isExpired = perishableParcel.isExpired(4);
        Assertions.assertFalse(isExpired);
    }

    @Test
    public void shouldPerishableParcelBeExpiredWhenCurrentDay5() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка",
                "Москва, ул. Льва Толстого 10", 0, 1, 3);
        boolean isExpired = perishableParcel.isExpired(5);
        Assertions.assertTrue(isExpired);
    }

    @Test
    public void shouldPerishableParcelBeExpiredWhenCurrentDay10() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка",
                "Москва, ул. Льва Толстого 10", 0, 1, 3);
        boolean isExpired = perishableParcel.isExpired(10);
        Assertions.assertTrue(isExpired);
    }
}
