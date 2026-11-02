package ru.yandex.practicum;
import ru.yandex.practicum.delivery.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliveryCostTest {

    @Test
    public void shouldReturnZeroCostForStandardParcelWithZeroWeight() {
        StandardParcel standardParcel = new StandardParcel("Обычная посылка",
                "Москва, ул. Льва Толстого 10", 0, 1);
        int cost = standardParcel.calculateDeliveryCost();
        Assertions.assertEquals(0, cost);
    }

    @Test
    public void shouldReturn200CostForStandardParcelWith100Weight() {
        StandardParcel standardParcel = new StandardParcel("Обычная посылка",
                "Москва, ул. Льва Толстого 10", 100, 1);
        int cost = standardParcel.calculateDeliveryCost();
        Assertions.assertEquals(200, cost);
    }

    @Test
    public void shouldReturnZeroCostForFragileParcelWithZeroWeight() {
        FragileParcel fragileParcel = new FragileParcel("Хрупкая посылка",
                "Москва, ул. Льва Толстого 10", 0, 1);
        int cost = fragileParcel.calculateDeliveryCost();
        Assertions.assertEquals(0, cost);
    }

    @Test
    public void shouldReturn400CostForFragileParcelWith100Weight() {
        FragileParcel fragileParcel = new FragileParcel("Хрупкая посылка",
                "Москва, ул. Льва Толстого 10", 100, 1);
        int cost = fragileParcel.calculateDeliveryCost();
        Assertions.assertEquals(400, cost);
    }

    @Test
    public void shouldReturnZeroCostForPerishableParcelWithZeroWeight() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка",
                "Москва, ул. Льва Толстого 10", 0, 1, 5);
        int cost = perishableParcel.calculateDeliveryCost();
        Assertions.assertEquals(0, cost);
    }

    @Test
    public void shouldReturn300CostForPerishableParcelWith100Weight() {
        PerishableParcel perishableParcel = new PerishableParcel("Скоропортящаяся посылка",
                "Москва, ул. Льва Толстого 10", 100, 1, 5);
        int cost = perishableParcel.calculateDeliveryCost();
        Assertions.assertEquals(300, cost);
    }
}

