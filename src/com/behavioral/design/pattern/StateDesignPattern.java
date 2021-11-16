package com.behavioral.design.pattern;

/**
 * State design pattern is used when an Object change its behavior based on its internal state.
 * If we have to change the behavior of an object based on its state,

 * Suppose we want to implement a TV Remote with a simple button to perform action. If the State is ON, it will turn on the TV and if state is OFF, it will turn off the TV.
 * State Pattern Context is the class that has a State reference to one of the concrete implementations of the State. Context forwards the request to the state object for processing
 */
public class StateDesignPattern {
    public static void main(String args[]){
        TVContext context = new TVContext();
        State tvStartState = new TVStartState();
        State tvStopState = new TVStopState();

        context.setState(tvStartState);
        context.doAction();


        context.setState(tvStopState);
        context.doAction();

    }
}

interface State {

    public void doAction();
}


class TVStartState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned ON");
    }

}



class TVStopState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }

}


/**
 * State Design Pattern Context Implementation
 */
class TVContext implements State {

    private State tvState;

    public void setState(State state) {
        this.tvState=state;
    }

    public State getState() {
        return this.tvState;
    }

    @Override
    public void doAction() {
        this.tvState.doAction();
    }

}


