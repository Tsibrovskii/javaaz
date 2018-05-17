package ru.tsibrovskii.TradeTask;

import java.util.*;

public class MarketDepth {

    private String name;

    private final String typeAdd = "add";
    private final String typeDelete = "delete";
    private final String actionAsk = "ask";
    private final String actionBid = "bid";
    private final Integer negative = -1;

    private Map<String, Order> askOrdersMap = new TreeMap<>();
    private Map<String, Order> bidOrdersMap = new TreeMap<>();
    private Map<Integer, Volumes> volumesMap = new TreeMap<>(Collections.reverseOrder());

    /**
     * Конструктор класса.
     * @param name идентификатор ценной бумаги.
     */
    public MarketDepth(String name) {
        this.name = name;
    }

    /**
     * Метод, возвращающий сет идентифиаторов всех заявок.
     * @return set id.
     */
    public Set<String> getOrdersSet() {
        Set<String> ordersIdSet = new TreeSet<>();
        ordersIdSet.addAll(askOrdersMap.keySet());
        ordersIdSet.addAll(bidOrdersMap.keySet());
        return ordersIdSet;
    }

    /**
     * Метод добавления ордеров.
     * @param order ордер.
     */
    public void addOrder(Order order) {
        Boolean isContinue = recalculateOrders(order);
        if(isContinue) {
            if (actionAsk.equals(order.getAction())) {
                askOrdersMap.put(order.getId(), order);
            } else if (actionBid.equals(order.getAction())) {
                bidOrdersMap.put(order.getId(), order);
            }
            recalculateVolume(order.getPrice(), order.getAction(), order.getVolume());
        }
    }

    /**
     * Метод удаления ордера по его id.
     * @param id идентификатор.
     */
    public void deleteOrderById(String id) {
        Order order = null;
        if(askOrdersMap.keySet().contains(id)) {
            order = askOrdersMap.get(id);
            askOrdersMap.remove(id);
        } else if(bidOrdersMap.keySet().contains(id)) {
            order = bidOrdersMap.get(id);
            bidOrdersMap.remove(id);
        }
        if(order != null) {
            recalculateVolume(order.getPrice(), order.getAction(), order.getVolume() * negative);
        }
    }

    private boolean recalculateOrders(Order order) {
        Boolean isContinueAdd = true;
        Set<String> idsToDelete = new HashSet<>();
        if(actionAsk.equals(order.getAction())) {
            for(Order bidOrder : bidOrdersMap.values()) {
                if (bidOrder.getPrice() <= order.getPrice()) {
                    if(bidOrder.getVolume() <= order.getVolume()) {
                        idsToDelete.add(bidOrder.getId());
                        recalculateVolume(bidOrder.getPrice(), actionBid, bidOrder.getVolume() * negative);
                        bidOrder.decreaseVolume(bidOrder.getVolume());
                        order.decreaseVolume(bidOrder.getVolume());
                    } else {
                        recalculateVolume(bidOrder.getPrice(), actionBid, order.getVolume() * negative);
                        bidOrder.decreaseVolume(order.getVolume());
                        order.decreaseVolume(order.getVolume());
                    }
                }
                if(order.getVolume() == 0) {
                    isContinueAdd = false;
                    break;
                }
            }
        } else if(actionBid.equals(order.getAction())) {
            for (Order askOrder : askOrdersMap.values()) {
                if (askOrder.getPrice() >= order.getPrice()) {
                    if (askOrder.getVolume() <= order.getVolume()) {
                        idsToDelete.add(askOrder.getId());
                        recalculateVolume(askOrder.getPrice(), actionAsk, askOrder.getVolume() * negative);
                        order.decreaseVolume(askOrder.getVolume());
                        askOrder.decreaseVolume(askOrder.getVolume());
                    } else {
                        recalculateVolume(askOrder.getPrice(), actionAsk, order.getVolume() * negative);
                        askOrder.decreaseVolume(order.getVolume());
                        order.decreaseVolume(order.getVolume());
                    }
                }
                if (order.getVolume() == 0) {
                    isContinueAdd = false;
                    break;
                }
            }
        }

        for(String id : idsToDelete) {
            deleteOrderById(id);
        }

        return isContinueAdd;
    }

    /**
     * Метод пересчета объемов для таблицы заявок.
     * @param price цена.
     * @param action действие.
     * @param volume объем.
     */
    private void recalculateVolume(Integer price, String action, Integer volume) {
        if(!volumesMap.keySet().contains(price)) {
            volumesMap.put(price, new Volumes(0, 0));
        }
        Volumes volumes = volumesMap.get(price);
        if(actionAsk.equals(action)) {
            volumes.ask = volumes.ask + volume;
        } else if (actionBid.equals(action)) {
            volumes.bid = volumes.bid + volume;
        }
        if(volumes.ask == 0 && volumes.bid == 0) {
            volumesMap.remove(price);
        } else {
            volumesMap.put(price, volumes);
        }
    }

    /**
     * Метод вывода таблицы заявок.
     */
    public void info() {
        System.out.println(name);
        System.out.printf("%-10s %-10s %-10s%n", "ask", "price", "bid");
        for(Integer price : volumesMap.keySet()) {
            Volumes volumes = volumesMap.get(price);
            String ask = volumes.ask == 0 ? "-" : String.valueOf(volumes.ask);
            String bid = volumes.bid == 0 ? "-" : String.valueOf(volumes.bid);
            System.out.printf("%-10s %-10s %-10s%n", ask, price, bid);
        }
        System.out.println();
    }

    /**
     * Вспомогательный класс для таблицы заявок.
     */
    private class Volumes {

        Integer ask;
        Integer bid;

        /**
         * Конструктор.
         * @param ask объем покупок.
         * @param bid объем продаж.
         */
        public Volumes(Integer ask, Integer bid) {
            this.ask = ask;
            this.bid = bid;
        }
    }
}
