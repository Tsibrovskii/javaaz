package ru.tsibrovskii.TradeTask;

import java.util.Map;
import java.util.TreeMap;

public class StockExchange {

    private Map<String, MarketDepth> marketDepthMap = new TreeMap<>();

    public void addOrder(Order order) {
        if(!marketDepthMap.keySet().contains(order.getBook())) {
            marketDepthMap.put(order.getBook(), new MarketDepth(order.getBook()));
        }
        marketDepthMap.get(order.getBook()).addOrder(order);
    }

    public void deleteOrder(String id) {
        for(MarketDepth marketDepth : marketDepthMap.values()) {
            if(marketDepth.getOrdersSet().contains(id)) {
                marketDepth.deleteOrderById(id);
                break;
            }
        }
    }

    public void info() {
        for(MarketDepth marketDepth : marketDepthMap.values()) {
            marketDepth.info();
        }
    }
}
