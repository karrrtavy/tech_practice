package com.example.sber;

// fivth task
class PizzaOrder {
    private String name;
    private String addressDelivery;
    enum Size { SMALL, MEDIUM, BIG };
    private Size size;
    private boolean needSauce;

    public boolean acceptOrder;

    public PizzaOrder(String name, Size size, boolean needSauce, String addressDelivery) {
        this.name = name;
        this.size = size;
        this.addressDelivery = addressDelivery;
        this.acceptOrder = false;
        this.needSauce = needSauce;
    }

    public String getName() {
        return name;
    }
    public String getAddressDelivery() {
        return addressDelivery;
    }
    public Size getSize() {
        return size;
    }
    public boolean isNeedSauce() {
        return needSauce;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddressDelivery(String addressDelivery) {
        this.addressDelivery = addressDelivery;
    }
    public void setSize(Size size) {
        this.size = size;
    }
    public void setNeedSauce(boolean needSauce) {
        this.needSauce = needSauce;
    }

    public void order() {
        if (acceptOrder) {
            System.out.println("Заказ уже был принят");
        } else {
            acceptOrder = true;
            if (needSauce) System.out.println("Заказ принят: " + size + " пицца с соусом на адрес" + addressDelivery);
            else System.out.println("Заказ принят: " + size + " пицца без соуса на адрес " + addressDelivery);
        }
    }
    public void cancel() {
        if (acceptOrder) {
            acceptOrder = false;
            System.out.println("Заказ отменен");
        } else {
            System.out.println("Заказ не был принят");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // fivth task
        System.out.println("Fivth task:");
        PizzaOrder order1 = new PizzaOrder("4 сыра", PizzaOrder.Size.BIG, false, "Галкинская 1");

        order1.order();
        order1.order();

        order1.cancel();
        order1.cancel();
    }
}