package ru.tsibrovskii.TradeTask;

import org.junit.Test;

public class StockExchangeTest {

    @Test
    public void BDDTest() {
        StockExchange stockExchange = new StockExchange();
        stockExchange.addOrder(new Order("first", "beeline", "ask", 10, 5));
        stockExchange.addOrder(new Order("second", "beeline", "ask", 10, 7));
        stockExchange.addOrder(new Order("third", "beeline", "bid", 9, 7));
        stockExchange.addOrder(new Order("fourth", "beeline", "bid", 10, 7));
        stockExchange.addOrder(new Order("fifth", "beeline", "bid", 11, 7));

        stockExchange.addOrder(new Order("order1", "mts", "bid", 10, 7));
        stockExchange.addOrder(new Order("order2", "mts", "bid", 10, 7));
        stockExchange.deleteOrder("order1");

        stockExchange.info();
    }
}
