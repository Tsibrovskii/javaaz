package ru.tsibrovskii.TradeTask;

public class Order {

    private String id;
    private String book;
    private String type;
    private String action;
    private Integer price;
    private Integer volume;

    private final String typeAdd = "add";
    private final String typeDelete = "delete";
    private final String actionBid = "bid";
    private final String actionAsk = "ask";

    public Order(String id, String book, String action, Integer price, Integer volume) {
        this.id = id;
        this.book = book;
        this.type = this.typeAdd;
        this.action = action;
        this.price = price;
        this.volume = volume;
    }

    public String getId() {
        return this.id;
    }

    public String getBook() {
        return this.book;
    }

    public String getAction() {
        return this.action;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Integer getVolume() {
        return this.volume;
    }

    public void decreaseVolume(Integer number) {
        this.volume = this.volume - number;
        checkVolume();
    }

    private void checkVolume() {
        if(this.volume == 0 && this.type == typeAdd) {
            this.type = typeDelete;
        }
    }
}
