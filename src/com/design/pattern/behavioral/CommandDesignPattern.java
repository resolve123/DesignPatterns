package com.design.pattern.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * In a classic implementation, the command pattern requires implementing four components: the Command, the Receiver, the Invoker, and the Client.
 */
public class CommandDesignPattern {
    /**
     * It is client
     * @param args
     */
    public static void main(String[] args) {
        //it is the receiver which have command imlementaion
        Stock abcStock = new Stock();
        //These are command object which execute the command
        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);
//Broker which invokes the command
        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}

/**
 * Create a command interface. Which has actual command
 */
interface Order {
    void execute();
}

/**
 * Create a request class. Its the receiver where exist the actual implementation of command
 */
class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+", quantity " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}

/**
 * Create concrete classes implementing the Order interface
 * This is doing actual command processing
 */
class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }


}

/**
 * Create concrete classes implementing the Order interface
 * This is the command
 */

class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}

/**
 * It is the invoker
 */
class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){

        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}