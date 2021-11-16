package com.behavioral.design.pattern;

import java.util.Scanner;

/**
 * Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers.
 * Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
 * The Chain of Responsibility pattern allows a number of classes to attempt to handle a request independently.
 * JDK example is Try catch. Here every catch block is kind of a processor to process that particular exception.
 * So when any exception occurs in the try block, its send to the first catch block to process.
 * If the catch block is not able to process it, it forwards the request to next object in chain i.e next catch block.
 * ATM dispenser is the right example of this
 */
public class ChainOfResponsibilityDesignPattern {
    private DispenseChain c1;

    public ChainOfResponsibilityDesignPattern() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }
    public static void main(String[] args) {
        ChainOfResponsibilityDesignPattern atmDispenser = new ChainOfResponsibilityDesignPattern();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }

    }

}




class Currency {

    private int amount;

    public Currency(int amt){
        this.amount=amt;
    }

    public int getAmount(){
        return this.amount;
    }
}



interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    public void dispense(Currency cur);
}


class Dollar50Dispenser implements DispenseChain {

private DispenseChain chain;

@Override
public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
        }

@Override
public void dispense(Currency cur) {
        if(cur.getAmount() >= 50){
        int num = cur.getAmount()/50;
        int remainder = cur.getAmount() % 50;
        System.out.println("Dispensing "+num+" 50$ note");
        if(remainder !=0) this.chain.dispense(new Currency(remainder));
        }else{
        this.chain.dispense(cur);
        }
        }

        }



class Dollar20Dispenser implements DispenseChain{

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 20){
            int num = cur.getAmount()/20;
            int remainder = cur.getAmount() % 20;
            System.out.println("Dispensing "+num+" 20$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
        }else{
            this.chain.dispense(cur);
        }
    }

}


class Dollar10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain=nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if(cur.getAmount() >= 10){
            int num = cur.getAmount()/10;
            int remainder = cur.getAmount() % 10;
            System.out.println("Dispensing "+num+" 10$ note");
            if(remainder !=0) this.chain.dispense(new Currency(remainder));
        }else{
            this.chain.dispense(cur);
        }
    }

}