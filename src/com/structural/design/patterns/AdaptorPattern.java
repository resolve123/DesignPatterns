package com.structural.design.patterns;

/**
 * An Adapter pattern acts as a connector between two incompatible interfaces that otherwise cannot be connected directly.
 * An Adapter wraps an existing class with a new interface so that it becomes compatible with the client’s interface.
 *
 * The main motive behind using this pattern is to convert an existing interface into another interface that the client expects.
 * It's usually implemented once the application is designed.
 *
 * Consider a scenario in which there is an app that's developed in the US which returns the top speed of luxury cars in miles per hour (MPH).
 * Now we need to use the same app for our client in the UK that wants the same results but in kilometers per hour (km/h).
 */
public class AdaptorPattern {

    public static void main(String s[]) {
        BMW bmw = new BMW();
        MovableAdapter adaptor = new MovableAdapterImpl(bmw);
       System.out.println( adaptor.getSpeed());
    }

}

interface Movable {
    // returns speed in MPH
    double getSpeed();
}

class BMW implements Movable {

    @Override
    public double getSpeed() {
        return 268;
    }
}

/**
 * This is the adaptor interface
 */
interface MovableAdapter {
    // returns speed in KM/H
    double getSpeed();
}


class MovableAdapterImpl implements MovableAdapter {
    /**
     * Here we are using composition for Movable , we can use inheritance also.
     * We are providing adaptor on top of this object
     */

    private Movable luxuryCars;

   public MovableAdapterImpl(Movable luxuryCars){
       this.luxuryCars =luxuryCars;
   }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(luxuryCars.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}


