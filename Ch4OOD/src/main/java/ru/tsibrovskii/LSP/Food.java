package ru.tsibrovskii.LSP;

import java.util.Date;

/**
 * Класс продуктов.
 */
public abstract class Food {

    public String name;
    public Date expiryDate;
    public Date createDate;
    public double price;
    public double discount;
    public boolean canReproduce;
    public boolean isFreeze;

}
